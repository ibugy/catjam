package com.ibugy.catjam.twitch;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibugy.catjam.twitch.model.TwitchUserInfo;
import com.ibugy.catjam.twitch.model.TwitchUsersData;

@Service
@Qualifier("TwitchApiServiceRestTemplateImpl")
public class TwitchApiServiceRestTemplateImpl implements TwitchApiService {

	private static final Log LOG = LogFactory.getLog(TwitchApiServiceRestTemplateImpl.class);
	private RestTemplate restTemplate;
	private URI apiUrl;

	public TwitchApiServiceRestTemplateImpl(@Value("${twitch.api.url}") String apiUrlString) throws URISyntaxException {
		restTemplate = new RestTemplateBuilder().build();
		apiUrl = new URI(apiUrlString);
	}

	@Override
	public TwitchUserInfo getUser(String user, String oauthToken, String clientId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Bearer" + " " + oauthToken);
		headers.add("Client-Id", clientId);
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		String requestUrl = apiUrl.toString() + "?login=" + user;
		TwitchUsersData usersData = restTemplate.exchange(requestUrl, HttpMethod.GET, httpEntity, TwitchUsersData.class)
			.getBody();
		TwitchUserInfo userInfo = usersData.getData()
			.get(0);
		LOG.info("Received users info from twitch api: " + userInfo);
		return userInfo;
	}
}
