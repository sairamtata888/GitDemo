package Utils;

public enum endPoints {

	AddPlaceAPI("/maps/api/place/add/json");
	String ep;
	
	endPoints(String ep) {
		this.ep =ep;
	}
	
	public String getEndPoint() {
		return ep;
	}
}
