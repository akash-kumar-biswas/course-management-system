import java.util.ArrayList;
import java.util.List;

interface CourseComponent {
    void showDetails();
}

class Lesson implements CourseComponent {
    private String title;
    private String duration; 
    private String instructorName;
    private String abc;

    public Lesson(String title, String duration, String instructorName) {
        this.title = title;
        this.duration = duration;
        this.instructorName = instructorName;
    }

    public void showDetails() {
        System.out.println("Lesson: " + title + ", Duration: " + duration + ", Instructor: " + instructorName);
    }
}


class CourseModule implements CourseComponent {
    private String moduleName;
    private List<CourseComponent> components = new ArrayList<>();

    public CourseModule(String moduleName) {
        this.moduleName = moduleName;
    }

    public void addComponent(CourseComponent component) {
        components.add(component);
    }

    public void showDetails() {
        System.out.println("Module: " + moduleName);
        for (CourseComponent component : components) {
            component.showDetails();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Lesson lesson1 = new Lesson("Intro to Java", "45 min", "Dr. Smith");
        Lesson lesson2 = new Lesson("OOP Concepts", "60 min", "Prof. Lee");

        CourseModule subModule = new CourseModule("Java Basics");
        subModule.addComponent(lesson1);
        subModule.addComponent(lesson2);

        Lesson lesson3 = new Lesson("Design Patterns", "50 min", "Dr. Brown");

        CourseModule mainModule = new CourseModule("Software Engineering");
        mainModule.addComponent(subModule);
        mainModule.addComponent(lesson3);

        mainModule.showDetails();
    }
}
