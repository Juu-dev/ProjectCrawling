package crawling;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ChuaTrinhDynasty extends CrawlingFigure {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		JSONArray list = new JSONArray();
		Document doc = crawl("https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_ch%C3%BAa_Tr%E1%BB%8Bnh");
		Elements Figures = doc.select("div.mw-category-group > ul > li > a");
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
			FigureInfo.put("job", "Võ tướng của chúa Trịnh");
			FigureInfo.put("dynasty", "Trịnh - Nguyễn phân tranh");
			JSONObject newFigure = new JSONObject();
			newFigure.put(name, FigureInfo);
			list.add(newFigure);
		}
		doc = crawl("https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_ch%C3%BAa_Tr%E1%BB%8Bnh");
		Figures = doc.select("div.mw-category-group > ul > li > a");
		int i=0;
		for (Element e : Figures) {
			++i;
			if (i<3) continue;
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
			FigureInfo.put("job", "Quan lại chúa Trịnh");
			FigureInfo.put("dynasty", "Trịnh - Nguyễn phân tranh");
			JSONObject newFigure = new JSONObject();
			newFigure.put(name, FigureInfo);
			list.add(newFigure);
		}
		try (FileWriter file = new FileWriter("historicalFigure.json",true)) {
			file.write(list.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}