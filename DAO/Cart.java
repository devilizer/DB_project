import java.lang.*;

public class Cart{
	int id;
	int customer_id;
	int empty;
	Cart(){}
	Cart(int i,int cust , int e){
		id=i;
		customer_id = cust;
		empty = e;
	}
	public int getId(){return id;}
	public int isEmpty(){return empty;}
}