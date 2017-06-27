package bigbox.business;

public class StoreSales 
{
	private int ID;
	private int storeId;
	private int year;
	private int week;
	private double sales;
	
	{
		ID =0;
		storeId = 0;
		year = 0;
		week = 0;
		sales = 0.0;
	
	}

	public int getID() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}
	
	public StoreSales (int inID, int instoreID,int inYear, int inWeek, int inSales)
	{
		setId(inID);
		setStoreId(instoreID);
		setYear(inYear);
		setWeek(inWeek);
		setSales(inSales);
	}

	public static void add(Store s) {
		// TODO Auto-generated method stub
		
	}	
		
	}
