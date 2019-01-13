import java.lang.*;
import java.util.List;
import java.sql.*;

public interface Cart_itemDAO {
	public void addProduct(int id,int quantity,Cart cart);
	public void removeProduct(int id);
	// public void updateStudent(Student student);
	// public void deleteStudent(Student student);
	
}