package hust.hedspi.crawling.figure;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hust.hedspi.base.culfestival.CulturalFestival;
import hust.hedspi.base.hisfigure.HistoricalFigure;
import hust.hedspi.base.hisfigure.HistoricalFigures;
import hust.hedspi.base.hissite.HistoricalSite;
import hust.hedspi.crawling.DataHisInterface;
import hust.hedspi.crawling.festival.DataCulFestivals;
import hust.hedspi.crawling.site.DataHisSites;

public class DataHisFigures implements DataHisInterface {
	
	private HistoricalFigures hisVNFigures = new HistoricalFigures();
	
	private ChuaNguyenDynastyCrawling chuaNguyenDyn = new ChuaNguyenDynastyCrawling();
	private ChuaTrinhDynastyCrawling chuaTrinhDyn = new ChuaTrinhDynastyCrawling();
	private DinhDynastyCrawling dinhDyn = new DinhDynastyCrawling();
	private HaiBaTrungDynastyCrawling haiBaTrungDyn = new HaiBaTrungDynastyCrawling();
	private HoDynastyCrawling hoDyn = new HoDynastyCrawling();
	private LyDynastyCrawling lyDyn = new LyDynastyCrawling();
	private NgoDynastyCrawling ngoDyn = new NgoDynastyCrawling();
	private NguyenDynastyCrawling nguyenDyn = new NguyenDynastyCrawling();
	private TaySonDynastyCrawling taySonDyn = new TaySonDynastyCrawling();
	private TienLeDynastyCrawling tienLeDyn = new TienLeDynastyCrawling();
	private TranDynastyCrawling tranDyn = new TranDynastyCrawling(); 
	
	// get all figure in VN's history
	public void getAllFigures1() {
		DataCulFestivals dataCulFes = new DataCulFestivals();
		DataHisSites dataHisSite = new DataHisSites();
		
		List<CulturalFestival> listCulFes = dataCulFes.getListFestival1();
		List<HistoricalSite> listHisSite = dataHisSite.getListSite1();
		List<HistoricalFigure> listFigure = getAllFigures2(); 
		
		for (int i=0; i<listFigure.size(); i++) {
			String nameFigure = listFigure.get(i).getName();
			List<CulturalFestival> listCulFestival = new ArrayList<CulturalFestival>();
			List<HistoricalSite> listHisSites  = new ArrayList<HistoricalSite>();
			
			for (int j=0; j<listCulFes.size(); j++) {
				List<String> nameFigInCulFes = listCulFes.get(j).getHistoricalFigures();
				
				for (int jj=0; jj<nameFigInCulFes.size(); jj++) {
					if (nameFigure.compareTo(nameFigInCulFes.get(jj)) == 0) {
						listCulFestival.add(listCulFes.get(j));
						break;
					}
				}
			}
			
			for (int k=0; k<listHisSite.size(); k++) {
				List<String> nameFigInHisSite = listHisSite.get(k).getHistoricalFigure();
				
				for (int jj=0; jj<nameFigInHisSite.size(); jj++) {
					if (nameFigure.compareTo(nameFigInHisSite.get(jj)) == 0) {
						listHisSites.add(listHisSite.get(k));
						break;
					}
				}
			}
			
			listFigure.get(i).setListCulFestival(listCulFestival);
			listFigure.get(i).setListHisSite(listHisSites);
		}
		
		hisVNFigures.addElement(listFigure);
	}

	// get all figure in VN's history
	public List<HistoricalFigure> getAllFigures2() {
		List<HistoricalFigure> figuresExp = new ArrayList<HistoricalFigure>();
		List<HistoricalFigure> allFigures = new ArrayList<HistoricalFigure>();
		
		figuresExp = tienLeDyn.crawling();
		allFigures.addAll(figuresExp);
		
		figuresExp = tranDyn.crawling();
		allFigures.addAll(figuresExp);
		
		figuresExp = taySonDyn.crawling();
		allFigures.addAll(figuresExp);
		
		figuresExp = nguyenDyn.crawling();
		allFigures.addAll(figuresExp);
		
		figuresExp = ngoDyn.crawling();
		allFigures.addAll(figuresExp);
		
		figuresExp = lyDyn.crawling();
		allFigures.addAll(figuresExp);
		
		figuresExp = hoDyn.crawling();
		allFigures.addAll(figuresExp);
		
		figuresExp = haiBaTrungDyn.crawling();
		allFigures.addAll(figuresExp);
		
		figuresExp = dinhDyn.crawling();
		allFigures.addAll(figuresExp);
		
		figuresExp = chuaTrinhDyn.crawling();
		allFigures.addAll(figuresExp);
		
		figuresExp = chuaNguyenDyn.crawling();
		allFigures.addAll(figuresExp);
		
		return allFigures;
	}

	@Override
	public void crawlingAndSaveToFile(File file) throws Exception {
		// data sites
		getAllFigures1();
		
		// Write JSON file to the root folder
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (file != null) {	
	      	mapper.writerWithDefaultPrettyPrinter()
	                  .writeValue(file, hisVNFigures);
	      	}
	      	else {
	      		throw new Exception("Error: file is null");
	      	}
	      } catch (JsonGenerationException e) {
	          e.printStackTrace();
	      } catch (JsonMappingException e) {
	          e.printStackTrace();
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	}
	
		
	
}
