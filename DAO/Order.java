import java.lang.*;

public class Order{
	int order_id;
	int customer_detail;
	String placed_date;
	String status;
	int total_amount;

	Order(){}
	Order(int id,int cust,String pd,String st ,int amou){
		order_id = id;
		customer_detail = cust;
		placed_date = pd;
		status=st;
		total_amount = amou;
	}
	public int getId(){return order_id;}
	public String getStatus(){return status;}
	public void setStatus(String s){status=s;}



}