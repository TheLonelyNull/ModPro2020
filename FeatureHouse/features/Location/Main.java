import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
	private static String data;
	private static JSONObject dataJSON;
	private static String tempUnit;
	private static String distanceUnit;
	private static String speedUnit;

	public static void main(String[] args) {
		new Main().print();
    }
	
	public void print() {
		getDataHotel("metric");
    	if (data == null) {
    		System.out.println("An error occured");
    		System.exit(1);
    	}
    	try {
			dataJSON = new JSONObject(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getDataHotel(String unit) {
        try {
            URL url = new URL(
                    "https://api.openweathermap.org/data/2.5/weather?lat=-33.9&lon=18.8&APPID=880ad9dd2b68184f95c3057618771254&units="
                            + unit);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            data = content.toString();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        data = null;
    }
}