import java.util.ArrayList;
import java.util.List;

public class MockDatabase {

    private List<Student> studentDatabase;
    private int numberOfStudents;

    public MockDatabase(){
        studentDatabase = new ArrayList<>();
        numberOfStudents = 0;
    }

    public void generateIdAndAddStudent(Student student){
        numberOfStudents++;
        student.setID(student.getEnrolmentYear() + String.valueOf(numberOfStudents));
        studentDatabase.add(student);
        System.out.println(String.format("Student added to database.\nName: %s %s\nID: %s", student.getFirstName(), student.getLastName(), student.getStudentID()));
    }

    public List<Student> getStudents(){
        return studentDatabase;
    }



}
