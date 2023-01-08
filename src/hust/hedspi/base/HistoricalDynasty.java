package hust.hedspi.base;

import java.util.ArrayList;
import java.util.List;

public class HistoricalDynasty {
	String name;
	String date;
	String content;
	List<String> historicalKings = new ArrayList<String>();
	List<String> historicalSiteList = new ArrayList<String>();
	
	// Constructor
	public HistoricalDynasty(String name, String date, String content, List<String> historicalSiteList) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.historicalSiteList = historicalSiteList;
	}

	// Getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getHistoricalSiteList() {
		return historicalSiteList;
	}

	public void setHistoricalSiteList(List<String> historicalSiteList) {
		this.historicalSiteList = historicalSiteList;
	}

	// Methods
	void getData() {
		
	}

	
}