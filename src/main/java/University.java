import java.sql.SQLOutput;

public class University {

    private String universityName;
    private MockDatabase database;
    private CourseList courses;

    public University(String nameOfUniversity){
        this.universityName = nameOfUniversity;
        System.out.println(String.format("Student data for %s University", this.universityName));
        database = new MockDatabase();
        courses = new CourseList();
    }

    public MockDatabase getDatabase(){
        return this.database;
    }

    public void addNewStudent(String firstName, String lastName){
        new Student(firstName, lastName, this);
    }

    public void addCourses(String... courseName){
        courses.addCourses(courseName);
    }

    public Student getStudent(String firstName, String lastName){
        System.out.println(String.format("Searching for %s %s", firstName, lastName));
        boolean studentFound = false;
        Student studentRecord = null;
        for(Student student : this.database.getStudents()){
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                studentRecord = student;
                if(studentFound){
                    System.out.println("Multiple student records, please search using student ID.");
                    return null;
                }
                studentFound = true;

            }
        }
        System.out.println(String.format("Student found.\n%s", studentRecord.showStatus()));
        if(!studentFound){
            System.out.println(String.format("Student \"%s %s\" not found.", firstName, lastName));
        }
        return studentRecord;
    }

    public Student getStudent(String ID){
        System.out.println(String.format("Searching for Student ID: %s", ID));
        boolean studentFound = false;
        for(Student student : this.database.getStudents()){
            if(student.getStudentID().equals(ID)){
                System.out.println(String.format("Student found.\n%s", student.showStatus()));
                studentFound = true;
                return student;
            }
        }
        if(!studentFound){
            System.out.println(String.format("Student \"%s\" not found.", ID));
        }
        return null;
    }

    public void payStudentTuition(Student student, int tuitionPayment){
        student.payTuition(tuitionPayment);
    }

    public void enrollStudentonCourse(Student student, String courseName){
        student.enrollOnCourse(courses, courseName);
    }


}
