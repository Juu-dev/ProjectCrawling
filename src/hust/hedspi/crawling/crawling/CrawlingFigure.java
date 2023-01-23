package crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CrawlingFigure {

	public static Document crawl(String url) throws IOException {
		Document doc = null;
		try {
			doc = Jsoup
					.connect(url)
					.userAgent("Jsoup client")
					.timeout(20000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

}
