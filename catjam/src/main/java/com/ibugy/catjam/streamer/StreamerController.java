package com.ibugy.catjam.streamer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamerController {

	@Autowired
	private StreamerBusiness streamerBusiness;

	@GetMapping("/streamers/{name}")
	public Streamer getStreamer(@PathVariable String name) {
		return streamerBusiness.getStreamer(name);
	}
}
