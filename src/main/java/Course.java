import java.util.UUID;

public class Course {

    private String courseName;
    private String courseID;
    private int courseCost = 600;
    private int courseNumber;

    public Course(String name){
        this.courseName = name;
        generateCourseID();
    }

    private void generateCourseID(){
        this.courseID =  UUID.randomUUID().toString();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(int courseCost) {
        this.courseCost = courseCost;
    }

    public String getCourseID() {
        return courseID;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }
}
