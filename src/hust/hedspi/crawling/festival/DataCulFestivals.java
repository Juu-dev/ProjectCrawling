package hust.hedspi.crawling.festival;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hust.hedspi.base.culfestival.CulturalFestival;
import hust.hedspi.base.culfestival.CulturalFestivals;
import hust.hedspi.base.hisfigure.HistoricalFigure;
import hust.hedspi.crawling.Crawling;
import hust.hedspi.crawling.DataHisInterface;
//import hust.hedspi.crawling.figure.DataHisFigures;

public class DataCulFestivals implements DataHisInterface {
	
	private CulturalFestivals culVNFestivals  = new CulturalFestivals();
	
	public List<CulturalFestival> getListFestival1() {
		List<CulturalFestival> listCulFestivals = new ArrayList<CulturalFestival>();
		
		String url = "https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam#Danh_s%C3%A1ch_m%E1%BB%99t_s%E1%BB%91_l%E1%BB%85_h%E1%BB%99i";
		String query = "table.prettytable.wikitable tr";
		
//		DataHisFigures figureList = new DataHisFigures();
		Crawling data = new Crawling();
		
		data.connectToWeb(url);
		
		Elements rawTr =  data.crawlingData(query);
		// remove header
		rawTr.remove(0); 
		
//		List<HistoricalFigure> hisFigures = figureList.getAllFigures2();
		
		for (Element tr : rawTr) {
			String nameFes = tr.child(2).text().trim();
			String dateFes = tr.child(0).text().trim();
			String locationFes = tr.child(1).text().trim();
			List<String> historicalFigures =  new ArrayList<String>(Arrays.asList(tr.child(4).text().split(",")));
			List<HistoricalFigure> figuresList = new ArrayList<HistoricalFigure>();
			
			// set figures
//			for (String figure: historicalFigures) {
//				for (HistoricalFigure hisFigure: hisFigures) {
//					if (figure.contains(hisFigure.getName())) {
//						figuresList.add(hisFigure);
//					}
//				}
//			}
			
			CulturalFestival culFes = new CulturalFestival(nameFes, dateFes, locationFes, historicalFigures, figuresList);
			culFes.setHisFigList(String.join(", ", historicalFigures));
			listCulFestivals.add(culFes);
		}
		
		return listCulFestivals;
	}
	
	public void getListFestival2() {
		culVNFestivals.addElement(getListFestival1());
	}
	
	// main method
	@Override
	public void crawlingAndSaveToFile(File file) throws Exception {
		
		getListFestival2();
		
		// Write JSON file to the root folder
		ObjectMapper mapper = new ObjectMapper();
		try {
      	
			if (file != null) {	
      		// System.out.println("Lưu đối tượng dưới dạng json vào file json");
	      	mapper.writerWithDefaultPrettyPrinter()
	                  .writeValue(file, culVNFestivals);
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