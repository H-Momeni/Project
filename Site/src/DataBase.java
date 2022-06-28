import java.sql.*;

public class DataBase {
    private static Connection connection;
    private static Statement statement;

    public DataBase() {
        ConnectToDatabase();
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

    private static void CreateTable(String tablename) {
        String tablecrtquery = "CREATE TABLE IF NOT EXISTS '%s' (id VARCHAR(255) PRIMARY KEY NOT NULL, password VARCHAR(255) NOT NULL, firstname VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL, username VARCHAR(255), discipline VARCHAR(255), email VARCHAR(255), phonenumber VARCHAR(255), role TINYINT);";
        tablecrtquery = String.format(tablecrtquery, tablename);
        try {
            statement.executeUpdate(tablecrtquery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void AddUser(Person user) {
        ConnectToDatabase();
        CreateTable("users");
        String ID = user.getID();
        String Password = user.getPassword();
        String Firstname = user.getFirstName();
        String LastName = user.getLastName();
        String Username = user.getUsername();
        String Discipline = user.getDiscipline();
        String Email = user.getEmail();
        String Phone = user.getPhone();
        int role; // faculty=1 student=2
        if (user instanceof Faculty) {
            role = 1;
        } else {
            role = 2;
        }

        String insertquery = "INSERT INTO users (id, password, firstname, lastname, username, discipline, email, phonenumber, role) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%d')";
        insertquery = String.format(insertquery, ID, Password, Firstname, LastName, Username, Discipline, Email, Phone, role);
        try {
            statement.executeUpdate(insertquery);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "person");
            e.printStackTrace();
        }

    }


    public static Person FindUser(String ID) {

        ConnectToDatabase();
        CreateTable("users");
        String findquery = "SELECT * FROM users WHERE id= '%s';";
        findquery = String.format(findquery, ID);
        Person curperson = null;
        try {
            ResultSet result = statement.executeQuery(findquery);
            result.next();
            if (result.getString("role").equals("1")) {
                curperson = new Faculty(ID, result.getString("password"), result.getString("firstname"),
                        result.getString("lastname"), result.getString("username"), result.getString("discipline"),
                        result.getString("email"), result.getString("phonenumber"));
            } else {
                curperson = new Student(ID, result.getString("password"), result.getString("firstname"),
                        result.getString("lastname"), result.getString("username"), result.getString("discipline"),
                        result.getString("email"), result.getString("phonenumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return curperson;
    }

    public static boolean IDisVlaid(String ID) {
        ConnectToDatabase();
        CreateTable("users");
        int sw = 0;
        String findquery = "SELECT * FROM users WHERE id = '%s';";
        findquery = String.format(findquery, ID);
        try {
            ResultSet result = statement.executeQuery(findquery);
            if (result.next()) {
                sw = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sw == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean PasswordisValid(String ID, String Password) {
        ConnectToDatabase();
        CreateTable("users");
        int sw = 0;
        String findquery = "SELECT * FROM users WHERE id = '%s';";
        findquery = String.format(findquery, ID);
        try {
            ResultSet result = statement.executeQuery(findquery);
            result.next();
            if (result.getString("password").equals(Password)) {
                sw = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sw == 1) {
            return true;
        } else {
            return false;
        }
    }
}