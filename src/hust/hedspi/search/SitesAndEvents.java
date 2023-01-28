package hust.hedspi.search;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SitesAndEvents {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		Scanner in = new Scanner(System.in);
		
//		find eventival by name
		{
			FileReader eventReader = new FileReader("dataEvent.json");
			JSONObject eventObject = (JSONObject) parser.parse(eventReader);
			JSONArray eventArray= (JSONArray) eventObject.get("hisVNEvents");
				System.out.print("Nhap ten su kien muon tim: ");
				String findName = in.nextLine();
				@SuppressWarnings("rawtypes")
				Iterator i = eventArray.iterator();
				while (i.hasNext()) {
					JSONObject event = (JSONObject) i.next();
					String name = (String)event.get("name");
					if (name.toLowerCase().contains(findName.toLowerCase())) System.out.println(event);
				} 
		}
		
		{
			Reader SiteReader = new FileReader("dataSites.json");
			JSONObject SiteObject = (JSONObject) parser.parse(SiteReader);
			JSONArray SiteArray= (JSONArray) SiteObject.get("hisVNSites");
			System.out.print("Nhap ten di tich lich su muon tim: ");
			String findName = in.nextLine();
			@SuppressWarnings("rawtypes")
			Iterator i = SiteArray.iterator();
			while (i.hasNext()) {
				JSONObject fest = (JSONObject) i.next();
				String name = (String)fest.get("name");
				if (name.toLowerCase().contains(findName.toLowerCase())) System.out.println(fest);
			}
		}
		
	}
}