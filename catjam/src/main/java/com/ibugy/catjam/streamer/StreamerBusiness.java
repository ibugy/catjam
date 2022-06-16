package com.ibugy.catjam.streamer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibugy.catjam.twitch.TwitchBusiness;
import com.ibugy.catjam.twitch.model.TwitchUserInfo;

@Service
public class StreamerBusiness {

	@Autowired
	private TwitchBusiness twitchBusiness;

	public Streamer getStreamer(String name) {
		// TODO in the future, this method will probably take the streamer from the
		// database
		TwitchUserInfo userInfo = twitchBusiness.getUserInfo(name);
		Streamer streamer = new Streamer(name, userInfo.getViewCount(), 0);
		return streamer;
	}
}
