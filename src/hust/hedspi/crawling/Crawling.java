package hust.hedspi.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Crawling {
	private Document doc = null;
	
	// Methods
	// connect to the web where the data will be collected 
	public void connectToWeb(String url) {
        try {
            doc = Jsoup
                    .connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	// Once connected, call this methods to collect data
    public Elements crawlingData(String query) {
//            Elements lstArticles = doc != null ? doc.select(query) : null ;
    		Elements lstArticles = doc.select(query);
			return lstArticles;
    }
    
    
}

