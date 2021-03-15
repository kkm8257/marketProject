package com.kkm.market.vo;

public class ProductVO {
	
	private int market_idx;
	private int user_idx;
	private String id; 
	private String market_img;
	private String market_kinds;
	private int market_price;
	private String reg_date;
	private String item_desc;
	private String item_title;
	
	
	//item
	
	public String getItem_title() {
		return item_title;
	}
	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}
	public String getItem_desc() {
		return item_desc;
	}
	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}
	public int getMarket_idx() {
		return market_idx;
	}
	public void setMarket_idx(int market_idx) {
		this.market_idx = market_idx;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMarket_img() {
		return market_img;
	}
	public void setMarket_img(String market_img) {
		this.market_img = market_img;
	}
	public String getMarket_kinds() {
		return market_kinds;
	}
	public void setMarket_kinds(String market_kinds) {
		this.market_kinds = market_kinds;
	}
	public int getMarket_price() {
		return market_price;
	}
	public void setMarket_price(int market_price) {
		this.market_price = market_price;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
	
}
