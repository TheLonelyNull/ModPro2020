public class Main {
	public void print() {
		original();
		recommendation();
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
}