package hust.hedspi.base.hisPeriod;

import java.util.ArrayList;
import java.util.List;

public class HistoricalDynasty {
	String name;
	String year;
	String content;
	String nameCountry;
    List<String> historicalKings = new ArrayList<String>();
	List<String> historicalSiteList = new ArrayList<String>();
	
	// Constructor
	public HistoricalDynasty() {}
	
	public HistoricalDynasty(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}

	public HistoricalDynasty(String name, String year, String content) {
		super();
		this.name = name;
		this.year = year;
		this.content = content;
	}
	
	public HistoricalDynasty(String name, String year, String content, String nameCountry) {
		super();
		this.name = name;
		this.year = year;
		this.content = content;
		this.nameCountry = nameCountry;
	}

	public HistoricalDynasty(String name, String year, String content, List<String> historicalSiteList, String nameCountry, List<String> historicalKings) {
		super();
		this.name = name;
		this.year = year;
		this.content = content;
		this.historicalSiteList = historicalSiteList;
        this.historicalKings = historicalKings;
        this.nameCountry = nameCountry;
	}

	
	// Getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getHistoricalKings() {
		return historicalKings;
	}

	public void setHistoricalKings(List<String> historicalKings) {
		this.historicalKings = historicalKings;
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
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