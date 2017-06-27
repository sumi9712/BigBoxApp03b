package bigbox.business;

import java.util.ArrayList;

import bigbox.db.StoreDAO;

public class Store extends Facility {

	private String store;
	private String division;
	private double sales;

	{
	     store= "";
	     division = "";
	     sales = 0.0;
	}

	 public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public Store(int inid, String inDiv, String inStore,double insales, String inname, String inaddress, String incity, String instate,String inzipcode) {
		 setId(inid);
		 setDivision(inDiv);
		 setStore(inStore);
		 setSales(insales);
		 setName(inname);
		 setAddress(inaddress);
		 setCity(incity);
		 setState(instate);
		 setZipcode(inzipcode);
		 
	 }


		public Store(String division, String store, double parseDouble) {
		// TODO Auto-generated constructor stub
	}

	
}


