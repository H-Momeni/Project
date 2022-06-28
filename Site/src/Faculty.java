public class Faculty extends Person {
    
    public Faculty(String ID, String Password, String FirstName, String LastName) {
        super(ID, Password, FirstName, LastName);
    }

    public Faculty(String ID, String Password, String FirstName, String LastName, String Username, String Discipline,
            String Email, String Phone) {
        super(ID, Password, FirstName, LastName, Username, Discipline, Email, Phone);
    }

}
