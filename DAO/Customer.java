import java.lang.*;

public class Customer{
	int id;
	String username;
	String password;
	String email;
	String address;
	int cart_id;

	public Customer()
	{

	}

	public Customer(int id,String username,String password,String email,String address,int cart_id){
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.cart_id = cart_id;
	}

	public int getid(){return id;}
	public String get_username(){return username;}
	public String get_email(){return email;}
	public String get_address(){return address;}
	public int get_cart_id(){return cart_id;}
	public void set_username(String u){username = u;}
	public void set_email(String e){email = e;}
	public void set_address(String a){address = a;}
}