public class Main {
	public void print() {
		original();
		getTempRangePrediction();
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
}