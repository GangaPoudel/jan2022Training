package com.ganga.proxypattern;

public class RealInternet implements Internet{

	@Override
	public void connect(String host) {
		System.out.println("Internet is Connecting" + host);
		
	}
	

}
