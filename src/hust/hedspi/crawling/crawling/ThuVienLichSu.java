package crawling;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ThuVienLichSu extends CrawlingFigure{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		JSONArray list = new JSONArray();
		for (int i=1; i<=41; i++) {
			Document doc = crawl("https://thuvienlichsu.com/nhan-vat?page="+i);
			Elements Figures = doc.select("a.click");
			for (Element e : Figures) {
				JSONObject FigureInfo = new JSONObject();
				String url ="https://thuvienlichsu.com"+e.attr("href");
				String text = e.select("h3").text();
				String name;
				String date;
				if (text.indexOf("(")==-1) {
					name = text;
					date = "? - ?";
				} else {
					name = text.substring(0, text.indexOf("("));
					date = text.substring(text.indexOf("(")+1, text.indexOf(")"));
				}
				FigureInfo.put("name", name);
				FigureInfo.put("date", date);
				Document doc1 = crawl(url);
				if (doc1==null) continue;
				Element Figure = doc1.select("div.card-body > p.card-text").first();
				FigureInfo.put("content",Figure.text());
				FigureInfo.put("culturalFestival", null);
				Elements event = doc1.select("div.card-body > table > tbody > tr > td > a");
				FigureInfo.put("historicalEvents", event.text());
				FigureInfo.put("isKing", null);
				FigureInfo.put("job", null);
				FigureInfo.put("dynasty", null);
				JSONObject newFigure = new JSONObject();
				newFigure.put(name, FigureInfo);
				list.add(newFigure);
			}
		}
		try (FileWriter file = new FileWriter("historicalFigure.json",true)) {
			file.write(list.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
