public class Main {
	public void print() {
		original();
		getWindSpeed();
	}
	
	public static void getWindSpeed() {
    	try {
			JSONObject wind = (JSONObject)dataJSON.getJSONObject("wind");
			double speed = wind.getDouble("speed");
			double direction = wind.getDouble("deg");
			System.out.println("The wind speed is "+speed+speedUnit);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
}