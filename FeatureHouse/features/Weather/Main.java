public class Main {
	public void print() {
		original();
		getDescription();
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
}