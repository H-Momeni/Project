import java.util.ArrayList;

public class Course {
    private String title;
    private int code;
    private static int codes = 1;
    public ArrayList<CourseObject> courseobjects = new ArrayList<CourseObject>();
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public int getCode() {
        return code;
    }
    public Course(String title) {
        setTitle(title);
        code = codes;
        codes++;
    }
}
