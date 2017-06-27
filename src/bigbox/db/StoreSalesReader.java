package bigbox.db;

import java.util.ArrayList;

import bigbox.business.StoreSales;

public interface StoreSalesReader {
	
	double getStoresales(String division, String store);
	ArrayList<StoreSales> getStoresalesforyear();
	double getDivisionSales(String InDiv);
	boolean validateDivision(String division);
	boolean validateStore(String Store);
	

}
