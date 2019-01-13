import java.sql.*;
import java.util.Scanner;
public class application {
	public static void main(String[] args) {
		try{
			DAO_Factory daoFactory = new DAO_Factory();
			daoFactory.activateConnection();


			ProductDAO pdao = daoFactory.getProductDAO();
			Cart_itemDAO cart_iDAO = daoFactory.getCart_itemDAO();
			OrderDAO odao =daoFactory.getOrderDAO();
			

			Customer cust=new Customer(4,"apurv","159","apurv@gmail.com","ahmedabad",4);
			Cart cart=new Cart(3,cust.getid(),1);
			Order or=new Order(4,1,"2018-12-13","delivered",545);
			Cart_item cart_i=new Cart_item(6,cart.getId(),2,500,3);

			
			System.out.println("Please select a option\n");
			System.out.println("1 for managing shopping cart");
			System.out.println("2 for managing order updating price");
			System.out.println("3 for setting up an offer");
			System.out.println("4 for updating price of a product");
			System.out.println("0 to quit");
			Scanner sc = new Scanner(System.in);
			int ans=sc.nextInt();
			while(ans!=0){
			switch(ans){
				case 1:
				System.out.println("Please select to add or remove product from shoping cart");
				System.out.println("1 to add");
				System.out.println("2 to remove");
				Scanner sc1=new Scanner(System.in);
				int ans1 = sc.nextInt();
				switch(ans1){
					case 1:
						System.out.println("print id of the product");
						Scanner sc2=new Scanner(System.in);
						int id4 = sc2.nextInt();
						cart_iDAO.addProduct(id4,1,cart);
						break;

					case 2:
						System.out.println("print id of the product");
						Scanner sc3=new Scanner(System.in);
						int id5 = sc3.nextInt();
						cart_iDAO.removeProduct(id5);
						break;
					}
				break;
				case 2:
				System.out.println("enter the updated status and order id");
				Scanner scan = new Scanner(System.in);
				String updatedstatus = scan.nextLine();
				int id = scan.nextInt();
				odao.changestatus(id,updatedstatus);
				break;

				case 3:
				System.out.println("enter off offer and product id");
				Scanner scan1 = new Scanner(System.in);
				int offer = scan1.nextInt();
				int id2 =scan1.nextInt();
				pdao.setofferforproduct(id2,offer);
				break;

				case 4:
				System.out.println("enter updated price and product id");
				Scanner scan2 = new Scanner(System.in);
				int updatedprice = scan2.nextInt();
				int id3= scan2.nextInt();
				pdao.updateprice(id3,updatedprice);
				break;
			

			}
			System.out.println("enter next query number");
			ans=sc.nextInt();
			}
			daoFactory.deactivateConnection();
		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}//end main
}//end FirstExample