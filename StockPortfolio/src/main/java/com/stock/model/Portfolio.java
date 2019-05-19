package com.stock.model;

import java.io.Serializable;
import java.util.List;

public class Portfolio implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	private int clientId;
    private List<Stock> stocks;

	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	@Override
	public String toString() {
		return "Portfolio [clientId=" + clientId + ", stocks=" + stocks + "]";
	}

}
