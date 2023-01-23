package hust.hedspi.crawling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hust.hedspi.base.HistoricalSites;

public class HistoricalSitesData {
	public static void main(String[] args) {
		String url = "https://thaiddt.github.io/historicalSites/";
		String query = "table.prettytable.wikitable tr";
		
		Crawling data = new Crawling();
		data.connectToWeb(url);
		Elements rawTr =  data.crawlingData(query);
//		remove header
		rawTr.remove(0);
		
		List<HistoricalSites> historicalSites  = new ArrayList<HistoricalSites>(); 
		
		for (Element tr : rawTr) {
			historicalSites.add(new HistoricalSites(
					tr.child(2).text(), 
					tr.child(0).text(), 
					tr.child(6).text(), 
					tr.child(1).text(),
					tr.child(3).text(),
					tr.child(4).text(),
					tr.child(5).text())
			);
		}
		
		JSONArray arr = new JSONArray();
		for (HistoricalSites hSite: historicalSites) {
			JSONObject obj = new JSONObject();
			obj.put("name", hSite.getName());
			obj.put("date", hSite.getDate());
			obj.put("content", hSite.getContent());
			obj.put("location", hSite.getLocation());
			obj.put("culturalFestival", hSite.getCulturalFestival());
			obj.put("historicalFigure", hSite.getHistoricalFigure());
			obj.put("historicalEvents", hSite.getHistoricalEvents());
			arr.add(obj);
		}
		
//		Write JSON file to the root folder	
		try (FileWriter file = new FileWriter("HistoricalSites.json")) {
            file.write(arr.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
