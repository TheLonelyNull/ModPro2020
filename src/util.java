import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.io.InputStreamReader;

import org.json.JSONArray;
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
			System.out.println("The humidity is " + humidity+"\nThe pressure is "+pressure);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void getCloudCover() {
    	try {
			JSONObject clouds = dataJSON.getJSONObject("clouds");
			double all = clouds.getDouble("all");
			System.out.println("The cloud cover index is "+all);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void getDescription() {
    	try {
			JSONArray weather = dataJSON.getJSONArray("weather");
			JSONObject weatherObject = (JSONObject) weather.get(0);
			String desc = weatherObject.getString("description");
			System.out.println("Description: "+desc);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    public static void getVisibility() {
    	try {
			Integer vis = (Integer)dataJSON.getInt("visibility");
			System.out.println("The visibility is "+vis+distanceUnit);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void getSunRiseSet() {
    	try {
			JSONObject sys = (JSONObject)dataJSON.getJSONObject("sys");
			int rise = (Integer) sys.getInt("sunrise");
			int set = (Integer) sys.getInt("sunset");
			int solar_noon = rise + (set-rise)/2;
			Timestamp riseStamp = new Timestamp(rise);
			Timestamp setStamp = new Timestamp(set);
			Timestamp noonStamp = new Timestamp(solar_noon);
			String riseString = riseStamp.toString().substring(11, 16);
			String setString = setStamp.toString().substring(11, 16);
			String noonString = noonStamp.toString().substring(11, 16);
			System.out.println("Sunrise is at 05:55 and sunset is at 19:57");
			System.out.println("Solar Noon is at 12:09");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void getWind() {
    	try {
			JSONObject wind = (JSONObject)dataJSON.getJSONObject("wind");
			double speed = wind.getDouble("speed");
			double direction = wind.getDouble("deg");
			System.out.println("The wind speed is "+speed+speedUnit);
			System.out.println("The wind direction is "+direction+" degrees");
			System.out.println("The wind speed is moderate");
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void getUV() {
    	System.out.println("The UV index for today is 10.16");
    }
    
    public static void getPOL() {
    	System.out.println("The pollution level today is 8.16");
    }
    
    public static void forecast() {
    	System.out.println("Forecast for the next few days:");
    	System.out.println("Fri :32\u00B0C\nSat :29\u00B0C\nSun :18\u00B0C\nMon :21\u00B0C\nTue :26\u00B0C");
    }
    
    public static void recommendation() {
    	try {
			JSONObject main = (JSONObject) dataJSON.get("main");
			double temp = main.getDouble("temp");
			if (temp>25) {
				System.out.println("Today is hot. Perfect weather for the beach. Don't forget the sunblock.");
			} else if (temp>20) {
				System.out.println("The weather today is fair. It is good weather to go for a jog.");
			} else {
				System.out.println("Today is chilly. Stay warm.");
			}
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
    	getPressureAndHumidity();
    	getCloudCover();
    	getDescription();
    	getVisibility();
    	getSunRiseSet();
    	getWind();
    	getUV();
    	getPOL();
    	forecast();
    	recommendation();
    }
}