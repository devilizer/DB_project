import java.lang.*;

public class Feedback(){
	int feedback_id;
	int customer_detail;
	int product_detail;
	String des;
	int rating;

	Feedback(){}
	Feedback(int f_id,int c_detail,int p_detail,String d,int r){
		feedback_id = f_id;
		customer_detail = c_detail;
		product_detail = p_detail;
		des = d;
		rating = r;
	}

	public int getFeedbackId(){return feedback_id;}
	public int getCustomerId(){return customer_detail;}
	public int getRating(){return rating;}
	public int getProductDetail(){return product_detail;}
	public void setDesc(String d){des = d;}
	public void setRating(int r){rating = r;}
}