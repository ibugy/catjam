package com.ibugy.catjam.twitch;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibugy.catjam.twitch.model.TwitchUserInfo;

import feign.Headers;
import feign.Param;

/**
 * This interface is currently unused due to Feign lacking some functionality like setting the body of a get request
 * 
 */
@FeignClient(name = "TwitchApiService", url = "${twitch.api.url}")
@Qualifier("TwitchApiServiceFeignImpl")
public interface TwitchApiServiceFeignImpl extends TwitchApiService {

	@RequestMapping(method = RequestMethod.GET, path = "/users?login={user}")
//	@RequestLine("GET /users?login={user}")
	@Headers({ "Authorization:{tokenType} {oauthToken}", "Client-Id: {clientId}" })
	public TwitchUserInfo getUser(@Param String user, @Param String tokenType, @Param String oauthToken, @Param String clientId);
}
