public class Main {
	public void print() {
		original();
		getWindSummary();
	}
	
	public static void getWindSummary() {
    	try {
			JSONObject wind = (JSONObject)dataJSON.getJSONObject("wind");
			double speed = wind.getDouble("speed");
			double direction = wind.getDouble("deg");
			System.out.println("The wind speed is moderate");
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
}