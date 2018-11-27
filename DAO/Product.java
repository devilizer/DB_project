import java.lang.*;

public class Product{
	int product_id;
	String description;
	int price;
	String images;

	Product(){}
	Product(int p_id,String d,int pr ,String im){
		product_id = p_id;
		description = d;
		price = pr;
		images = im;
	}
	public int getId(){return product_id;}
	public String getDescription(){return description;}
	public int getPrice(){return price;}
	public String getImages(){return images;}
	public void setDescription(String d){description = d;}
	public void setPrice(int p){price = p;}
	public void print(){
		System.out.println("Name: "+description);
		System.out.println("Price: "+price);
	}



}