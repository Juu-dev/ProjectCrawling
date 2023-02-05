package hust.hedspi.crawling.figure;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hust.hedspi.base.hisfigure.HistoricalFigure;
import hust.hedspi.crawling.Crawling;

public class FiguresCrawling extends Crawling {
	// get url list
	public List<String> getUrlList(String url, String query, String preUrl) {
		List<String> urlList = new ArrayList<String>();

		connectToWeb(url);
		
		Elements resultQuery = crawlingData(query);
		for (Element figure : resultQuery) {
			String newUrl = preUrl + figure.attr("href");
			
			urlList.add(newUrl);
		}
		return urlList;
	}
	
	// Figure Crawling
	public List<HistoricalFigure> figureDynasty(List<String> urlList, boolean king, String job, String nameDynasty) {
		List<HistoricalFigure> hisFigureList = new ArrayList<HistoricalFigure>();

		String query1 = "h1#firstHeading > span";
		String query2 = "div.mw-parser-output > p";
		
		for (String newUrl: urlList) {
			connectToWeb(newUrl);
			
			String nameFigure = crawlingData(query1).text();
			String contentFigure = crawlingData(query2).text();
			boolean isKing = king;
			String jobFigure = job;
			String nameDynastyFigure = new String(nameDynasty);
			
			HistoricalFigure hisFigure = new HistoricalFigure(nameFigure, contentFigure, isKing, jobFigure, nameDynastyFigure);
			hisFigureList.add(hisFigure);
		}
		
		return hisFigureList;
	}
}
