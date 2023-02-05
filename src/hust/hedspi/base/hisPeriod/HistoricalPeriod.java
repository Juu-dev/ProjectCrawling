package hust.hedspi.base.hisperiod;

import java.util.ArrayList;
import java.util.List;

public class HistoricalPeriod {
	private String name;
	private String year;
	private String content;
	private List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
	
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
	public boolean searchCondition(HistoricalChildPeriod period, String input) {
	    boolean condition = period.getName() != null ? period.getName().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    condition = period.getYear() != null ? period.getYear().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    condition = period.getContent() != null ? period.getContent().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    return false;
	}
	
	public List<HistoricalChildPeriod> searchChildPeriod(String input) {
		List<HistoricalChildPeriod> resultSearch = new ArrayList<HistoricalChildPeriod>();
		
		for (HistoricalChildPeriod childPeriod: childPeriodList) {
			if (searchCondition(childPeriod, input)) {
				resultSearch.add(childPeriod);
			}
		}
		return resultSearch;
	}

		
}