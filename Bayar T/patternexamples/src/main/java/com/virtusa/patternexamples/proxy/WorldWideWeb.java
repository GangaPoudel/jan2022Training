package com.virtusa.patternexamples.proxy;

public class WorldWideWeb implements Internet{
	private String url;
	public WorldWideWeb(String url) {
		this.url = url;
	}
	@Override
	public void connect() {
		System.out.println("Trying connection to " + this.url + "...");
	}

}
