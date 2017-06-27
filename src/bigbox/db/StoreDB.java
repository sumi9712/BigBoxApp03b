package bigbox.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bigbox.business.Store;

import bigbox.util.DBUtil;

public class StoreDB implements StoreDAO {

	Connection connection;
	public ArrayList<Store> getAllStores() {
		String sql = "select stores.ID, stores.DivisionID ,divisions.DivisionNumber,stores.StoreNumber,stores.Name,stores.Address, stores.City,stores.State,stores.Zipcode "
				+ " from stores stores, divisions divisions " + " WHERE stores.DivisionID = divisions.ID";

		System.out.println(sql);
		ArrayList<Store> Stores = new ArrayList<>();

		try {
			connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			{
				while (rs.next()) {
					int id = rs.getInt("ID");
					String division = rs.getString("DivisionID");
					String store = rs.getString("StoreNumber");
					Double sales = 0.0;
					String name = rs.getString("Name");
					String address = rs.getString("Address");
					String city = rs.getString("City");
					String state = rs.getString("State");
					String zipcode = rs.getString("ZipCode");

					Store s = new Store(id, division, store, sales, name, address, city, state, zipcode);
					Stores.add(s);

				}
				return Stores;
			}
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}

	}

	public ArrayList<Store> getAllStoresByDivision(String inDiv) {
		String sql = "select stores.DivisionID, sales.ID,divisions.DivisionNumber,stores.StoreNumber, sales.Sales,stores.Name,stores.Address, stores.City,stores.State,stores.Zipcode "
				+ " from stores_sales sales, stores stores, divisions divisions " + " WHERE sales.ID = stores.ID "
				+ " and stores.DivisionID = divisions.ID" + " and divisions.DivisionNumber = ?";

		ArrayList<Store> Stores = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, inDiv);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String Division = rs.getString("DivisionID");
				String Store = rs.getString("StoreNumber");
				Double Sales = rs.getDouble("Sales");
				String Name = rs.getString("Name");
				String Address = rs.getString("Address");
				String City = rs.getString("City");
				String State = rs.getString("State");
				String Zipcode = rs.getString("Zipcode");

				Store s = new Store(ID, Division, Store, Sales, Name, Address, City, State, Zipcode);

				Stores.add(s);

			}
			return Stores;
		}

		catch (SQLException e) {
			System.err.println(e);
			return null;
		}

	}

	public boolean addStore(Store s) {
		String sql = "INSERT INTO Stores (ID, DivisionID, StoreNumber, Name, Address, City, State, Zipcode) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, s.getId());
			ps.setString(2, s.getDivision());
			ps.setString(3, s.getStore());
			ps.setDouble(4, s.getSales());
			ps.setString(4, s.getName());
			ps.setString(5, s.getAddress());
			ps.setString(6, s.getCity());
			ps.setString(7, s.getState());
			ps.setString(8, s.getZipcode());
			ps.executeUpdate();
			return true;
		}

		catch (SQLException e) {
			System.err.println(e);
			return false;
		}

	}

	public boolean updateStore(Store s) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteStore(String d) {
		String sql = "DELETE FROM Stores " + "WHERE StoreNumber = " + d;

		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}

	}

	@Override
	public Store getStoreByDivisionandStoreNumber(String inDiv, String inStoreNbr) {
		// TODO Auto-generated method stub
		return null;
	}

}
