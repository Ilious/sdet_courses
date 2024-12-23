package lesson_4;

import java.util.ArrayList;
import java.util.List;

public class Lesson4{
    public Lesson4(){
        ArrayList<Student> listStudents = new ArrayList<>();

        ArrayList<Subject> baseGrades = new ArrayList<>();
        baseGrades.add(new Subject(3, "History"));
        baseGrades.add(new Subject(3, "Math"));
        baseGrades.add(new Subject(2, "OS"));
        baseGrades.add(new Subject(3, "Machine Learning"));
        baseGrades.add(new Subject(2, "English"));

        ArrayList<Subject> igorGrades = copyGrades(baseGrades);
        listStudents.add(new Student("PIbd", "Igor", 1, igorGrades));

        ArrayList<Subject> petyaGrades = copyGrades(baseGrades);
        petyaGrades.get(2).setGrade(3);
        listStudents.add(new Student("PIbd", "Petya", 1, petyaGrades));

        ArrayList<Subject> vanyaGrades = copyGrades(baseGrades);
        vanyaGrades.get(0).setGrade(5);
        vanyaGrades.get(1).setGrade(5);
        listStudents.add(new Student("PIbd", "Vanya", 1, vanyaGrades));

        ArrayList<Subject> sashaGrades = copyGrades(baseGrades);
        sashaGrades.get(2).setGrade(4);
        listStudents.add(new Student("PIbd", "Sasha", 2, sashaGrades));

        ArrayList<Subject> danilaGrades = copyGrades(baseGrades);
        danilaGrades.get(0).setGrade(5);
        danilaGrades.get(1).setGrade(4);
        danilaGrades.get(2).setGrade(5);
        danilaGrades.get(3).setGrade(4);
        danilaGrades.get(4).setGrade(5);
        listStudents.add(new Student("PIbd", "Danila", 2, danilaGrades));


        printStudents(listStudents,1);
        printStudents(listStudents,2);

        listStudents = moveToNextCourse(listStudents);
        printStudents(listStudents, 1);
    }

    private void printStudents(List<Student> students, int course){
        for (Student student : students){
            if (student.isThisCourse(course))
                System.out.println(student);
        }
        System.out.println("-".repeat(100));
    }

    private ArrayList<Student> moveToNextCourse(ArrayList<Student> listStudents){
        ArrayList<Student> nextCourse = new ArrayList<>();

        for (Student student : listStudents){
            if (!student.isAvgGradesLessThan3()){
                System.out.println(student + "moves to next course");
                nextCourse.add(student);
            }
        }
        System.out.println("-".repeat(100));

        return nextCourse;
    }

    private ArrayList<Subject> copyGrades(ArrayList<Subject> list){
        return new ArrayList<>(list.stream().
                map(subject -> new Subject(subject.getGrade(), subject.getName())).
                toList());
    }
}