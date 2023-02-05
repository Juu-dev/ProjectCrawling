package hust.hedspi.base.hisfigure;

import java.util.ArrayList;
import java.util.List;

public class HistoricalFigures {
	private List<HistoricalFigure> hisVNFigures = new ArrayList<HistoricalFigure>();

	public List<HistoricalFigure> getHisVNFigures() {
		return hisVNFigures;
	}

	public void setHisVNFigures(List<HistoricalFigure> hisVNFigures) {
		this.hisVNFigures = hisVNFigures;
	}
	
	// Methods
	public void addElement(HistoricalFigure figure) {
		hisVNFigures.add(figure);
	}
	
	public void addElement(List<HistoricalFigure> figure) {
		hisVNFigures.addAll(figure);
	}
	
	public boolean searchCondition(HistoricalFigure figure, String input) {
		boolean condition1 = figure.getName().toLowerCase().contains(input.toLowerCase());
		boolean condition2 = figure.getDate().toLowerCase().contains(input.toLowerCase());
		boolean condition3 = figure.getContent().toLowerCase().contains(input.toLowerCase());
		boolean condition4 = figure.getNameDynasty().toLowerCase().contains(input.toLowerCase());
		boolean condition5 = figure.getJob().toLowerCase().contains(input.toLowerCase());
		
		return condition1 || condition2 || condition3 || condition4 || condition5;  
	}
	
	public List<HistoricalFigure> searchFigure(String input) {
		List<HistoricalFigure> resultSearch = new ArrayList<HistoricalFigure>();
		
		for (HistoricalFigure figure: hisVNFigures) {
			if (searchCondition(figure, input)) {
				resultSearch.add(figure);
			}
		}
		return resultSearch;
	}
}
