package hust.hedspi.crawling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hust.hedspi.base.CulturalFestival;

public class Festival {
	static String url = "https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam#Danh_s%C3%A1ch_m%E1%BB%99t_s%E1%BB%91_l%E1%BB%85_h%E1%BB%99i";
	static String query = "table.prettytable.wikitable tr";
	
	// Method
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Crawling data = new Crawling();
		
		data.connectToWeb(url);
		
		Elements rawTr =  data.crawlingData(query);
//		remove header
		rawTr.remove(0);
		
		List<CulturalFestival> CulturalFestivals  = new ArrayList<CulturalFestival>(); 
		
		for (Element tr : rawTr) {
			CulturalFestivals.add(new CulturalFestival(
					tr.child(0).text(), 
					tr.child(1).text(), 
					tr.child(2).text(), 
					new ArrayList<String>(Arrays.asList(tr.child(4).text().split(","))))
			);
		}
		
		JSONArray arr = new JSONArray();
		for (CulturalFestival fest: CulturalFestivals) {
			JSONObject obj = new JSONObject();
			obj.put("name", fest.getName());
			obj.put("date", fest.getDate());
			obj.put("location", fest.getLocation());
			obj.put("historicalFigure", fest.getHistoricalFigureList());
			arr.add(obj);
		}
		
//		Write JSON file to the root folder	
		try (FileWriter file = new FileWriter("CulturalFestivals.json")) {
            file.write(arr.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
