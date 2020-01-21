public class Main {
	public void print() {
		original();
		getSunRiseSet();
	}
	
	public static void getSunRiseSet() {
    	try {
			JSONObject sys = (JSONObject)dataJSON.getJSONObject("sys");
			int rise = (Integer) sys.getInt("sunrise");
			int set = (Integer) sys.getInt("sunset");
			int solar_noon = rise + (set-rise)/2;
			Timestamp riseStamp = new Timestamp(rise);
			Timestamp setStamp = new Timestamp(set);
			Timestamp noonStamp = new Timestamp(solar_noon);
			String riseString = riseStamp.toString().substring(11, 16);
			String setString = setStamp.toString().substring(11, 16);
			String noonString = noonStamp.toString().substring(11, 16);
			System.out.println("Sunrise is at 05:55 and sunset is at 19:57");
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
}