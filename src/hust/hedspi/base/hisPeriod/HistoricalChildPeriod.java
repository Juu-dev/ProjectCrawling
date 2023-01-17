package hust.hedspi.base.hisPeriod;

import java.util.ArrayList;
import java.util.List;

public class HistoricalChildPeriod {
	String name;
	String year;
	String content;
	List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
	// Constructor
	public HistoricalChildPeriod() {}
	
	public HistoricalChildPeriod(String name) {
		super();
		this.name = name;
	}
	
	public HistoricalChildPeriod(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}
	
	public HistoricalChildPeriod(String name, String year, String content) {
		super();
		this.name = name;
		this.year = year;
		this.content = content;
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
	
	public List<HistoricalDynasty> getDynastyList() {
		return dynastyList;
	}

	public void setDynastyList(List<HistoricalDynasty> dynastyList) {
		this.dynastyList = dynastyList;
	}

	// Methods
	void getData() {
		
	}

	
}
