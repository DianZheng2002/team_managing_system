package junit;


import domian.Employee;
import org.junit.jupiter.api.Test;
import service.NameListService;
import service.TeamException;

public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }



    }

    @Test
    public void testGetEmployee(){
        try {
            NameListService nameListService = new NameListService();
            int id = 13;
            Employee employee = nameListService.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

}
