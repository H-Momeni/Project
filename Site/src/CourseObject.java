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
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public int second;
    public static String timetoString(Time time) {
        String output = Integer.toString(time.year) + "/" +
                        Integer.toString(time.month) + "/" +
                        Integer.toString(time.day) + "/" +
                        Integer.toString(time.hour) + "/" +
                        Integer.toString(time.minute) + "/" +
                        Integer.toString(time.second);
        return output;
    }
    public static Time stringtotime(String string) {
        String[] parts = string.split("/");
        Time output = new Time(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]), Integer.valueOf(parts[2]),
                                Integer.valueOf(parts[3]), Integer.valueOf(parts[4]),
                                Integer.valueOf(parts[5]));
        return output;
    }
    public Time(int year, int month, int day, int hour, int minute, int second){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
}

