
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ProductDAO_JDBC implements ProductDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public ProductDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}
	@Override
	public Product getProductByName(String name){
		Product p = new Product();
		String sql;
		Statement stmt= null;
		try{
			stmt = dbConnection.createStatement();
			sql = "select description,price from product";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String desc = rs.getString("description");
				int price = rs.getInt("price");
				p.setDescription(desc);
				p.setPrice(price);
			}

		}
		catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return p;

	}
	@Override
	public void addProduct(Product product){
		PreparedStatement preparedStatement = null;
		String sql;
		sql = "insert into product(description,price,images) values(?,?,?)";
		try{
			preparedStatement = dbConnection.prepareStatement(sql);
 
			preparedStatement.setString(1, product.getDescription());
			preparedStatement.setInt(2, product.getPrice());
			preparedStatement.setString(3,product.getImages());

			preparedStatement.executeUpdate();
			System.out.println("Product: Name " + product.getDescription() 
				+ ", added to the database");
 

		}
		catch(SQLException e){
			System.out.println(e.getMessage());
 		}
 		try{
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
	}
	@Override
	public void setofferforproduct(Product p){
		String sql;
		Statement stmt= null;
		PreparedStatement preparedStatement = null;
		try{
			stmt = dbConnection.createStatement();
			sql = "update product set price = ? where product_id = ?";
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, (int)(0.6*p.getPrice()));
			preparedStatement.setInt(2, p.getId());
			preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
		}
		catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
	}
	public void updateprice(Product product,int newprice){
		String sql;
		Statement stmt= null;
		PreparedStatement preparedStatement = null;
		try{
			stmt = dbConnection.createStatement();
			sql = "update product set price = ? where product_id = ?";
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, newprice);
			preparedStatement.setInt(2, product.getId());
			preparedStatement.executeUpdate();
			System.out.println("new Price set to "+ newprice);
		}
		catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	

}

	

