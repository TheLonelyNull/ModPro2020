public class Main {
	public void print() {
		original();
		getVisibility();
	}
	
	public static void getVisibility() {
    	try {
			Integer vis = (Integer)dataJSON.getInt("visibility");
			System.out.println("The visibility is "+vis+distanceUnit);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}