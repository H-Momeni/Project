public class Exam extends CourseObject {
    private String quspath;
    private String anspath;
    private boolean state;
    private Time startTime; 
    private Time endTime;
    private double grade;
    private boolean review;
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
    public void setReview(boolean review){
        this.review = review;
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
    public boolean getReview(){
        return review;
    }
    public double getGrade(){
        return grade;
    }


    public Exam(String title, String quspath, Time endTime, boolean review) {
        super(title);
        setQuspath(quspath);
        setState(false);
        // this.startTime = startTime;
        setEndTime(endTime);
        setReview(review);
    }
}
