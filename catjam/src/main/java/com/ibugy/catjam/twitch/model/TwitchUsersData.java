package com.ibugy.catjam.twitch.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitchUsersData {

	private List<TwitchUserInfo> data;
}
