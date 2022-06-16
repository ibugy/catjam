package com.ibugy.catjam.twitch.model;

import java.util.Date;

import lombok.Data;

@Data
public class TwitchUserInfo {

	private Long id;
	private String broadcasterType;
	private String description;
	private String displayName;
	private String login;
	private String offlineImageUrl;
	private String profileImageUrl;
	private String type;
	private int viewCount;
	private String email;
	private Date createdAt;
}
