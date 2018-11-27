import java.lang.*;

public class Cart_item{
	int cart_item_id;
	int customer_detail;
	int quantity;
	int sub_amount;
	int product_detail;
	Cart_item(){}
	Cart_item(int i,int cust , int q,int sub_am,int prod){
		cart_item_id=i;
		customer_detail = cust;
		quantity=q;
		sub_amount=sub_am;
		product_detail=prod;
	}
	public int getId(){return cart_item_id;}
	public int getquantity(){return quantity;}
	public int getsub_amount(){return sub_amount;}
}