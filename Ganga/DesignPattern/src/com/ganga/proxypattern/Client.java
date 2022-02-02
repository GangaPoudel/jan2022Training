package com.ganga.proxypattern;

public class Client {
	public static void main(String[] args) {
	Internet internet = new ProxyInternet();
    try
    {
        internet.connect(" Google.com");
        internet.connect("abc.com");
        internet.connect("www.goggle.com");
    }
    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
}

}
