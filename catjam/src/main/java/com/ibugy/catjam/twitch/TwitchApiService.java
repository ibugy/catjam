package com.ibugy.catjam.twitch;

import com.ibugy.catjam.twitch.model.TwitchUserInfo;

public interface TwitchApiService {

	TwitchUserInfo getUser(String user, String oauthToken, String clientId);
}
