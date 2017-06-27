package bigbox.business;

public class Divisions extends Facility
{

	private int id ;
	private String divisionNumber;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	
	{
		id  = 0;
		divisionNumber = "";
		name = "";
		address = "";
		city = "";
		state = "";
		zipcode = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDivisionNumber() {
		return divisionNumber;
	}

	public void setDivisionNumber(String divisionNumber) {
		this.divisionNumber = divisionNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Divisions( int inID, String indivNbr, String inName, String inAddress,String inCity,String inState, String inZipcode)
	{		
	
				setId(inID);
				setDivisionNumber(indivNbr);
				setName(inName);
				setAddress(inAddress);
				setCity(inCity);
				setState(inState);
				setZipcode(inZipcode);
	
}
}	
