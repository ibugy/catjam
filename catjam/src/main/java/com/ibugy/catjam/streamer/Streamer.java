package com.ibugy.catjam.streamer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Streamer {

	private String name;
	private int viewCount;
	private int avgViewCount;
}
