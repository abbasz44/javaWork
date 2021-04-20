package grader;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public abstract class Student {
    private String name;
    private double examGrade;

    Student(){}

    Student(JSONObject studentData) {
        parseStudentData(studentData);
    }

    public void parseStudentData(JSONObject studentData) {
        // setName(studentData.get("name").toString());
        // setExamGrade(Double.parseDouble(studentData.get("examGrade").toString()));
    }

    public final double getGradelistAverage(ArrayList<Double> gradeList) {
        double avg = 0;
        int i;
        for (i = 0; i < gradeList.size(); i++) {
            avg += gradeList.get(i);
        }
        avg /= i;
        return avg;
    }

    public final void loadGradeList(ArrayList<Double> gradeList, JSONArray gradeArray) {
        Iterator<?> i = gradeArray.iterator();
        while (i.hasNext()) {
            gradeList.add(Double.parseDouble(i.next().toString()));
        }
    }

    public final void setName(String studentName) {
        this.name = studentName;
    }
    public final String getName() {
        return this.name;
    }
    public final void setExamGrade(double grade) {
        this.examGrade = grade;
    }
    public final double getExamGrade() {
        return examGrade;
    }
    public abstract double finalGrade();
    public final String toString() {
        return name + ' ' + finalGrade();
    } //must consist of name and grade with a  single space between and no other characters.
}
