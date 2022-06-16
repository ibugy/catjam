package com.ibugy.catjam.twitch;

import com.ibugy.catjam.twitch.model.TwitchOauthToken;

public interface TwitchOauthApiService {

	TwitchOauthToken getAccessToken(String clientId, String clientSecret);
}
