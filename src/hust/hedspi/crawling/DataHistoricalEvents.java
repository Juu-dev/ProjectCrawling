package hust.hedspi.crawling;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hust.hedspi.base.HistoricalEvents;
public class DataHistoricalEvents {
	static int id=0;
	private static String urls = "https://nguoikesu.com/tu-lieu/quan-su?filter_tag[0]=&start=";
//	private static String urls = "https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_tr%E1%BA%ADn_%C4%91%C3%A1nh_trong_l%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam";

	//	private static String query = "div.mw-parser-output ul li a";
	private static String query = "div.page-header h2 > a";
	
//	private static String query1 = ".mw-page-title-main";
	private static String query1 = "div.page-header h1";
	
//	private static String query2 = "table.infobox tbody tbody tr:first-child td";
	private static String query2 = "table tbody tbody tr:first-child td:nth-child(2)";
	
//	private static String query3 = "table.infobox tbody tbody tr:nth-child(2) td";
	private static String query3 = "table tbody tbody tr:nth-child(2) td:nth-child(2)";
	
//	private static String query4 = "table.infobox tbody tbody tr:nth-child(3) td";
	private static String query4 = "table tbody tbody tr:nth-child(3) td:nth-child(2)";
	
//	private static String query5 = "td[style~=width:50%;border-right:1px dotted #aaa]";
	private static String query5 = "tbody tr:nth-child(8)";
	private static JSONArray employeeList = new JSONArray();
	
	public static String DataEdit(Elements data) {
		StringBuffer data1 = new StringBuffer(data.text());
		String time1 = new String(data1);
  		for (int i = 0; i< data1.length();i++) { 
  			if (Character.compare(data1.charAt(i),'<') == 0) {
  				for (int j =i; j < data1.length();j++) {
  					if (Character.compare(data1.charAt(j),'>') == 0) {
  						data1.delete(i, j);
  						time1 = new String(data1);
  						break;
  					}
  				}
  			}
  		}

  		time1=time1.replaceAll(">", "");
  		time1=time1.replaceAll("\u2013", "");
	
  		return time1;
	}
	
	public static void main(String[] args) {
		Crawling data = new Crawling();
		for(int i=0; i<=70;i+=5)
		{
			data.connectToWeb(urls+String.valueOf(i));
//			System.out.println(urls+String.valueOf(i));
		
			Elements historicalEvents =  data.crawlingData(query);
			for (Element historicalEvent : historicalEvents)
			{
//				String url ="https://vi.wikipedia.org"+historicalEvent.attr("href");
				String url ="https://nguoikesu.com"+historicalEvent.attr("href");
//				System.out.println(url);
				data.connectToWeb(url);
				Elements name = data.crawlingData(query1);
	            Elements time = data.crawlingData(query2);
	            Elements location = data.crawlingData(query3);
	            Elements content = data.crawlingData(query4);
	            Elements historicalFigure = data.crawlingData(query5);
	            
	            HistoricalEvents emp = new HistoricalEvents(name.text(),DataEdit(time),DataEdit(location),DataEdit(content),DataEdit(historicalFigure));
//	            System.out.println(time.text());
	            JSONObject employeeDetails = new JSONObject();
	            employeeDetails.put("id",String.valueOf(id++));
	            employeeDetails.put("name", emp.getName());
	            employeeDetails.put("time", emp.getDate());
	            employeeDetails.put("location", emp.getLocation());
	            employeeDetails.put("content", emp.getContent());
	            employeeDetails.put("historicalFigure", emp.getHistoricalFigure());
	            
	            JSONObject employeeObject = new JSONObject(); 
	            employeeObject.put(name.text(), employeeDetails);
	            employeeList.add(employeeObject);
	            try (FileWriter file = new FileWriter("employee.json")) {
	                file.write(employeeList.toJSONString()); 
	                file.flush();
	     
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
			}
		}
	}
	
}
