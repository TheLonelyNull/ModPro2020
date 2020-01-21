public class Main {
	public void print() {
		original();
		getCurrentTemp();
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
}