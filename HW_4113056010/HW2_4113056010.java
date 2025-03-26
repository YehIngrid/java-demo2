package HW_4113056010;

class Student {
    private String name;
    private Laboratory lab;
    public Student(String name) {
        System.out.println("Student " + name + " registered at NCHU.");
    }
    String getName() {
        return name;
    }
    Laboratory getLab() {
        return lab;
    }
    void setLab(Laboratory lab){
        this.lab = lab;
    }
    void getTeacherName() {
        System.out.println(this.name + "'s advisor is " + );
    }
}

class Professor {
    private String teacherName;
    private String major;
    public Professor(String teacherName, String major) {
        System.out.println("Professor " + teacherName + "'s expertise includes " + major + " .");
    }
    public String getTeacherName() {
        return teacherName;
    }
    String getMajor() {
        return major;
    }
    // getMajor 我自己加的，題目沒有給。
}

class Laboratory{
    private String labName;
    private int numOfStudent;
    private Professor teacher;
    public Laboratory(String labName, int numOfStudent, Professor teacher) {
        System.out.println("Create " + labName + " with " + numOfStudent + " vacancies.");
    }
    String getLabName() {
        return labName;
    }
    void checkRemainPlaces() {
        System.out.println("hello:"+this.numOfStudent);
    }
    Professor getTeacher() {
        return teacher;
    }
    void addStudent(Student student) {
        if (numOfStudent <= 0) {
            System.out.println("numOfStudent: " + numOfStudent);
        } else {
           this.numOfStudent = this.numOfStudent - 1;
           System.out.println("numOfStudent: " + numOfStudent);
        }
    }
}
public class HW2_4113056010 {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Jason Lin","Information Security");// Professor Jason Lin's expertise includes Information Security.
        Professor professor2 = new Professor("Frank Fan","Natural Language Processing");// Professor Frank Fan's expertise includes Natural Language Processing.
        Student student1 = new Student("Andy");// Student Andy registered at NCHU.
        Student student2 = new Student("Bob");// Student Bob registered at NCHU.
        Student student3 = new Student("Vicky");// Student Vicky registered at NCHU.

        Laboratory lab1 = new Laboratory("ISLab",2, professor1);// Create ISLab with 2 vacancies.
        Laboratory lab2 = new Laboratory("NLPLab",3, professor2);// Create NLPLab with 3 vacancies.

        lab1.addStudent(student1);// Andy joined ISLab.
        lab1.addStudent(student2);// Bob joined ISLab.
        lab2.addStudent(student2);// Bob has already joined ISLab.
        lab1.addStudent(student3);// Vicky noticed that ISLab had reached full capacity.
        lab2.addStudent(student3);// Vicky joined NLPLab.

        lab1.checkRemainPlaces();// ISLab has no vacancies.
        lab2.checkRemainPlaces();// NLPLab still has 2 vacancies.

        student2.getTeacherName();// Bob's advisor is Jason Lin.
        student3.getTeacherName();// Vicky's advisor is Frank Fan.

    }
}