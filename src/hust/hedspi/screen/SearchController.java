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
    private TableColumn<HistoricalFigure, String> figEventCol;

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
    private TableColumn<CulturalFestival, List<String>> festFigureCol;

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
    private TableColumn<HistoricalEvent, List<String>> eventFigureCol;

    @FXML
    private TableColumn<HistoricalEvent, String> eventLocationCol;

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
    private TableColumn<HistoricalSite, String> siteEventCol;

    @FXML
    private TableColumn<HistoricalSite, String> siteFestivalCol;

    @FXML
    private TableColumn<HistoricalSite, List<String>> siteFigureCol;

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
    private TableColumn<HistoricalDynasty, List<String>> dynFiguresCol;

    @FXML
    private TableColumn<HistoricalDynasty, List<String>> dynKingsCol;

    @FXML
    private TableColumn<HistoricalDynasty, String> dynNameCol;

    @FXML
    private TableColumn<HistoricalDynasty, String> dynTimeCol;
    
    
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
//			hisPer = searchHistory.searchPeriod(valueTF);
//			if (hisPer == null) {
//				hisChildPer = searchHistory.searchChildPeriod(valueTF);
//			}
//			if (hisChildPer == null && hisPer == null) {
//				hisDyn = searchHistory.searchDynasty(valueTF);
//			}
			hisDyn = searchHistory.searchDynasty(valueTF);
			hisEvent = searchHistory.searchEvent(valueTF);
			culFest = searchHistory.searchFestival(valueTF);
			hisFig = searchHistory.searchFigure(valueTF);
			hisSite = searchHistory.searchSite(valueTF);
			break;
		}
		case 2: {
			hisFig = searchHistory.searchFigure(valueTF);
			break;
		}
		case 3: {
			hisSite = searchHistory.searchSite(valueTF);
			break;
		}
		case 4: {
//			hisPer = searchHistory.searchPeriod(valueTF);
//			if (hisPer == null) {
//				hisChildPer = searchHistory.searchChildPeriod(valueTF);
//			}
//			if (hisChildPer == null && hisPer == null) {
//				hisDyn = searchHistory.searchDynasty(valueTF);
//			}
			hisDyn = searchHistory.searchDynasty(valueTF);
			break;
		}
		case 5: {
			culFest = searchHistory.searchFestival(valueTF);
			break;
		}
		case 6: {
			hisEvent = searchHistory.searchEvent(valueTF);
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
    	
    	tableFig.setItems(hisFigObser);
    	tbEvent.setItems(hisEventObser);
    	tbFest.setItems(culFestObser);
    	tbSite.setItems(hisSiteObser);
//    	if (hisPer != null) {
//    		tbDynasty.setItems((ObservableList<HistoricalFigure>) hisPer);
//		}
//    	else if (hisChildPer != null) {
//    		tbDynasty.setItems((ObservableList<HistoricalFigure>) hisChildPer);
//		}
//    	else if (hisDyn != null) {
//    		tbDynasty.setItems((ObservableList<HistoricalDynasty>) hisDyn);
//    	}
    	tbDynasty.setItems(hisDynObser);
    }
    
    @FXML
    public void initialize () {
    	figTimeCol.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("date"));
    	figNameCol.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("name"));
    	figJobCol.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("job"));
    	figEventCol.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("historicalEvents"));
    	figDynastyCol.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("nameDynasty"));
    	figContentCol.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("content"));
    	
    	festTimeCol.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("date"));
    	festNameCol.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("name"));
    	festLocationCol.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("location"));
    	festFigureCol.setCellValueFactory(new PropertyValueFactory<CulturalFestival, List<String>>("historicalFigures"));
    	
    	eventTimeCol.setCellValueFactory(new PropertyValueFactory<HistoricalEvent, String>("date"));
    	eventNameCol.setCellValueFactory(new PropertyValueFactory<HistoricalEvent, String>("name"));
    	eventLocationCol.setCellValueFactory(new PropertyValueFactory<HistoricalEvent, String>("location"));
    	eventFigureCol.setCellValueFactory(new PropertyValueFactory<HistoricalEvent, List<String>>("historicalFigure"));
    	eventContentCol.setCellValueFactory(new PropertyValueFactory<HistoricalEvent, String>("content"));
    	
    	siteTimeCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("date"));
    	siteNameCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("name"));
    	siteLocationCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("location"));
    	siteFigureCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, List<String>>("historicalFigure"));
    	siteFestivalCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("culturalFestival"));
    	siteEventCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("historicalEvents"));
    	siteContentCol.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("content"));
    	
    	dynTimeCol.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("year"));
    	dynNameCol.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("name"));
    	dynKingsCol.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, List<String>>("nameCountry"));
    	dynFiguresCol.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, List<String>>("historicalSiteList"));
    	dynContentCol.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("content"));
    	
    	searchHistory.searchMain();
    }

}
