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
		boolean condition = figure.getName() != null ? figure.getName().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		condition = figure.getDate() != null ? figure.getDate().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		condition = figure.getContent() != null ? figure.getContent().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		condition = figure.getNameDynasty() != null ? figure.getNameDynasty().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		condition = figure.getJob() != null ? figure.getJob().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		
		return false;
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
