package com.ibugy.catjam.twitch.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitchUserInfo {

	// TODO: Check the actual DATA format
	private Long id;
	@JsonProperty("broadcaster_type")
	private String broadcasterType;
	private String description;
	@JsonProperty("display_name")
	private String displayName;
	private String login;
	@JsonProperty("offline_image_url")
	private String offlineImageUrl;
	@JsonProperty("profile_image_url")
	private String profileImageUrl;
	private String type;
	@JsonProperty("view_count")
	private int viewCount;
	private String email;
	@JsonProperty("created_at")
	private Date createdAt;
}
