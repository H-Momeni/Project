public class Content extends CourseObject {
    private String filepath;
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    public String getFilepath() {
        return filepath;
    }

    public Content(String title, String filepath) {
        super(title);
        setFilepath(filepath);
    }
}
