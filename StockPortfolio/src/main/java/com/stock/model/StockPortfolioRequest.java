package com.stock.model;

import java.io.Serializable;
import java.util.List;

public class StockPortfolioRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String clientId;
	private List<Stock> stock;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public List<Stock> getStock() {
		return stock;
	}
	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "PortfolioRequest [clientId=" + clientId + ", stockName=" + stock + "]";
	}

}
