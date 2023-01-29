package hust.hedspi.main;

import hust.hedspi.crawling.HistoricalCrawling;
import hust.hedspi.screen.SearchScreen;
import hust.hedspi.search.Search;

public class Main {
	public static void main(String args[]) {
		HistoricalCrawling hisCraw = new HistoricalCrawling();
		
		try {
			hisCraw.hisCrawling();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		new SearchScreen();
		
	}
}
