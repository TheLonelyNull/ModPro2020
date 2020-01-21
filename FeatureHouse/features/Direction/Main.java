public class Main {
	public void print() {
		original();
		getWindDirection();
	}
	
	public static void getWindDirection() {
    	try {
			JSONObject wind = (JSONObject)dataJSON.getJSONObject("wind");
			double speed = wind.getDouble("speed");
			double direction = wind.getDouble("deg");
			System.out.println("The wind direction is "+direction+" degrees");
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
}