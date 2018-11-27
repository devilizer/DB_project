//STEP 1. Import required packages
import java.sql.*;

public class DAO_driver {
	public static void main(String[] args) {
		try{
			DAO_Factory daoFactory = new DAO_Factory();

			daoFactory.activateConnection();
			//ProductDAO pdao = daoFactory.getProductDAO();
			//Product p = new Product(5,"Racket",1700,"http://");
			//pdao.addProduct(p);
			//pdao.updateprice(p,1800);
			//Cart_itemDAO cart_iDAO = daoFactory.getCart_itemDAO();
			//Cart cart=new Cart(3,3,1);
			//Cart_item cart_i=new Cart_item(6,3,2,500,3);
			//cart_iDAO.addProduct(p,2,cart);
			//cart_iDAO.removeProduct(cart_i);
			OrderDAO odao =daoFactory.getOrderDAO();
			Order or=new Order(4,1,"2018-12-13","delivered",545);
			odao.changestatus(or,"out for delivery");
			daoFactory.deactivateConnection();
		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}//end main
}//end FirstExample
