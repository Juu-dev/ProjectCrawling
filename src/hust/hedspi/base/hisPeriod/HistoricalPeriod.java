package hust.hedspi.base.hisperiod;

import java.util.ArrayList;
import java.util.List;

public class HistoricalPeriod {
	String name;
	String year;
	String content;
	List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
	
	// Constructor
	public HistoricalPeriod() {}
	
	public HistoricalPeriod(String name) {
		super();
		this.name = name;
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

	public List<HistoricalChildPeriod> getChildPeriodList() {
		return childPeriodList;
	}

	public void setChildPeriodList(List<HistoricalChildPeriod> childPeriodList) {
		this.childPeriodList = childPeriodList;
	}

	// Methods
	
	
	void getData() {
		
	}

		
}