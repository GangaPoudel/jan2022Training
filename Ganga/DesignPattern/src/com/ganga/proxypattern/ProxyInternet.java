package com.ganga.proxypattern;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
	  private Internet internet = new RealInternet();
	    private static List<String> bannedSites;
	      
	    static
	    {
	        bannedSites = new ArrayList<String>();
	        bannedSites.add("abc.com");
	        bannedSites.add("def.com");
	        bannedSites.add("ijk.com");
	        bannedSites.add("ABC");
	    }

		@Override
		public void connect(String host) throws Exception{
			 if(bannedSites.contains(host.toLowerCase()))
		        {
		            throw new Exception("Access Denied");
		        }
			 else if(bannedSites.contains("www.goggle.com")) {
				 System.out.println("Access Granted");
			 }
		          
		        internet.connect(host);
		    }
		}
      
