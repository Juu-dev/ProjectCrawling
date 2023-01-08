package hust.hedspi.crawling;

import org.jsoup.select.Elements;

public class DataHisDynasty {
	String url = "https://openedu.vn/Kho-tri-thuc/Tom-luoc-lich-su-Viet-Nam-qua-cac-thoi-dai";
	String query = "div.noidung1 > p > span#^docs-internal-guid > span";
	
	// Method
	public void main() {
		Crawling data = new Crawling();
		
		data.connectToWeb(url);
		
		Elements resultQuery =  data.crawlingData(query);
		
		System.out.println(resultQuery);
	}
	
	
}
