package bigbox.presentation;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import bigbox.business.Store;
import bigbox.business.StoreSales;
import bigbox.db.DAOFactory;
import bigbox.db.StoreConstants;
import bigbox.db.StoreDAO;
import bigbox.db.StoreDB;
import bigbox.db.StoreSalesDAO;
import bigbox.util.Validator;

public class BigBoxApp implements StoreConstants {
	private static StoreDAO storeDAO = null;
	private static StoreSalesDAO storesalesDAO = null;
	public static Scanner sc = null;

	public static void main(String[] args) {

		System.out.println("Welcome to Big Box App\n");

		Scanner sc = new Scanner(System.in);

		storeDAO = DAOFactory.getStoreDAO();
		storesalesDAO = DAOFactory.getStoreSalesDAO();

		displayMenu();
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			action = Validator.getString(sc, "Enter an Option ");

			System.out.println();

			if (action.equalsIgnoreCase("list"))
				displayAllStores();
			else if (action.equalsIgnoreCase("div"))
				displayAllStoresforDivision();
			else if (action.equalsIgnoreCase("Add") || (action.equalsIgnoreCase("add")))
				addStore();
			else if (action.equalsIgnoreCase("del") || (action.equalsIgnoreCase("delete")))
				deleteStore();
			else if (action.equalsIgnoreCase("help") || (action.equalsIgnoreCase("menu")))
				displayMenu();
			else if (action.equalsIgnoreCase("StSales") || (action.equalsIgnoreCase("store sales")))
				displayStoreSales();
			else if (action.equalsIgnoreCase("DivSales") || (action.equalsIgnoreCase("division sales")))
				displayDivisionSales();
			else if (action.equalsIgnoreCase("StSalesYr") || (action.equalsIgnoreCase("Store Sales for year")))
				displayStoreSalesforYear();
			else if (action.equalsIgnoreCase("exit"))
				System.out.println("GoodBye!!\n");

			else
				System.out.println("Error!! Not a valid Command.\n ");

		}

	}

	private static void deleteStore() {
		Scanner sc = new Scanner(System.in);
		// String division = Validator.getString(sc, "Enter a division number
		// ");
		String store = Validator.getString(sc, "Enter a store number ");

		System.out.println();

		{
			boolean Success = storeDAO.deleteStore(store);

			if (Success)

				System.out.println(store + " has been deleted.\n");

			else
				System.out.println("Error! Unable to delete store\n");
		}

	}

	private static void addStore() {
		Scanner sc = new Scanner(System.in);

		int id = Validator.getInt(sc, "Enter an Id ");
		String division = Validator.getStringNumeric(sc, "Enter a division number ", 3);
		String store = Validator.getStringNumeric(sc, "Enter a store number ", 5);
		double sales = 0.0;
		String Name = Validator.getString(sc, "Enter Name of Store ");
		String Address = Validator.getString(sc, "Enter Address of Store ");
		String City = Validator.getString(sc, "Enter City ");
		String State = Validator.getString(sc, "Enter State ");
		String Zipcode = Validator.getString(sc, "Enter zipcode ");

		Store s = new Store(id, division, store, sales, Name, Address, City, State, Zipcode);

		storeDAO.addStore(s);

		System.out.println();
		System.out.println(store + "has been added.\n");

	}

	private static void displayAllStoresforDivision() {
		Scanner sc = new Scanner(System.in);
		String division = Validator.getString(sc, "Enter Division Number : ");
		System.out.println("Store List");
		ArrayList<Store> storelist = storeDAO.getAllStoresByDivision(division);

		for (Store store : storelist) {
			System.out.println(store.getId() + "\t" + store.getDivision() + "\t" + store.getStore() + "\t"
					+ store.getName() + "\t" + store.getAddress() + "\t" + store.getCity() + "\t" + store.getState()
					+ "\t" + store.getZipcode());
		}

	}

	private static void displayAllStores() {
		System.out.println(" STORE LIST");

		ArrayList<Store> storelist = storeDAO.getAllStores();

		for (Store store : storelist) {
			System.out.println(store.getId() + "\t" + store.getDivision() + "\t" + store.getStore() + "\t"
					+ store.getName() + "\t" + store.getAddress() + "\t" + store.getCity() + "\t" + store.getState()
					+ "\t" + store.getZipcode());
		}
	}

	private static void displayStoreSales() {
		Scanner sc = new Scanner(System.in);
		String division = Validator.getString(sc, "Enter a division number: ",3);
		String store = Validator.getString(sc, "Enter a store number: ",5);

		double stsa = storesalesDAO.getStoresales(division, store);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		if (stsa<=0) {
			System.out.println("Error... no sales for division: "+division+", store: "+store);
		} else {
			System.out.println("Store sales = "+currency.format(stsa));
		}
		System.out.println();
	}

	private static void displayDivisionSales() {
		Scanner sc = new Scanner (System.in);
		String division = Validator.getString(sc, "Enter a division number: ", 3);
		
		double disa =storesalesDAO.getDivisionSales(division);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		if (disa<=0) {
			System.out.println("Error... no sales for division: "+division);
		} else {
			System.out.println("Total sales = "+ currency.format(disa));
		}
		System.out.println();
		

	}

	private static void displayStoreSalesforYear() {

	}

	private static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("list    - List all stores");
		System.out.println("Div    - List of all stores for this division");
		System.out.println("add     - Add a store");
		System.out.println("del     - Delete a store");
		System.out.println("help    - Show this menu");
		System.out.println("StSales   - Total sales of a particular store");
		System.out.println("StSalesYr - Total sales for a particular store for particular year");
		System.out.println("DivSales - Total sales for entire division");
		System.out.println("exit    - Exit this application\n");
	}

}
