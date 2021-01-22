import java.util.*;

public class Student {

    private String firstName;
    private String lastName;
    private int enrolmentYear;
    private String studentID;
    private int tuitionBalance;

    private String studentNumber;

    private List<Course> courses = new ArrayList<>();

    public Student(String firstName, String lastName, University university) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrolmentYear = Calendar.getInstance().get(Calendar.YEAR);
        university.getDatabase().generateIdAndAddStudent(this);
    }

//    public Student(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter student first name: ");
//            this.firstName = scanner.nextLine().toLowerCase().trim();
//            this.firstName = WordUtils.capitalize(this.firstName);
//        System.out.println("Enter student last name: ");
//            this.lastName = scanner.nextLine().toLowerCase().trim();
//            this.lastName = WordUtils.capitalize(this.lastName);
//        System.out.println("Enter student enrolment year: ");
//        this.enrolmentYear = scanner.nextLine();
//
//        System.out.println(String.format("Name: %s %s\nEnrolment year: %s", firstName, lastName, enrolmentYear));
//
//        System.out.println(generateID());
//    }

    public void setID(String ID){
       this.studentID = ID;
    }

    public void enrollOnCourse(CourseList courseList, String name){
        int coursesAdded = 0;
        boolean alreadyEnrolledOnCourse = false;

        for (Course course : this.courses){
            if(course.getCourseName().equals(name)){
                alreadyEnrolledOnCourse=true;
            }
        }
        for (Course course : courseList.getCourses()){
           if(course.getCourseName().equals(name)){
               if(alreadyEnrolledOnCourse){
                   System.out.println(String.format("%s %s is already enrolled on %s", firstName, lastName, name));
                   break;
               }
               this.courses.add(course);
               System.out.println(String.format("%s added to courses for %s %s", course.getCourseName(), this.firstName, this.lastName));
               tuitionBalance = tuitionBalance - course.getCourseCost();
               getTuituionBalance();
               coursesAdded++;
               break;
           }
        }
        if(coursesAdded==0 && !alreadyEnrolledOnCourse){
            System.out.println(String.format("Course \"%s\" was not found in the list of available courses.", name));
        }
    }


    public void payTuition(int tuitionPayment){
        tuitionBalance = tuitionBalance + tuitionPayment;
        System.out.println(String.format("£%s paid for %s %s", tuitionPayment, firstName, lastName));
        getTuituionBalance();
    }

    public int getTuituionBalance(){
        if(tuitionBalance>=0) {
            System.out.println(String.format("Tuition balance for %s %s is £%s", firstName, lastName, tuitionBalance));
        }
        else {
            System.out.println(String.format("Tuition balance for %s %s is £%s-", firstName, lastName, String.valueOf(tuitionBalance).replace("-","")));
        }
       return tuitionBalance;
    }

    public int getEnrolmentYear() {
        return enrolmentYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentID(){
        return studentID;
    }

    public String showStatus(){
        return String.format("Name: %s %s\nID: %s\nTuition Balance(£): %s", firstName, lastName, studentID, tuitionBalance);
    }




}
