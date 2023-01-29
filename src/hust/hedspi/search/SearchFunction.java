package hust.hedspi.search;

import java.util.List;

import hust.hedspi.base.culfestival.CulturalFestival;
import hust.hedspi.base.hisevent.HistoricalEvent;
import hust.hedspi.base.hisfigure.HistoricalFigure;
import hust.hedspi.base.hisperiod.HistoricalChildPeriod;
import hust.hedspi.base.hisperiod.HistoricalDynasty;
import hust.hedspi.base.hisperiod.HistoricalPeriod;
import hust.hedspi.base.hissite.HistoricalSite;

public interface SearchFunction {
	public List<HistoricalPeriod> searchPeriod(String input);
	public List<HistoricalChildPeriod> searchChildPeriod (String input);
	public List<HistoricalDynasty> searchDynasty (String input);
	
	public List<HistoricalEvent> searchEvent (String input);
	
	public List<CulturalFestival> searchFestival (String input);
	
	public List<HistoricalFigure> searchFigure (String input);
	
	public List<HistoricalSite> searchSite (String input);
	
	public void searchMain ();
}
