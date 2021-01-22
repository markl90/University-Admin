import java.util.ArrayList;
import java.util.List;

public class CourseList {

    private List<Course> courses;
    private int numberOfCourses = 0;


    public CourseList(){
        courses = new ArrayList<>();
    }

    public void addCourses(String... courseName){
        for(String name : courseName){
            this.numberOfCourses++;
            Course course = new Course(name);
            course.setCourseNumber(this.numberOfCourses);
            this.courses.add(course);
        }
        this.courses.forEach(course -> System.out.println(String.format("Course %s: %s Cost: £%s",course.getCourseNumber(), course.getCourseName(), course.getCourseCost())));
    }

    public List<Course> getCourses(){
        return this.courses;
    }

}
