package com.ibugy.catjam.twitch;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibugy.catjam.twitch.model.TwitchOauthToken;

import feign.Body;
import feign.Param;

/**
 * This interface is currently unused due to Feign lacking some functionality like setting the body of a get request
 * 
 */
@FeignClient(name = "TwitchOauthApiService", url = "${twitch.oauth.url}")
public interface TwitchOauthApiServiceFeignImpl extends TwitchOauthApiService {

	@RequestMapping(method = RequestMethod.POST, value = "/oauth2/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@Body("client_id:{clientId}&client_secret:{clientSecret}&grant_type:client_credentials")
	public TwitchOauthToken getAccessToken(@Param String clientId, @Param String clientSecret);
}
