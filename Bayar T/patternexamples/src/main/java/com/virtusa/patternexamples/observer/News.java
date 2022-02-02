package com.virtusa.patternexamples.observer;

import java.util.ArrayList;
import java.util.List;

public class News {
	public String news;
	private List<Channel> channels = new ArrayList<>();
	
	public void addObserver(Channel chan) {
		this.channels.add(chan);
	}
	
	public void deleteObserver(Channel chan) {
		this.channels.remove(chan);
	}
	
	public void setNews(String news) {
		this.news = news;
		for(Channel chan : this.channels) {
			chan.update(news);
		}
	}
	
	public String getNews() {
		return this.news;
	}

}
