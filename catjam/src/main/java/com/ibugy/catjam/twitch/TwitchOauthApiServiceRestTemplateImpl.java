package com.ibugy.catjam.twitch;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibugy.catjam.twitch.model.TwitchOauthToken;

@Service
@Qualifier("TwitchOauthApiServiceRestTemplateImpl")
public class TwitchOauthApiServiceRestTemplateImpl implements TwitchOauthApiService {

	private static final Log LOG = LogFactory.getLog(TwitchOauthApiServiceRestTemplateImpl.class);
	private RestTemplate restTemplate;
	private URI apiUrl;

	public TwitchOauthApiServiceRestTemplateImpl(@Value("${twitch.oauth.url}") String apiUrlString) throws URISyntaxException {
		restTemplate = new RestTemplateBuilder().build();
		apiUrl = new URI(apiUrlString);
	}

	@Override
	public TwitchOauthToken getAccessToken(String clientId, String clientSecret) {
		String body = String.format("client_id:{%s}&client_secret:{%s}&grant_type:client_credentials", clientId, clientSecret);
		HttpEntity<String> httpEntity = new HttpEntity<>(body);
		LOG.info("Getting access token from twitch oauth api");
		LOG.info(httpEntity);
		TwitchOauthToken token = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, TwitchOauthToken.class)
			.getBody();
		return token;
	}
}
