import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Cart_itemDAO_JDBC implements Cart_itemDAO {
	Connection dbConnection;

	public Cart_itemDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}
	@Override
	public void addProduct(int id,int quantity,Cart cart)
	{
		PreparedStatement preparedStatement = null;
		String sql;
		sql = "insert into cart_item(cart_detail,quantity,sub_amount,product_detail) values(?,?,?,?)";
		try{
			preparedStatement = dbConnection.prepareStatement(sql);
 
			preparedStatement.setInt(1, cart.getId());
			preparedStatement.setInt(2, quantity);
			preparedStatement.setInt(3,700*quantity);
			preparedStatement.setInt(4,id);

			preparedStatement.executeUpdate();
			System.out.println("item added to the cart_item database");
 

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
	public void removeProduct(int id){
		PreparedStatement preparedStatement = null;
		String sql;
		sql = "delete from cart_item where product_detail=?";
		try{
			preparedStatement = dbConnection.prepareStatement(sql);
 
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			System.out.println("item deleted from database");
 

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

}