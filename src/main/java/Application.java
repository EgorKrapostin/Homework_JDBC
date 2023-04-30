import jdk.jfr.Percentage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.Query;
import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City city = new City();
        city.setCityName("Волгоград");

        Employee employee = new Employee("Иван4", "Иванов4", "м", 34);
        Employee employee1 = new Employee("Иван5", "Иванов5", "м", 35);
        Employee employee2 = new Employee("Иван6", "Иванов6", "м", 36);
        List<Employee> employees = List.of(employee, employee1, employee2);

        cityDAO.createCity(city);
        city.setEmployees(employees);
        cityDAO.updateCity(city);
        cityDAO.deleteCity(city);



    }
}
