package crawling;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NguyenDynasty extends CrawlingFigure {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		JSONArray list = new JSONArray();
		Document doc = crawl("https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_nh%C3%A0_Nguy%E1%BB%85n");
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
			FigureInfo.put("job", "Võ tướng");
			FigureInfo.put("dynasty", "Nhà Nguyễn");
			JSONObject newFigure = new JSONObject();
			newFigure.put(name, FigureInfo);
			list.add(newFigure);
		}
		doc = crawl("https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:C%C3%B4ng_ch%C3%BAa_nh%C3%A0_Nguy%E1%BB%85n");
		Figures = doc.select("div.mw-category-group > ul > li > a");
		int i=0;
		for (Element e : Figures) {
			++i;
			if (i<7) continue;
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
			FigureInfo.put("job", "Công chúa");
			FigureInfo.put("dynasty", "Nhà Nguyễn");
			JSONObject newFigure = new JSONObject();
			newFigure.put(name, FigureInfo);
			list.add(newFigure);
		}
		doc = crawl("https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_h%E1%BA%ADu_nh%C3%A0_Nguy%E1%BB%85n");
		Figures = doc.select("div.mw-category-group > ul > li > a");
		i=0;
		for (Element e : Figures) {
			++i;
			if (i<2) continue;
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
			FigureInfo.put("job", "Hoàng hậu");
			FigureInfo.put("dynasty", "Nhà Nguyễn");
			JSONObject newFigure = new JSONObject();
			newFigure.put(name, FigureInfo);
			list.add(newFigure);
		}
		doc = crawl("https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_t%E1%BB%AD_nh%C3%A0_Nguy%E1%BB%85n");
		Figures = doc.select("div.mw-category-group > ul > li > a");
		i=0;
		for (Element e : Figures) {
			++i;
			if (i==11) continue;
			String url ="https://vi.wikipedia.org"+e.attr("href");
			Document doc1 = crawl(url);
			Elements Figures1 = doc.select("div.mw-category-group > ul > li > a");
			for (Element e1 : Figures1) {
				JSONObject FigureInfo = new JSONObject();
				String name = e1.attr("title");
				FigureInfo.put("name",name);
				Element Figure = doc1.select("div.mw-parser-output > p").first();
				FigureInfo.put("content",Figure.text());
				FigureInfo.put("date", null);
				FigureInfo.put("culturalFestival", null);
				FigureInfo.put("historicalEvents", null);
				FigureInfo.put("isKing", "false");
				FigureInfo.put("job", "Hoàng tử");
				FigureInfo.put("dynasty", "Nhà Nguyễn");
				JSONObject newFigure = new JSONObject();
				newFigure.put(name, FigureInfo);
				list.add(newFigure);
			}
		}
		doc = crawl("https://vi.wikipedia.org/w/index.php?title=Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_nh%C3%A0_Nguy%E1%BB%85n&pageuntil=Ph%E1%BA%A1m+Huy+Quang#mw-pages");
		Figures = doc.select("div.mw-category-group > ul > li > a");
		i=0;
		for (Element e : Figures) {
			++i;
			if (i<5) continue;
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
			FigureInfo.put("job", "Quan lại");
			FigureInfo.put("dynasty", "Nhà Nguyễn");
			JSONObject newFigure = new JSONObject();
			newFigure.put(name, FigureInfo);
			list.add(newFigure);
		}
		doc = crawl("https://vi.wikipedia.org/w/index.php?title=Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_nh%C3%A0_Nguy%E1%BB%85n&pagefrom=Ph%E1%BA%A1m+Huy+Quang#mw-pages");
		Figures = doc.select("div.mw-category-group > ul > li > a");
		i=0;
		for (Element e : Figures) {
			++i;
			if (i<5) continue;
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
			FigureInfo.put("job", "Quan lại");
			FigureInfo.put("dynasty", "Nhà Nguyễn");
			JSONObject newFigure = new JSONObject();
			newFigure.put(name, FigureInfo);
			list.add(newFigure);
		}
		try (FileWriter file = new FileWriter("historicalFigure.json")) {
			file.write(list.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
