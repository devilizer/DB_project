import java.lang.*;
import java.util.List;

public interface Cart_itemDAO {
	public void addProduct(Product product,int quantity,Cart cart);
	public void removeProduct(Cart_item item);
	// public void updateStudent(Student student);
	// public void deleteStudent(Student student);
	
}