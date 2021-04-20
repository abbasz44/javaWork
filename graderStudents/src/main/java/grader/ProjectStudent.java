package grader;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public final class ProjectStudent extends Student implements ResearchSubject {
    private ArrayList<Double> milestoneGrades;
    private double midtermGrade;
    private boolean participating = false;
    private final double milestoneWeight = 0.6;
    private final double examWeight = 0.2;
    private final double midtermWeight = 0.2;
    private final double researchBonus = 0.05;
    private final double maxGrade = 100;

    ProjectStudent() {
        this.milestoneGrades = new ArrayList<Double>();
    }

    ProjectStudent(JSONObject studentData) {
        this.milestoneGrades = new ArrayList<Double>();
        parseStudentData(studentData);
    }

    public double getMidtermGrade() {
        return midtermGrade;
    }
    public void setMidtermGrade(double newGrade) {
        this.midtermGrade = newGrade;
    }
    public boolean getParticipating() {
        return participating;
    }
    @Override
    public void setParticipating(boolean isParticipating) {
        this.participating = isParticipating;
    }

    @Override
    public void parseStudentData(JSONObject studentData) {
        JSONArray mGrades = (JSONArray) studentData.get("milestoneGrades");
        loadGradeList(milestoneGrades, mGrades);
        setName(studentData.get("name").toString());
        participating = (studentData.get("participating").toString().equals("true"));
        setExamGrade(Double.parseDouble(studentData.get("examGrade").toString()));
        setMidtermGrade(Double.parseDouble(studentData.get("midtermGrade").toString()));
    }

    private double calculateFinalGrade() {
        double milestoneFinal = getGradelistAverage(milestoneGrades)*milestoneWeight;
        double midtermFinal = getMidtermGrade()*midtermWeight;
        double examFinal = getExamGrade()*examWeight;
        double finalGrade;
        if (participating) {
            finalGrade = milestoneFinal+midtermFinal+examFinal+researchPerk();
        } else {
            finalGrade = milestoneFinal+midtermFinal+examFinal;
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

    public double researchPerk() {
        return maxGrade*researchBonus;
    }
}
