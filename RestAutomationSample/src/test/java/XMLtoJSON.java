import org.json.JSONObject;
import org.json.XML;

public class XMLtoJSON {
	public static void main(String[] args) {
		String xml_data = "<student>"
				+ 			"<name>Divya Kolli</name>"
				+ 				"<age>22</age>"
				+ 			"</student>";
		
		//Converting XML to JSON
		JSONObject obj = XML.toJSONObject(xml_data);
		String json_data = obj.toString();
		System.out.println(json_data);
	}
}
