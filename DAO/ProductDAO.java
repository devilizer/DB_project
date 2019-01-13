import java.lang.*;
import java.util.List;

public interface ProductDAO {
	public Product getProductByName(String  name);
	public void addProduct(Product product);
	public int getProductprice(int id);
	public void setofferforproduct(int id,int offer);
	public void updateprice(int id,int newprice);
	// public void updateStudent(Student student);
	// public void deleteStudent(Student student);
	
}

