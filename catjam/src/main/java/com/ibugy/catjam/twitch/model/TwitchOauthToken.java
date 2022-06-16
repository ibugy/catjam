package com.ibugy.catjam.twitch.model;

import lombok.Data;

@Data
public class TwitchOauthToken {

	private String accessToken;
	private int expiresIn;
	private String tokenType;
}
