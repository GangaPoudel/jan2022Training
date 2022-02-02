package com.ganga.currencyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CurrencyapiApplication {
		public static void main(String[] args) {
			SpringApplication.run(CurrencyapiApplication.class, args);
//			ConfigurableApplicationContext applicationContext = SpringApplication.run(CurrencyapiApplication.class, args);
//			CurrencyService currService = applicationContext.getBean("currService", CurrencyService.class);
//			currService.deleteAllCurrency();
//			Currency americanCurrency = new Currency("Dollar","America","$");
//			// Trying to include an image file
//			String fileName = "/images/dollar.png";
//			System.out.println("trying to get image as stream: " + fileName);
//			byte[] currencyImage = null;
//			Resource resource = new ClassPathResource(fileName);
//			InputStream is;
//			try {
//				is = resource.getInputStream();
//				currencyImage = FileCopyUtils.copyToByteArray(is);
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			americanCurrency.setCurrencyImage(currencyImage);
//			System.out.println(americanCurrency.getCountryName());
//			Currency testAdd = currService.addCurrency(americanCurrency);
//			System.out.println(testAdd.getCurrencySymbol());
//
//
//		}

	}
}
