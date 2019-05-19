package com.stock.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Stock implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String stockName;
	private String stockValue;
	
	public Stock() {
		super();
	}
	public Stock(String stockName, String stockValue) {
		super();
		this.stockName = stockName;
		this.stockValue = stockValue;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockValue() {
		return stockValue;
	}
	public void setStockValue(String stockValue) {
		this.stockValue = stockValue;
	}
	
	/**
	 * Two stocks are equal if their stockName is same.
	 */
	@Override
	public boolean equals(Object obj) {
		return (this.stockName.equalsIgnoreCase(((Stock) obj).stockName));
	}
	
	
	@Override
	public String toString() {
		return "Stock [stockName=" + stockName + ", stockValue=" + stockValue + "]";
	}
	
	
	public static void main(String[] args) {
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();
		stock1.stockName = "Adani";
		stock1.stockValue = "43342342";
		
		stock2.stockName = "adani";
		stock2.stockValue = "8979879";
		
		List<Stock> list = new ArrayList<Stock>();
		list.add(stock1);
		list.add(stock2);
		System.out.println(list);
		System.out.println(list.contains(stock2));
	}
}
