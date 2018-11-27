import java.lang.*;
import java.util.List;

public interface ProductDAO {
	public Product getProductByName(String  name);
	public void addProduct(Product product);
	// public void updateStudent(Student student);
	// public void deleteStudent(Student student);
	
}

