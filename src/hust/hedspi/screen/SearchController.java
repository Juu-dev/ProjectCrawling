package hust.hedspi.screen;

import java.util.ArrayList;
import java.util.List;

import hust.hedspi.base.culfestival.CulturalFestival;
import hust.hedspi.base.hisevent.HistoricalEvent;
import hust.hedspi.base.hisfigure.HistoricalFigure;
import hust.hedspi.base.hisperiod.HistoricalChildPeriod;
import hust.hedspi.base.hisperiod.HistoricalDynasty;
import hust.hedspi.base.hisperiod.HistoricalPeriod;
import hust.hedspi.base.hissite.HistoricalSite;
import hust.hedspi.search.Search;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchController {
	// Custom Attribute
	int opTionSearchResult = 1;
	Search searchHistory = new Search();

	
    @FXML
    private ToggleGroup LinhVuc;

    @FXML
    private TextField inputSearchBar;
    
    // table Figure
    @FXML
    private TableView<HistoricalFigure> tableFig;
    
    @FXML
    private TableColumn<HistoricalFigure, String> figContentCol;

    @FXML
    private TableColumn<HistoricalFigure, String> figDynastyCol;

    @FXML
    private TableColumn<HistoricalFigure, String> figJobCol;

    @FXML
    private TableColumn<HistoricalFigure, String> figNameCol;

    @FXML
    private TableColumn<HistoricalFigure, String> figTimeCol;
    
    // table Festival
    @FXML
    private TableView<CulturalFestival> tbFest;
    
    @FXML
    private TableColumn<CulturalFestival, String> festFigureCol;

    @FXML
    private TableColumn<CulturalFestival, String> festLocationCol;

    @FXML
    private TableColumn<CulturalFestival, String> festNameCol;

    @FXML
    private TableColumn<CulturalFestival, String> festTimeCol;
    
    // table Event
    @FXML
    private TableView<HistoricalEvent> tbEvent;
    
    @FXML
    private TableColumn<HistoricalEvent, String> eventContentCol;

    @FXML
    private TableColumn<HistoricalEvent, String> eventFigureCol;

    @FXML
    private TableColumn<HistoricalEvent, String> eventLocationCol;
    
    @FXML
    private TableColumn<HistoricalEvent, String> eventDynastyCol;

    @FXML
    private TableColumn<HistoricalEvent, String> eventNameCol;

    @FXML
    private TableColumn<HistoricalEvent, String> eventTimeCol;
    
    // table Site
    @FXML
    private TableView<HistoricalSite> tbSite;
    
    @FXML
    private TableColumn<HistoricalSite, String> siteContentCol;

    @FXML
    private TableColumn<HistoricalSite, String> siteFigureCol;

    @FXML
    private TableColumn<HistoricalSite, String> siteLocationCol;

    @FXML
    private TableColumn<HistoricalSite, String> siteNameCol;

    @FXML
    private TableColumn<HistoricalSite, String> siteTimeCol;
    
    // table dynasty
    @FXML
    private TableView<HistoricalDynasty> tbDynasty;
    
    @FXML
    private TableColumn<HistoricalDynasty, String> dynContentCol;

    @FXML
    private TableColumn<HistoricalDynasty, String> dynFiguresCol;

    @FXML
    private TableColumn<HistoricalDynasty, String> dynKingsCol;

    @FXML
    private TableColumn<HistoricalDynasty, String> dynNameCol;

    @FXML
    private TableColumn<HistoricalDynasty, String> dynTimeCol;
    
    @FXML
    private TableColumn<HistoricalDynasty, String> dynNameCountryCol;
    
    // table Child period
    @FXML
    private TableView<HistoricalChildPeriod> tbChildPeriod;
    
    @FXML
    private TableColumn<HistoricalChildPeriod, String> cperContentCol;

    @FXML
    private TableColumn<HistoricalChildPeriod, String> cperNameCol;

    @FXML
    private TableColumn<HistoricalChildPeriod, String> cperTimeCol;

    // table period
    @FXML
    private TableView<HistoricalPeriod> tbPeriod;
    
    @FXML
    private TableColumn<HistoricalPeriod, String> perContentCol;

    @FXML
    private TableColumn<HistoricalPeriod, String> perNameCol;

    @FXML
    private TableColumn<HistoricalPeriod, String> perTimeCol;
    
    
    
    @FXML
    void onClickMenuItem1(ActionEvent event) {
    	System.out.println("On Click Menu Item 1");
    	opTionSearchResult = 1;
    }

    @FXML
    void onClickMenuItem2(ActionEvent event) {
    	System.out.println("On Click Menu Item 2");
    	opTionSearchResult = 2;
    }

    @FXML
    void onClickMenuItem3(ActionEvent event) {
    	System.out.println("On Click Menu Item 3");
    	opTionSearchResult = 3;
    }

    @FXML
    void onClickMenuItem4(ActionEvent event) {
    	System.out.println("On Click Menu Item 4");
    	opTionSearchResult = 4;
    }

    @FXML
    void onClickMenuItem5(ActionEvent event) {
    	System.out.println("On Click Menu Item 5");
    	opTionSearchResult = 5;
    }

    @FXML
    void onClickMenuItem6(ActionEvent event) {
    	System.out.println("On Click Menu Item 6");
    	opTionSearchResult = 6;
    }
    	
	@FXML
    public void onClickSearchBtn(ActionEvent event) {
    	List<HistoricalPeriod> hisPer = new ArrayList<HistoricalPeriod>();
    	List<HistoricalChildPeriod> hisChildPer = new ArrayList<HistoricalChildPeriod>();
    	List<HistoricalDynasty> hisDyn = new ArrayList<HistoricalDynasty>();
    	List<HistoricalEvent> hisEvent = new ArrayList<HistoricalEvent>();
    	List<CulturalFestival> culFest = new ArrayList<CulturalFestival>();
    	List<HistoricalFigure> hisFig = new ArrayList<HistoricalFigure>();
    	List<HistoricalSite> hisSite = new ArrayList<HistoricalSite>();
    	
    	String valueTF = inputSearchBar.getText();
    	
    	switch (opTionSearchResult) {
			case 1: {
				// search dynasty
				hisPer = searchHistory.searchPeriod(valueTF);
				if (hisPer.size() == 0) {
					hisChildPer = searchHistory.searchChildPeriod(valueTF);
					if (hisChildPer.size() == 0) {
						hisDyn = searchHistory.searchDynasty(valueTF);
					}
					else {
						for (HistoricalChildPeriod childPer: hisChildPer) {
							hisDyn.addAll(childPer.getDynastyList());
						}
					}
				}
				else {
					for (HistoricalPeriod per: hisPer) {
						hisChildPer.addAll(per.getChildPeriodList());
					}
					for (HistoricalChildPeriod childPer: hisChildPer) {
						hisDyn.addAll(childPer.getDynastyList());
					}
				}
				for (HistoricalChildPeriod childPer: hisChildPer) {
					hisEvent.addAll(childPer.getEventList());
				}
				for (HistoricalDynasty dyn: hisDyn) {
					hisFig.addAll(dyn.getHistoricalFigures());
				}
				for (HistoricalDynasty dyn: hisDyn) {
					hisFig.addAll(dyn.getHistoricalFigures());
				}
				for (HistoricalFigure fig: hisFig) {
					culFest.addAll(fig.getListCulFestival());
					hisSite.addAll(fig.getListHisSite());
				}
				
				// search event
				hisEvent.addAll(searchHistory.searchEvent(valueTF));
				if (hisEvent != null) {
					for (HistoricalEvent event1: hisEvent) {
						hisFig.addAll(event1.getFiguresList());
					}
				}
				
				// search festival
				culFest.addAll(searchHistory.searchFestival(valueTF));
				if (culFest != null) {
					for (CulturalFestival fest: culFest) {
						hisFig.addAll(fest.getFiguresList());
					}
				}
				
				// search site
				hisSite.addAll(searchHistory.searchSite(valueTF));
				if (hisSite != null) {
					for (HistoricalSite site: hisSite) {
						hisFig.addAll(site.getFiguresList());
					}
				}
				
				// search fig
				hisFig.addAll(searchHistory.searchFigure(valueTF));			
				
				break;
			}
			case 2: {
				hisFig = searchHistory.searchFigure(valueTF);
				break;
			}
			case 3: {
				hisSite = searchHistory.searchSite(valueTF);
				if (hisSite != null) {
					for (HistoricalSite site: hisSite) {
						hisFig.addAll(site.getFiguresList());
					}
				}
				break;
			}
			case 4: {
				hisPer = searchHistory.searchPeriod(valueTF);
				if (hisPer.size() == 0) {
					hisChildPer = searchHistory.searchChildPeriod(valueTF);
					if (hisChildPer.size() == 0) {
						hisDyn = searchHistory.searchDynasty(valueTF);
					}
					else {
						for (HistoricalChildPeriod childPer: hisChildPer) {
							hisDyn.addAll(childPer.getDynastyList());
						}
					}
				}
				else {
					for (HistoricalPeriod per: hisPer) {
						hisChildPer.addAll(per.getChildPeriodList());
					}
					for (HistoricalChildPeriod childPer: hisChildPer) {
						hisDyn.addAll(childPer.getDynastyList());
					}
				}
				for (HistoricalChildPeriod childPer: hisChildPer) {
					hisEvent.addAll(childPer.getEventList());
				}
				for (HistoricalDynasty dyn: hisDyn) {
					hisFig.addAll(dyn.getHistoricalFigures());
				}
				for (HistoricalFigure fig: hisFig) {
					culFest.addAll(fig.getListCulFestival());
					hisSite.addAll(fig.getListHisSite());
				}
				break;
			}
			case 5: {
				culFest.addAll(searchHistory.searchFestival(valueTF));
				if (culFest != null) {
					for (CulturalFestival fest: culFest) {
						hisFig.addAll(fest.getFiguresList());
					}
				}
				break;
			}
			case 6: {
				hisEvent.addAll(searchHistory.searchEvent(valueTF));
				if (hisEvent != null) {
					for (HistoricalEvent event1: hisEvent) {
						hisFig.addAll(event1.getFiguresList());
					}
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: ");
		}
    	
    	
    	ObservableList<HistoricalFigure> hisFigObser = FXCollections.observableArrayList(hisFig);
    	ObservableList<HistoricalDynasty> hisDynObser = FXCollections.observableArrayList(hisDyn);
    	ObservableList<HistoricalEvent> hisEventObser = FXCollections.observableArrayList(hisEvent);
    	ObservableList<CulturalFestival> culFestObser = FXCollections.observableArrayList(culFest);
    	ObservableList<HistoricalSite> hisSiteObser = FXCollections.observableArrayList(hisSite);
    	ObservableList<HistoricalChildPeriod> hisChildPerObser= FXCollections.observableArrayList(hisChildPer);
    	ObservableList<HistoricalPeriod> hisPerObser = FXCollections.observableArrayList(hisPer);
    	
    	tableFig.setItems(hisFigObser);
    	tbEvent.setItems(hisEventObser);
    	tbFest.setItems(culFestObser);
    	tbSite.setItems(hisSiteObser);
    	tbPeriod.setItems(hisPerObser);
    	tbChildPeriod.setItems(hisChildPerObser);
    	tbDynasty.setItems(hisDynObser);
    }
    
    @FXML
    public void initialize () {
    	figTimeCol.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("date"));
    	figNameCol.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("name"));
    	figJobCol.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("job"));
    	figDynastyCol.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("nameDynasty"));
    	figContentCol.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("content"));
    	
    	festTimeCol.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("date"));
    	festNameCol.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("name"));
    	festLocationCol.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("location"));
    	festFigureCol.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("hisFigList"));
    	
    	eventTimeCol.setCellValueFactory(new PropertyValueFactory<HistoricalEvent, String>("date"));
    	eventNameCol.setCellValueFactory(new PropertyValueFactory<HistoricalEvent, String>("name"));
    	eventLocationCol.setCellValueFactory(new PropertyValueFactory<HistoricalEvent, String>("location"));
    	eventFigureCol.setCellValueFactory(new PropertyValueFactory<HistoricalEvent, String>("hisFigList"));
    	eventContentCol.setCellValueFactory(new PropertyValueFactory<HistoricalEvent, String>("content"));
    	eventDynastyCol.setCellValueFactory(new PropertyValueFactory<HistoricalEvent, String>("nameDynasty"));
    	
    	siteTimeCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("date"));
    	siteNameCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("name"));
    	siteLocationCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("location"));
    	siteFigureCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("hisFigList"));
    	siteContentCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("content"));
    	
    	dynTimeCol.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("year"));
    	dynNameCol.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("name"));
    	dynNameCountryCol.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("nameCountry"));
    	dynKingsCol.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("hisKingList"));
    	dynFiguresCol.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("hisFigList"));
    	dynContentCol.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("content"));
    	
    	cperNameCol.setCellValueFactory(new PropertyValueFactory<HistoricalChildPeriod, String>("name"));
    	cperTimeCol.setCellValueFactory(new PropertyValueFactory<HistoricalChildPeriod, String>("year"));
    	cperContentCol.setCellValueFactory(new PropertyValueFactory<HistoricalChildPeriod, String>("content"));
    	
    	perTimeCol.setCellValueFactory(new PropertyValueFactory<HistoricalPeriod, String>("year"));
    	perNameCol.setCellValueFactory(new PropertyValueFactory<HistoricalPeriod, String>("name"));
    	perContentCol.setCellValueFactory(new PropertyValueFactory<HistoricalPeriod, String>("content"));
    	
    	searchHistory.searchMain();
    }

}
