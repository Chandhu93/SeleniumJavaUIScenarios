package partice.DDT.Vtiger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSON {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		//Step1: parse Json physical file into java object using JsonParse class
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\Dell\\Desktop\\data\\appCommonData.json"));
		
		// step2: convert object into json object using down casting
		JSONObject map = (JSONObject) obj;
		
		//step3: access value from json file using key and get method
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeOut"));
		
		
			
	}
}
