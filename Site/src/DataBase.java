import java.sql.*;

public class DataBase {
    private static Connection connection;
    private static Statement statement;

    public DataBase() {
        ConnectToDatabase();
        CreateTable();
    }

    private static void ConnectToDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vl", "root", "");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void CreateTable() {
        String tablecrtquery = "CREATE TABLE IF NOT EXISTS users (id VARCHAR(255) PRIMARY KEY NOT NULL, password VARCHAR(255) NOT NULL, firstname VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL, username VARCHAR(255), discipline VARCHAR(255), email VARCHAR(255), phonenumber VARCHAR(255), role TINYINT);";
        try {
            statement.executeUpdate(tablecrtquery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void AddUser(Person user) {
        ConnectToDatabase();
        CreateTable();
        String ID = user.getID();
        String Password = user.getPassword();
        String Firstname = user.getFirstName();
        String LastName = user.getLastName();
        String Username = user.getUsername();
        String Discipline = user.getDiscipline();
        String Email = user.getEmail();
        String Phone = user.getPhone();
        int role; // faculty=1  student=2
        if(user instanceof Faculty){
            role = 1;
        } else {
            role = 2;
        }

        String insertquery = "INSERT INTO users (id, password, firstname, lastname, username, discipline, email, phonenumber, role) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%d')";
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