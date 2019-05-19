package com.stock.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.model.GenericResponse;
import com.stock.model.Portfolio;
import com.stock.model.Stock;
import com.stock.model.StockPortfolioRequest;
import com.stock.util.ConversionUtil;

/**
 * Handles requests for the StockPortfolio service.
 */
@RestController
public class StockPortfolioRestServices {
	
	private static final String SUCCESS = "success";
	private static final String FAILURE = "failure";
	private static final String CLIENT_ID_NOT_FOUND = "Client Id can not be left blank";
	
	private static final Logger logger = LoggerFactory.getLogger(StockPortfolioRestServices.class);
	
	//Map to store StockPortfolios, ideally we should use database
	Map<Integer, Portfolio> dummyPortfolioData = new HashMap<Integer, Portfolio>();
	
	@RequestMapping(value = RestURIConstants.REGISTER_NEW_STOCK_PORTFOLIO, method = RequestMethod.PUT)
	public GenericResponse registerStockPortfolio(@RequestBody StockPortfolioRequest portfolioRequest) {
		logger.info("Start:: registerStockPortfolio.");
		try {
			Random random = new Random();
			Integer clientId = random.nextInt(Integer.MAX_VALUE);
			Portfolio portfolio = new Portfolio();
			portfolio.setClientId(clientId);
			portfolio.setStocks(portfolioRequest.getStock());
			dummyPortfolioData.put(clientId, portfolio);
			
			String data = ConversionUtil.pojoToJSON(portfolio);
			logger.info("End:: registerStockPortfolio.");
			return new GenericResponse(SUCCESS, data);
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse(FAILURE, e.getMessage());
		}
		
	}
	
	@RequestMapping(value = RestURIConstants.UPDATE_STOCK_PORTFOLIO, method = RequestMethod.POST)
	public GenericResponse updateStockPortfolio(@RequestBody StockPortfolioRequest portfolioRequest) {
		logger.info("Start:: updateStockPortfolio.");
		try {
			if(null == portfolioRequest.getClientId() || StringUtils.isEmpty(portfolioRequest.getClientId())){
				
				return new GenericResponse(FAILURE, CLIENT_ID_NOT_FOUND);
			}else{
				Integer clientId = Integer.valueOf(portfolioRequest.getClientId());
				Portfolio dbPortfolio = dummyPortfolioData.get(clientId);
				
				dbPortfolio = updatePortfolio(dbPortfolio, portfolioRequest.getStock());
				
				String data = ConversionUtil.pojoToJSON(dbPortfolio);
				logger.info("End:: updateStockPortfolio.");
				return new GenericResponse(SUCCESS, data);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse(FAILURE, e.getMessage());
		}
		
	}
	
	private Portfolio updatePortfolio(Portfolio portfolio, List<Stock> stocks) {
		List<Stock> dbStocks = portfolio.getStocks();
		if(null != stocks && stocks.size() > 0){
			for(Stock stock : stocks){
				logger.info("logger == " + stock);
				
				if(dbStocks.contains(stock)){
					for(Stock dbStock : dbStocks){
						if(dbStock.getStockName().equalsIgnoreCase(stock.getStockName())){
							dbStock.setStockValue(stock.getStockValue());
						}
					}
				}else{
					dbStocks.add(stock);
				}
			}
		}
		
		return portfolio;
	}

	@RequestMapping(value = RestURIConstants.STOCK_PORTFOLIO, method = RequestMethod.GET)
	public GenericResponse getStockPortfolio(@PathVariable("id") int clientId) {
		logger.info("Start getStockPortfolio. ID="+clientId);
		
		try{
			Portfolio portfolio = dummyPortfolioData.get(clientId);

			String data = ConversionUtil.pojoToJSON(portfolio);
			logger.info("End:: getStockPortfolio.");
			return new GenericResponse(SUCCESS, data);
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse(FAILURE, e.getMessage());
		}
	}
	
	@RequestMapping(value = RestURIConstants.ALL_STOCK_PORTFOLIO, method = RequestMethod.GET)
	public GenericResponse getAllStockPortfolio() {
		logger.info("Start:: getAllStockPortfolio");
		
		try{
			String data = ConversionUtil.pojoToJSON(dummyPortfolioData);
			logger.info("End:: getAllStockPortfolio.");
			return new GenericResponse(SUCCESS, data);
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse(FAILURE, e.getMessage());
		}
	}
	
	@PostConstruct
	public void initiliazeSotckPortfolio(){
		
		Stock stock1 = new Stock("AAAAA", "1000$");
		Stock stock2 = new Stock("BBBBB", "5000$");
		
		List<Stock> list = new ArrayList<Stock>();
		list.add(stock1);
		list.add(stock2);
		
		Random random = new Random();
		Integer clientId = random.nextInt( Integer.MAX_VALUE );
		System.out.println("Initiliased client Id = "+clientId);
		Portfolio portfolio = new Portfolio();
		portfolio.setClientId(clientId);
		portfolio.setStocks(list);
		dummyPortfolioData.put(clientId, portfolio);
	}
}
