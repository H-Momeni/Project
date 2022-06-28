import java.util.ArrayList;

public abstract class Person {

    private String ID; // student number
    private String Password;
    private String FirstName;
    private String LastName;
    private String Username;
    private String Discipline;
    private String Email;
    private String Phone;
    public ArrayList<Course> courses = new ArrayList<Course>();
    // photo : file

    public Person(String ID, String Password, String FirstName, String LastName) {
        setID(ID);
        setPassword(Password);
        setFirstName(FirstName);
        setLastName(LastName);
    }

    public Person(String ID, String Password, String FirstName, String LastName, String Username, String Discipline,
            String Email, String Phone) {
        this(ID, Password, FirstName, LastName);
        setUsername(Username);
        setDiscipline(Discipline);
        setEmail(Email);
        setPhone(Phone);
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setDiscipline(String Discipline) {
        this.Discipline = Discipline;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getUsername() {
        return Username;
    }

    public String getDiscipline() {
        return Discipline;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

}