package search;

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

public class FestandFirgure {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		Scanner in = new Scanner(System.in);
		
//		find festival by name
		{
			Reader festReader = new FileReader("dataFes.json");
			JSONObject festObject = (JSONObject) parser.parse(festReader);
			JSONArray festArray= (JSONArray) festObject.get("culturalFestivals");
				System.out.print("Nhap ten le hoi muon tim: ");
				String findName = in.nextLine();
				@SuppressWarnings("rawtypes")
				Iterator i = festArray.iterator();
				while (i.hasNext()) {
					JSONObject fest = (JSONObject) i.next();
					String name = (String)fest.get("name");
					if (name.toLowerCase().contains(findName.toLowerCase())) System.out.println(fest);
				} 
		}
		
//		find figure by name
		{
			Reader FigureReader = new FileReader("dataFigues.json");
			JSONObject FigureObject = (JSONObject) parser.parse(FigureReader);
			JSONArray FigureArray= (JSONArray) FigureObject.get("hisVNFigures");
			System.out.print("Nhap ten nhan vat lich su muon tim: ");
			String findName = in.nextLine();
			@SuppressWarnings("rawtypes")
			Iterator i = FigureArray.iterator();
			while (i.hasNext()) {
				JSONObject fest = (JSONObject) i.next();
				String name = (String)fest.get("name");
				if (name.toLowerCase().contains(findName.toLowerCase())) System.out.println(fest);
			}
		}
		
	}
}
