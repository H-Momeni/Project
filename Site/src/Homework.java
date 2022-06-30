import java.time.LocalDateTime;

public class Homework extends CourseObject {
    private String quspath;
    private String anspath;
    private boolean state;
    private Time startTime;
    private Time endTime;
    private double grade;

    public void setQuspath(String quspath){
        this.quspath = quspath;
    }
    public void setAnspath(String anspath){
        this.anspath = anspath;
    }
    public void setState(boolean state){
        this.state = state;
    }
    public void setEndTime(Time endTime){
        this.endTime = endTime;
    }
    public void setGrade(double grade){
        this.grade = grade;
    }
    private void setStartTime() {
        LocalDateTime now = LocalDateTime.now();
        Time time = new Time(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), now.getHour(), now.getMinute(), now.getSecond());
        this.startTime = time;
    }

    public String getQuspath(){
        return quspath;
    }
    public String getAnspath(){
        return anspath;
    }
    public boolean getState(){
        return state;
    }
    public Time getStartTime(){
        return startTime;
    }
    public Time getEndTime(){
        return endTime;
    }
    public double getGrade(){
        return grade;
    }

    public Homework(String title, String quspath, Time endTime) {
        super(title);
        setQuspath(quspath);
        setState(false);
        setStartTime();
        setEndTime(endTime);
    }

    public Homework(String title, String quspath, String anspath, boolean state, Time startTime, Time endTime, double grade) {
        super(title);
        setQuspath(quspath);
        setAnspath(anspath);
        setState(state);
        this.startTime = startTime;
        setEndTime(endTime);
        setGrade(grade);
    }

}
