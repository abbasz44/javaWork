package grader;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public final class AssignmentStudent  extends Student implements ResearchSubject {
    private ArrayList<Double> assignmentGrades;
    private ArrayList<Double> quizGrades;
    private boolean participating = false;
    private final double quizWeight = 0.3;
    private final double examWeight = 0.2;
    private final double assignmentWeght = 0.5;
    private final double researchBonus = 0.05;
    private final double maxGrade = 60;

    AssignmentStudent(){
        this.assignmentGrades = new ArrayList<Double>();
        this.quizGrades = new ArrayList<Double>();
    }

    AssignmentStudent(JSONObject studentData) {
        this.assignmentGrades = new ArrayList<Double>();
        this.quizGrades = new ArrayList<Double>();
        parseStudentData(studentData);
    }

    @Override
    public void parseStudentData(JSONObject studentData) {
        JSONArray aGrades = (JSONArray) studentData.get("assignmentGrades");
        loadGradeList(assignmentGrades, aGrades);
        JSONArray qGrades = (JSONArray) studentData.get("quizGrades");
        loadGradeList(quizGrades, qGrades);
        participating = (studentData.get("participating").toString().equals("true"));
        setName(studentData.get("name").toString());
        setExamGrade(Double.parseDouble(studentData.get("examGrade").toString()));
    }

    public ArrayList<Double> getAssignmentGrades() {
        return assignmentGrades;
    }
    public void setAssignmentGrades(ArrayList<Double> gradeList) {
        this.assignmentGrades = gradeList;
    }
    public ArrayList<Double> getQuizGrades() {
        return quizGrades;
    }
    public void setQuizGrades(ArrayList<Double> gradeList) {
        this.quizGrades = gradeList;
    }
    public boolean getParticipating() {
        return participating;
    }
    @Override
    public void setParticipating(boolean isParticipating) {
        this.participating = isParticipating;
    }

    private double calculateFinalGrade() {
        double quizFinal = getGradelistAverage(quizGrades)*quizWeight;
        double assignmentFinal = getGradelistAverage(assignmentGrades)*assignmentWeght;
        double examFinal = getExamGrade()*examWeight;

        double finalGrade;
        if (participating) {
            finalGrade = quizFinal+assignmentFinal+examFinal+researchPerk();
        } else {
            finalGrade = quizFinal+assignmentFinal+examFinal;
        }
        return finalGrade;
    }

    @Override
    public double finalGrade() {
        double finalGrade = calculateFinalGrade();
        if (finalGrade > maxGrade){
            finalGrade = maxGrade;
        }
        return finalGrade;
    }

    @Override
    public double researchPerk() {
        return maxGrade*researchBonus;
    }

}
