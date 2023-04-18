import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    final String user = "postgres";
    final String password = "password";
    final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id");
                String employeeFirstName = resultSet.getString("first_name");
                String employeeLastName = resultSet.getString("last_name");
                String employeeGender = resultSet.getString("gender");
                int employeeAge = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");
                employees.add(new Employee(employeeId, employeeFirstName, employeeLastName, employeeGender, employeeAge, cityId));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employees;

    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id="+id)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id");
                String employeeFirstName = resultSet.getString("first_name");
                String employeeLastName = resultSet.getString("last_name");
                String employeeGender = resultSet.getString("gender");
                int employeeAge = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");
                employee = new  Employee(employeeId, employeeFirstName, employeeLastName, employeeGender, employeeAge, cityId);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO employee(first_name, last_name, gender, age) " +
                     "VALUES (?,?,?,?)")) {
            statement.setString(1,employee.getFirst_name());
            statement.setString(2,employee.getLast_name());
            statement.setString(3,employee.getGender());
            statement.setInt(4,employee.getAge());
            int resultSet = statement.executeUpdate();
            System.out.println("Сотрудник добавлен");

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {

    }
}
