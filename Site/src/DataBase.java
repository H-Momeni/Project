import java.io.File;
import java.sql.*;
import java.util.ArrayList;

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

    private static void CreateTable_users() {
        String tablecrtquery = "CREATE TABLE IF NOT EXISTS users (id VARCHAR(255) PRIMARY KEY NOT NULL, password VARCHAR(255) NOT NULL, firstname VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL, username VARCHAR(255), discipline VARCHAR(255), email VARCHAR(255), phonenumber VARCHAR(255), role TINYINT, photopath VARCHAR(255) );";
        try {
            statement.executeUpdate(tablecrtquery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void CreateTable_studentID(String ID) {
        String name = "s" + ID;
        String tablecrtquery = "CREATE TABLE IF NOT EXISTS "+ name + " (title VARCHAR(255) NOT NULL, code INTEGER(11) NOT NULL);";
        try {
            statement.executeUpdate(tablecrtquery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void CreateTable_coursecode(int code) {
        String name = "c" + Integer.toString(code);
        String tablecrtquery = "CREATE TABLE IF NOT EXISTS " + name + " (title VARCHAR(255) NOT NULL, quspath VARCHAR(255), anspath VARCHAR(255), state TINYINT, sarttime VARCHAR(255), endtime VARCHAR(255), grade DOUBLE, review TINYINT, notiftext TEXT, type TINYINT);";
        tablecrtquery = String.format(tablecrtquery, Integer.toString(code));
        try {
            statement.executeUpdate(tablecrtquery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void AddUser(Person user) {
        ConnectToDatabase();
        CreateTable_users();
        String ID = user.getID();
        String Password = user.getPassword();
        String Firstname = user.getFirstName();
        String LastName = user.getLastName();
        String Username = user.getUsername();
        String Discipline = user.getDiscipline();
        String Email = user.getEmail();
        String Phone = user.getPhone();
        int role; // faculty=1 student=2
        String Photopath;
        if (user instanceof Faculty) {
            role = 1;
        } else {
            role = 2;
        }
        if(user.getPhoto()==null) {
            Photopath = null;
        } else {
            String realpath = user.getPhoto().getPath();
            Photopath = realpath.replace('\\', '/');
        }

        String insertquery = "INSERT INTO users (id, password, firstname, lastname, username, discipline, email, phonenumber, role, photopath) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%d', '%s')";
        insertquery = String.format(insertquery, ID, Password, Firstname, LastName, Username, Discipline, Email, Phone,role, Photopath);
        try {
            statement.executeUpdate(insertquery);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Person FindUser(String ID) {
        ConnectToDatabase();
        CreateTable_users();
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
            String filepath = result.getString("photopath");
            if(filepath!=null) {
                String realpath = filepath.replace('/', '\\');
                curperson.setPhoto(realpath);
            }
            curperson.courses = FindCourses(curperson.getID());
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
        return curperson;
    }

    public static boolean IDisVlaid(String ID) {
        ConnectToDatabase();
        CreateTable_users();
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
        CreateTable_users();
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

    public static void AddCourse(Person user, Course course) {
        ConnectToDatabase();
        CreateTable_studentID(user.getID());
        String title = course.getTitle();
        int code = course.getCode();
        String ID = user.getID();
        String name = "s" + ID;
        String insertquery = "INSERT INTO " + name + " (title, code) VALUES ('%s', '%d')";
        insertquery = String.format(insertquery, title, code);
        try {
            statement.executeUpdate(insertquery);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddObject(Course course, CourseObject object) {
        ConnectToDatabase();
        CreateTable_coursecode(course.getCode());
        String title = object.getTitle();
        String quspath;
        String anspath;
        int state;
        String starttime;
        String endtime;
        double grade;
        int review;
        String notiftext;
        int type; // notification=1 content=2 homework=3 exam=4
        String name = "c" + Integer.toString(course.getCode());
        if (object instanceof Notification) {
            Notification notification = (Notification) object;
            notiftext = notification.getText();
            type = 1;
            String insertquery = "INSERT INTO " + name + " (title, notiftext, type) VALUES ('%s', '%s', '%d')";
            insertquery = String.format(insertquery, title, notiftext, type);
            try {
                statement.executeUpdate(insertquery);
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (object instanceof Content) {
            Content content = (Content) object;
            String realquspath = content.getFilepath();
            quspath = realquspath.replace('\\', '/');
            type = 2;
            String insertquery = "INSERT INTO " + name + " (title, quspath, type) VALUES ('%s', '%s', '%d')";
            insertquery = String.format(insertquery, title, quspath, type);
            try {
                statement.executeUpdate(insertquery);
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (object instanceof Homework) {
            Homework homework = (Homework) object;
            String realquspath = homework.getQuspath();
            String realanspath = homework.getAnspath();
            quspath = realquspath.replace('\\', '/');
            anspath = realanspath.replace('\\', '/');
            starttime = Time.timetoString(homework.getStartTime());
            endtime = Time.timetoString(homework.getEndTime());
            grade = homework.getGrade();
            if (homework.getState()) {
                state = 1;
            } else {
                state = 0;
            }
            type = 3;
            String insertquery = "INSERT INTO " + name + " (title, quspath, anspath, state, starttime, endtime, grade, type) VALUES ('%s', '%s', '%s', '%d', '%s', '%s', '%lf', '%d');";
            insertquery = String.format(insertquery, title, quspath, anspath, state, starttime, endtime, grade, type);
            try {
                statement.executeUpdate(insertquery);
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Exam exam = (Exam) object;
            String realquspath = exam.getQuspath();
            String realanspath = exam.getAnspath();
            quspath = realquspath.replace('\\', '/');
            anspath = realanspath.replace('\\', '/');
            starttime = Time.timetoString(exam.getStartTime());
            endtime = Time.timetoString(exam.getEndTime());
            grade = exam.getGrade();
            if (exam.getState()) {
                state = 1;
            } else {
                state = 0;
            }
            if (exam.getReview()) {
                review = 1;
            } else {
                review = 0;
            }
            type = 4;
            String insertquery = "INSERT INTO " + name + " (title, quspath, anspath, state, starttime, endtime, grade, review, type) VALUES ('%s', '%s', '%s', '%d', '%s', '%s', '%lf', '%d', '%d');";
            insertquery = String.format(insertquery, title, quspath, anspath, state, starttime, endtime, grade, review, type);
            try {
                statement.executeUpdate(insertquery);
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void EditUser(Person user) {
        ConnectToDatabase();
        CreateTable_users();
        String ID = user.getID();
        String Password = user.getPassword();
        String Firstname = user.getFirstName();
        String LastName = user.getLastName();
        String Username = user.getUsername();
        String Discipline = user.getDiscipline();
        String Email = user.getEmail();
        String Phone = user.getPhone();
        String editquery = "UPDATE users SET password = '%s', firstname = '%s', lastname = '%s', username = '%s', discipline = '%s', email = '%s', phonenumber = '%s' WHERE id = '%s';";
        editquery = String.format(editquery, Password, Firstname, LastName, Username, Discipline, Email, Phone, ID);
        try {
            statement.executeUpdate(editquery);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "person");
            e.printStackTrace();
        }
    }

    private static ArrayList<Course> FindCourses(String ID) {
        CreateTable_studentID(ID);
        String name = "s" + ID;
        String findquery = "SELECT * FROM " + name + " ;";
        ArrayList<Course> output = new ArrayList<>();
        Course curcourse = null;
        try {
            ResultSet result = statement.executeQuery(findquery);
            while (result.next()) {
                curcourse = new Course(result.getString("title"), result.getInt("code"));
                output.add(curcourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0; i<output.size();i++) {
            output.get(i).courseobjects = FindObjects(output.get(i).getCode());
        }
        return output;
    }

    private static ArrayList<CourseObject> FindObjects(int code) {
        CreateTable_coursecode(code);
        String name = "c" + Integer.toString(code);
        String findquery = "SELECT * FROM " + name + " ;";
        ArrayList<CourseObject> output = new ArrayList<>();
        CourseObject curobj = null;
        try {
            ResultSet result = statement.executeQuery(findquery);
            while (result.next()) {
                if(result.getInt("type") == 1) {
                    curobj = new Notification(result.getString("title"), result.getString("notiftext"));
                } else if (result.getInt("type") == 2) {
                    String quspath = result.getString("quspath");
                    String realquspath = quspath.replace('/', '\\');
                    curobj = new Content(result.getString("title"), realquspath);
                } else if (result.getInt("type") == 3) {
                    boolean state;
                    if(result.getInt("state") == 1) {
                        state = true;
                    } else {
                        state = false;
                    }
                    Time st = Time.stringtotime(result.getString("starttime"));
                    Time et = Time.stringtotime(result.getString("endtime"));
                    String quspath = result.getString("quspath");
                    String realquspath = quspath.replace('/', '\\');
                    String anspath = result.getString("anspath");
                    String realanspath = anspath.replace('/', '\\');
                    curobj = new Homework(result.getString("title"), realquspath,
                        realanspath, state, st, et, result.getDouble("grade"));
                } else {
                    boolean state;
                    boolean review;
                    if(result.getInt("state") == 1) {
                        state = true;
                    } else {
                        state = false;
                    }
                    if(result.getInt("review") == 1) {
                        review = true;
                    } else {
                        review = false;
                    }
                    Time st = Time.stringtotime(result.getString("starttime"));
                    Time et = Time.stringtotime(result.getString("endtime"));
                    String quspath = result.getString("quspath");
                    String realquspath = quspath.replace('/', '\\');
                    String anspath = result.getString("anspath");
                    String realanspath = anspath.replace('/', '\\');
                    curobj = new Exam(result.getString("title"), realquspath,
                        realanspath, state, st, et, result.getDouble("grade"), review);
                }
                output.add(curobj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }
}