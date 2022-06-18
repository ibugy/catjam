package com.ibugy.catjam.streamer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamerController {

	private static final Log LOG = LogFactory.getLog(StreamerController.class);
	@Autowired
	private StreamerBusiness streamerBusiness;

	@GetMapping("/streamers/{name}")
	public Streamer getStreamer(@PathVariable String name) {
		LOG.info("Received request for info on streamer: " + name);
		return streamerBusiness.getStreamer(name);
	}
}
