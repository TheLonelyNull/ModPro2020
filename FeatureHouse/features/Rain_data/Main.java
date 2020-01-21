public class Main {
	public void print() {
		original();
		getPressureAndHumidity();
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
}