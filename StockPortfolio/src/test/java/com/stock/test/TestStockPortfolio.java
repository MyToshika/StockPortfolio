package com.stock.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.stock.model.Portfolio;
import com.stock.restcontroller.RestURIConstants;

@SuppressWarnings({ "unchecked", "unused" })
public class TestStockPortfolio {

	public static final String SERVER_URI = "http://localhost:8080/StockPortfolio";
	
	private static void testGetAllStockPortfolio() {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> response = restTemplate.getForObject(SERVER_URI+RestURIConstants.ALL_STOCK_PORTFOLIO, HttpEntity.class);

		String resultString = response.getBody();
		System.out.println(resultString);
	}

	private static void testRegisterStockPortfolio() {
		RestTemplate restTemplate = new RestTemplate();

		Map<Integer, Portfolio> dummyPortfolioData = new HashMap<Integer, Portfolio>();
		HttpEntity<String> response = restTemplate.postForObject(SERVER_URI+RestURIConstants.REGISTER_NEW_STOCK_PORTFOLIO, dummyPortfolioData, HttpEntity.class);
		String resultString = response.getBody();
		System.out.println(resultString);
	}
	
	private static void updateStockPortfolio() {
		RestTemplate restTemplate = new RestTemplate();

		Map<Integer, Portfolio> dummyPortfolioData = new HashMap<Integer, Portfolio>();
		HttpEntity<String> response = restTemplate.postForObject(SERVER_URI+RestURIConstants.UPDATE_STOCK_PORTFOLIO, dummyPortfolioData, HttpEntity.class);
		String resultString = response.getBody();
		System.out.println(resultString);
	}

	private static void getStockPortfolio() {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> response = restTemplate.getForObject(SERVER_URI+"/rest/getStockPortfolio/1", HttpEntity.class);
		String resultString = response.getBody();
		System.out.println(resultString);
	}

}
