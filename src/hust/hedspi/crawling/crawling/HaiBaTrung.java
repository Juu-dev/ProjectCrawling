package crawling;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HaiBaTrung extends CrawlingFigure {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		JSONArray list = new JSONArray();
		Document doc = crawl("https://vi.wikipedia.org/wiki/Hai_B%C3%A0_Tr%C6%B0ng");
		
		JSONObject FigureInfo = new JSONObject();
		String name = "Hai Bà Trưng";
		FigureInfo.put("name",name);
		Element Figure = doc.select("div.mw-parser-output > p").first();
		FigureInfo.put("content",Figure.text());
		FigureInfo.put("date", null);
		FigureInfo.put("culturalFestival", null);
		FigureInfo.put("historicalEvents", null);
		FigureInfo.put("isKing", "false");
		FigureInfo.put("job", "Nữ tướng");
		FigureInfo.put("dynasty", "1000 năm đô hộ");
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