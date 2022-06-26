import java.sql.*;

public class DataBase {
    private static Connection connection;
    private static Statement statement;

    public DataBase() {
        ConnectToDatabase();
        CreatTable();
    }

    private static void ConnectToDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/site", "root", "");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void CreatTable() {
        String tablecrtquery = "CREATE TABLE IF NOT EXISTS users (id BIGINT(10) PRIMARY KEY NOT NULL, password VARCHAR(255) NOT NULL, firstname VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL, username VARCHAR(255), discipline VARCHAR(255), email VARCHAR(255), phonenumber BIGINT(12), role TINYINT);";
        try {
            statement.executeUpdate(tablecrtquery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void AddUser(Person user, String number) {
        ConnectToDatabase();
        long ID = user.getID();
        String Password = user.getPassword();
        String Firstname = user.getFirstName();
        String LastName = user.getLastName();
        String Username = user.getUsername();
        String Discipline = user.getDiscipline();
        String Email = user.getEmail();
        long Phone = user.getPhone();
        int role; // faculty=1  student=2
        if(user instanceof Faculty){
            role = 1;
        } else {
            role = 2;
        }

        String insertquery = "INSERT INTO users (id, password, firstname, lastname, username, discipline, email, phonenumber, role) VALUES ('%d', '%s', '%s', '%s', '%s', '%s', '%s', '%d', '%s')";
        insertquery = String.format(insertquery, ID, Password, Firstname, LastName, Username, Discipline, Email, Phone, role);

        try {
            statement.executeUpdate(insertquery);
            System.out.println("inserted person"); //بعدا بردارم
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "person");
            e.printStackTrace();
        }

    }

}