package lesson_4;

public class Subject{
    private int grade;
    private final String name;

    Subject(int grade, String name){
        this.grade = grade;
        this.name = name;
    }

    public void setGrade(int value){
        this.grade = value;
    }

    public int getGrade() {
        return this.grade;
    }

    public String getName() {
        return this.name;
    }
}
