public class App {

    public static void main(String[] args) {
        University university = new University("Bournemouth");
        university.addCourses("History", "Mathematics", "English", "Chemistry", "Computer Science");
        university.addNewStudent("Bob", "");

        Student student = university.getStudent("Bob", "");
        university.enrollStudentonCourse(student, "History");
        university.payStudentTuition(student, 100);

        university.addNewStudent("John", "Smith");
        university.addNewStudent("John", "Smith");
        university.getStudent("John", "Smith");
        university.getStudent("20213");

    }
}
