import org.example.OOP.Encapsulation.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    void testSetName_ValidName(){
        Employee employee = new Employee();
        employee.setName("Hare Krishna");
        assertEquals("Hare Krishna", employee.getName());
    }

    @Test
    void testSetName_InvalidName_ThrowsException(){
        Employee employee = new Employee();
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> employee.setName(""));
        assertEquals("Name cannot be null or empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, ()-> employee.setName(null));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    void testSetAge_ValidAge(){
        Employee employee = new Employee();
        employee.setAge(25);
        assertEquals(25, employee.getAge());
    }

    @Test
    void testSetAge_InvalidAge_ThrowsException(){
        Employee employee = new Employee();

    }
}
