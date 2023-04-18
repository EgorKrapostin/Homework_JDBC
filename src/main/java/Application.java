import java.sql.*;

public class Application {
    public static void main(String[] args) {
//        final String user = "postgres";
//        final String password = "password";
//        final String url = "jdbc:postgresql://localhost:5432/skypro";
//
//        try (final Connection connection = DriverManager.getConnection(url, user, password);
//             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = 1")) {
//             ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                int employeeId = resultSet.getInt("id");
////                System.out.println("ID: " + employeeId);
//                String employeeFirstName = resultSet.getString("first_name");
////                System.out.println("Имя: " + employeeFirstName);
//                String employeeLastName = resultSet.getString("last_name");
////                System.out.println("Фамилия: " + employeeLastName);
//                String employeeGender = resultSet.getString("gender");
////                System.out.println("Пол: " + employeeGender);
//                int employeeAge = resultSet.getInt("age");
////                System.out.println("Возраст: " + employeeAge);
//                int cityId = resultSet.getInt("city_id");
////                System.out.println("ID города: " + cityId);
//            }
//        } catch (SQLException e) {
//            System.out.println("Ошибка при подключении к БД!");
//            e.printStackTrace();
//        }

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        System.out.println(employeeDAO.getAllEmployees());
//        System.out.println(employeeDAO.getEmployeeById(1));
        employeeDAO.createEmployee(new Employee("Петр","Петров","м",33));
    }
}
