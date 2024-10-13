package ASSG7;

public class Q2 {
    public static void main(String[] args) {
        Student student1 = new Student("Arun Natarajan", "nats@student.com", "STU001");
        Student student2 = new Student("Aditya Kamlbe", "kamble@student.com", "STU002");

        Faculty faculty1 = new Faculty("Dr. Hafeez", "hid@university.com", "FAC001");
        Faculty faculty2 = new Faculty("Prof. Adil", "adil@university.com", "FAC002");

        student1.attendLiveSession();
        student1.viewRecorededLecture();

        student2.accessPortal();
        student2.submitAssignment();

        faculty1.accessPortal();
        faculty1.conductLiveSession();

        faculty2.accessPortal();
        faculty2.conductLiveSession();
        faculty2.uploadAssignment();
    }
}

abstract class User {
    protected String name;
    protected String email;
    protected String userID;

    public User(String name, String email, String userID) {
        this.name = name;
        this.email = email;
        this.userID = userID;
    }

    abstract void accessPortal();
}

class Student extends User {

    public Student(String name, String email, String userID) {
        super(name, email, userID);
    }

    @Override
    public void accessPortal() {
        System.out.println("Portal Access:");
        System.out.println("- Viewing online courses.");
        System.out.println("- Attending live session.");
        System.out.println("- Submitting assignments online.");
    }

    public void attendLiveSession() {
        System.out.println("Attending a live session.");
    }

    public void viewRecorededLecture() {
        System.out.println("Viewing a recorded lecture.");
    }

    public void submitAssignment() {
        System.out.println("Submitting assignment.");
    }

}

class Faculty extends User {

    public Faculty(String name, String email, String userID) {
        super(name, email, userID);
    }

    @Override
    public void accessPortal() {
        System.out.println("-- Faculty Access --");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("UserID: " + userID);
        System.out.println("Portal Access:");
        System.out.println("- Uploading course material.");
        System.out.println("- Conducting live online lecture.");
    }

    public void conductLiveSession() {
        System.out.println("Conducting live session.");
    }

    public void uploadRecorededMaterial() {
        System.out.println("Uploading a recorded lecture for students.");
    }

    public void uploadCourseMaterial() {
        System.out.println("Uploading course material.");
    }

    public void uploadAssignment() {
        System.out.println("Uploading an online assignment for students.");
    }
}
