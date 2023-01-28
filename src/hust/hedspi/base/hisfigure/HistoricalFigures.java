package hust.hedspi.base.hisfigure;

import java.util.ArrayList;
import java.util.List;

public class HistoricalFigures {
	List<HistoricalFigure> hisVNFigures = new ArrayList<HistoricalFigure>();

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
	
	public void addAllElement(List<HistoricalFigure> figure) {
		hisVNFigures.addAll(figure);
	}
	
	public HistoricalFigure searchFigure (String input) {
		for (HistoricalFigure figure: hisVNFigures) {
			if (figure.getName().toLowerCase().contains(input.toLowerCase())) {
				return figure;
			}
		}
		return null;
	}
}
