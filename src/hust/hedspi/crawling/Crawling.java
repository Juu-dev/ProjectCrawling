package hust.hedspi.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Crawling {
	private Document doc = null;
	
	// Methods
	// connect to the web where the data will be collected 
	public void connectToWeb(String url) {
        try {
            doc = Jsoup
                    .connect(url)
                    .userAgent("Jsoup client")
                    .timeout(20000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	// Once connected, call this methods to collect data
    public Elements crawlingData(String query) {
            Elements lstArticles = doc.select(query);
			return lstArticles;
    }

	
}