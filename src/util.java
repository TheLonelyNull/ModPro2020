import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;

class util {
	private static String data;
	private static JSONObject dataJSON;
	private static String tempUnit = "C";
	private static String distanceUnit = "m";
	private static String speedUnit = "km/h";
	
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

    public static void getDataLocation(String lon, String lat, String unit) {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon
                    + "&APPID=880ad9dd2b68184f95c3057618771254&units=" + unit);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            data =  content.toString();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        data =  null;
    }
    
    public static void getCurrentTemp() {
    	try {
			JSONObject main = (JSONObject) dataJSON.get("main");
			double temp = main.getDouble("temp");
			System.out.println("The current temperature is " + temp +" \u00B0"+ tempUnit);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void getRealFeelTemp() {
    	try {
			JSONObject main = (JSONObject) dataJSON.get("main");
			double temp = main.getDouble("feels_like");
			System.out.println("The temperature feels like " + temp +" \u00B0"+ tempUnit);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void getTempRangePrediction() {
    	try {
			JSONObject main = (JSONObject) dataJSON.get("main");
			double min = main.getDouble("temp_min");
			double max = main.getDouble("temp_max");
			System.out.println("The daily range is " + max +"/"+min+" \u00B0"+ tempUnit);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void getPressureAndHumidity() {
    	try {
			JSONObject main = (JSONObject) dataJSON.get("main");
			double pressure = main.getDouble("pressure");
			double humidity = main.getDouble("humidity");
			System.out.println("The daily range is " + max +"/"+min+" \u00B0"+ tempUnit);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
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
    	getCurrentTemp();
    	getRealFeelTemp();
    	getTempRangePrediction();
    }
}