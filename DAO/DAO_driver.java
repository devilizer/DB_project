//STEP 1. Import required packages
import java.sql.*;

public class DAO_driver {
	public static void main(String[] args) {
		try{
			DAO_Factory daoFactory = new DAO_Factory();

			daoFactory.activateConnection();

			ProductDAO pdao = daoFactory.getProductDAO();
			//Product p = pdao.getProductByName("TrackPants");
			//p.print();
			Product p = new Product(4,"Racket","1700","http://");
			pdao.addProduct(p);
			daoFactory.deactivateConnection();
		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}//end main
}//end FirstExample
