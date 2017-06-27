package bigbox.business;

public class Facility {
	
	private int id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	
	{
		id = 0;
		name ="";
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
	 @Override
	    public String toString()
	    {
		 return "id: "+ id +"\n"+
		 		"name: "+ name +"\n"+
				"address: "+ address +"\n"+
		 		"city: "+ city + "\n"+
				"state: "+state +"\n"+
		 		"zipcode: "+ zipcode +"\n";
	    }


}