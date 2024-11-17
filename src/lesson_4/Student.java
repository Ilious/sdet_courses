package lesson_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student{
        private final String nameGroup;
        private final String name;
        private final int course;
        private final ArrayList<Subject> gradesBySubjects;

        Student(String nameGroup, String name, int course, ArrayList<Subject> gradesBySubjects){
            this.nameGroup = nameGroup;
            this.name = name;
            this.gradesBySubjects = gradesBySubjects;
            this.course = course;
        }

        public boolean isAvgGradesLessThan3(){
                int sum = gradesBySubjects.stream().map(Subject::getGrade).mapToInt(i -> i).sum();
                int count = gradesBySubjects.size();
                return sum / count < 3;
        }

        @Override
        public String toString(){
            int sum = gradesBySubjects.stream().map(Subject::getGrade).mapToInt(i -> i).sum();
            int count = gradesBySubjects.size();
            return String.format("student %s's studying on %s course %s in avg %.2f ", name, course, nameGroup,
                    (float)(sum) / count);
        }

        public boolean isThisCourse(int courseNum){
            return courseNum == this.getCourse();
        }

        private int getCourse() {
            return this.course;
        }
}
