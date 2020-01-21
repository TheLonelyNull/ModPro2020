public class Main {
	public void print() {
		original();
		getRealFeelTemp();
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
}