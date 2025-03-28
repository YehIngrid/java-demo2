package HW_4113056010;

class Student {
    private String name;
    private Laboratory lab;
    public Student(String name) {
        System.out.println("Student " + name + " registered at NCHU.");
        this.name = name;
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
        if (this.lab == null){
            return;
        } else {
            System.out.println(this.name + "'s advisor is " + this.lab.getTeacher().getTeacherName()+".");
        }
    }
}

class Professor {
    private String teacherName;
    private String major;
    public Professor(String teacherName, String major) {
        System.out.println("Professor " + teacherName + "'s expertise includes " + major + " .");
        this.teacherName = teacherName;
        this.major = major;
    }
    public String getTeacherName() {
        return teacherName;
    }
}

class Laboratory{
    private String labName;
    private int numOfStudent;
    private Professor teacher;
    private int currentStudentCount = 0;
    public Laboratory(String labName, int numOfStudent, Professor teacher) {
        System.out.println("Create " + labName + " with " + numOfStudent + " vacancies.");
        this.labName = labName;
        this.numOfStudent = numOfStudent;
        this.teacher = teacher;
    }
    String getLabName() {
        return labName;
    }
    void checkRemainPlaces() {
        if((this.numOfStudent - this.currentStudentCount) == 0){
            System.out.println(this.labName + " has no vacancies.");
        } else {
            System.out.println(this.labName + " still has "+ (this.numOfStudent - this.currentStudentCount) + " vacancies.");
        }
    }
    Professor getTeacher() {
        //return laboratory's teacher
        return teacher;
    }
    void addStudent(Student student) {
        if(this.currentStudentCount >= this.numOfStudent) {
            System.out.println(student.getName()+" noticed that "+ this.getLabName() +" had reached full capacity.");
            return;
        }
        if (student.getLab() == null) {
            student.setLab(this);
            System.out.println(student.getName()+" joined "+ this.getLabName()+".");
            this.currentStudentCount++;
        } else {
            System.out.println(student.getName()+" has already joined "+ student.getLab().getLabName()+".");
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