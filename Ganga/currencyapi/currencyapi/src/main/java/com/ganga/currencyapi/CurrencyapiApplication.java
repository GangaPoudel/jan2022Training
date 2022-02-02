package com.ganga.currencyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import java.io.IOException;
import java.io.InputStream;
import com.ganga.currencyapi.models.Currency;
import com.ganga.currencyapi.services.CurrencyService;


@SpringBootApplication
public class CurrencyapiApplication {
		public static void main(String[] args) {
			SpringApplication.run(CurrencyapiApplication.class, args);
//			ConfigurableApplicationContext applicationContext = SpringApplication.run(CurrencyapiApplication.class, args);
//			CurrencyService currencyService = applicationContext.getBean("currencyService", CurrencyService.class);
//			currencyService.deleteAllCurrency();
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
//			Currency testAdd = currencyService.addCurrency(americanCurrency);
//			System.out.println(testAdd.getCurrencySymbol());
//
//
		}

	}
