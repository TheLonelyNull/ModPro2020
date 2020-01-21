public class Main {
	public void print() {
		original();
		getCloudCover();
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
}