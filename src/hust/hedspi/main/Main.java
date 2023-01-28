package hust.hedspi.main;

import hust.hedspi.crawling.HistoricalCrawling;

public class Main {
	public static void main(String args[]) {
		HistoricalCrawling hisCraw = new HistoricalCrawling();
		
		try {
			hisCraw.hisCrawling();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
