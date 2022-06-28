public abstract class CourseObject {
    private String title;
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    

    public CourseObject(String title) {
        setTitle(title);
    }

}

class Time {
    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;
    public Time(int year, int month, int day, int hour, int minute, int second){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
}

