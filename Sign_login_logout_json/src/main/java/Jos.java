
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.parser.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Jos {
	@SuppressWarnings("unchecked")
	public static int save (user e) {
		int s=0;
		JSONArray js=new JSONArray();
		JSONObject obj = new JSONObject();
		String n=e.getName();
		String n1="";
		obj.put("name", e.getName());
		obj.put("password", e.getPassword());
		obj.put("city", e.getCity());
		obj.put("gender", e.getGender());
		
		try {
			JSONParser parser=new JSONParser();
			JSONArray a = null;
			try {
				a = (JSONArray)parser.parse(new FileReader("C:\\Users\\Lenova\\jos.json"));
			} 
			catch (IOException | ParseException e3)
			{
				e3.printStackTrace();
			}
			if(a==null) {
			FileWriter jos=new  FileWriter("C:\\Users\\Lenova\\jos.json",true);
			//js.add(obj);
			//jos.write(js.toJSONString()); 
	        //jos.close();
			}
			else
			{
				for(Object o: a){
		        	JSONObject person = (JSONObject) o;
		        	n1=(String)person.get("name");
		        	if(n1.equals(n)) {
		        		s=1;
		        		return s;
		        	}
		        	js.add(person);
				}

				//FileWriter jos=new  FileWriter("C:\\Users\\Lenova\\jos.json",false);
				//js.add(obj);
				//jos.write(js.toJSONString()); 
		        //jos.close();

			}
			
		} catch (IOException e1) {
			System.out.print(e1);
			return 1;
			
		}
		return s;
		
		}
	@SuppressWarnings("unchecked")
	public static void add(user e) {
		JSONArray js=new JSONArray();
		JSONObject obj = new JSONObject();
		String n=e.getName();
		String n1="";
		obj.put("name", e.getName());
		obj.put("password", e.getPassword());
		obj.put("city", e.getCity());
		obj.put("gender", e.getGender());
		
		try {
			JSONParser parser=new JSONParser();
			JSONArray a = null;
			try {
				a = (JSONArray)parser.parse(new FileReader("C:\\Users\\Lenova\\jos.json"));
			} 
			catch (IOException | ParseException e3)
			{
				e3.printStackTrace();
			}
			if(a==null) {
			FileWriter jos=new  FileWriter("C:\\Users\\Lenova\\jos.json",true);
			js.add(obj);
			jos.write(js.toJSONString()); 
	        jos.close();
			}
			else
			{
				for(Object o: a){
		        	JSONObject person = (JSONObject) o;
		        	js.add(person);
				}

				FileWriter jos=new  FileWriter("C:\\Users\\Lenova\\jos.json",false);
				js.add(obj);
				jos.write(js.toJSONString()); 
		        jos.close();

			}
			
		} catch (IOException e1) {
			System.out.print(e1);
			
		}
		
	}
}