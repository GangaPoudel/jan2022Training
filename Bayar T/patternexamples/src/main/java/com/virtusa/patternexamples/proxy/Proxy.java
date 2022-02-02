package com.virtusa.patternexamples.proxy;

public class Proxy implements Internet{
	private Internet internet;
	private String url;
	
	public Proxy(String url) {
		this.url = url;
	}
	
	@Override
	public void connect(){ 
		if(this.url.equals("a")) {
			System.out.println("no");
		} 
		else {
			internet = new WorldWideWeb(url);
			internet.connect();
		}
	}
}
