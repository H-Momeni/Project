public class Notification extends CourseObject {
    private String text; 
    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public Notification(String title, String text) {
        super(title);
        setText(text);
    }
}