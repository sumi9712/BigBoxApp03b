package bigbox.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bigbox.business.Store;
import bigbox.business.StoreSales;
import bigbox.util.DBUtil;

public class StoreSalesDB implements StoreSalesDAO {
	Connection connection;
	public double getStoresales(String division, String store) {
		String sql = "select sum(Sales) result " + " from stores_sales sales , stores stores , divisions divisions "
				+ " WHERE sales.ID = stores.ID " + " and stores.DivisionID = divisions.ID"
				+ " and divisions.DivisionNumber = ?" + " and stores.StoreNumber = ?";

		System.out.println(sql);
		try {
			connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, division);
			ps.setString(2, store);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				double sales = rs.getDouble("result");

				return sales;
			} else {
				return 0.0;
			}
		} catch (SQLException e) {
			System.err.println(e);
			return 0;
		}
	}

	public double getDivisionSales(String inDiv) {
		String sql = "select sum(Sales) from stores_sales sales , stores stores , divisions divisions "
				+ " WHERE sales.ID = stores.ID and stores.DivisionID = divisions.ID"
				+ " and divisions.DivisionNumber = ?"
				+ " group by(divisions.DivisionNumber)";

		double sales = 0.0;

		try {
			Connection connection = DBUtil.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, inDiv);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				sales = rs.getDouble(1);
			}
			DBUtil.closeConnection();
		}
		catch (SQLException e) {
			System.err.println("Error getting sales for division");
			e.printStackTrace();
		}
		return sales;
	}

	public boolean validateDivision(String inDiv) {

		String sql = "select 1 " + " from  divisions divisions " + " WHERE divisions.ID = ?";

		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, inDiv);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				return true;
			} else {
				return false;
			}
		}

		catch (SQLException e) {
			System.err.println(e);
			return false;
		}

	}

	public boolean validateStore(String inStore) {

		String sql = "select 1 " + " from  stores stores " + " WHERE stores.StoreNumber = ?";

		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, inStore);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				return true;
			} else {
				return false;
			}
		}

		catch (SQLException e) {
			System.err.println(e);
			return false;
		}

	}

	@Override
	public ArrayList<StoreSales> getStoresalesforyear() 
	{
		
		return null;
	}

}
