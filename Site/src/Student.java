public class Student extends Person {
    
    public Student(long ID, String Password, String FirstName, String LastName) {
        super(ID, Password, FirstName, LastName);
    }

    public Student(long ID, String Password, String FirstName, String LastName, String Username, String Discipline,
            String Email, long Phone) {
        super(ID, Password, FirstName, LastName, Username, Discipline, Email, Phone);
    }

}
