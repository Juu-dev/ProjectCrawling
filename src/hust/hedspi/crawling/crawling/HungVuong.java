package crawling;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HungVuong extends CrawlingFigure {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		JSONArray list = new JSONArray();
		Document doc = crawl("https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:H%C3%B9ng_V%C6%B0%C6%A1ng");
		Elements Figures = doc.select("div.navbox > table > tbody > span > a");
		for (Element e : Figures) {
			JSONObject FigureInfo = new JSONObject();
			String url ="https://vi.wikipedia.org"+e.attr("href");
			String name = e.attr("title");
			FigureInfo.put("name",name);
			Document doc1 = crawl(url);
			Element Figure = doc1.select("div.mw-parser-output > p").first();
			FigureInfo.put("content",Figure.text());
			FigureInfo.put("date", null);
			FigureInfo.put("culturalFestival", null);
			FigureInfo.put("historicalEvents", null);
			FigureInfo.put("isKing", "false");
			FigureInfo.put("job", "Vua Hùng");
			FigureInfo.put("dynasty", "Hùng Vương - Văn Lang");
			JSONObject newFigure = new JSONObject();
			newFigure.put(name, FigureInfo);
			list.add(newFigure);
		}
	
			JSONObject FigureInfo = new JSONObject();
			String url ="https://vi.wikipedia.org/wiki/An_D%C6%B0%C6%A1ng_V%C6%B0%C6%A1ng";
			String name = "An Dương Vương";
			FigureInfo.put("name",name);
			Document doc1 = crawl(url);
			Element Figure = doc1.select("div.mw-parser-output > p").first();
			FigureInfo.put("content",Figure.text());
			FigureInfo.put("date", null);
			FigureInfo.put("culturalFestival", null);
			FigureInfo.put("historicalEvents", null);
			FigureInfo.put("isKing", "true");
			FigureInfo.put("job", "Vua An Dương Vương");
			FigureInfo.put("dynasty", "Âu Lạc");
			JSONObject newFigure = new JSONObject();
			newFigure.put(name, FigureInfo);
			list.add(newFigure);
		
		try (FileWriter file = new FileWriter("historicalFigure.json",true)) {
			file.write(list.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
