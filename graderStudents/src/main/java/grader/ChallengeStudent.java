package grader;

import org.json.simple.JSONObject;

public final class ChallengeStudent extends Student {
    private double projectGrade;
    private final double examWeight = 0.5;
    private final double projectWeight = 0.5;
    private final double maxGrade = 100;

    ChallengeStudent(JSONObject studentData) {
        parseStudentData(studentData);
    }

    @Override
    public void parseStudentData(JSONObject studentData) {
        this.projectGrade = Double.parseDouble(studentData.get("projectGrade").toString());
        setName(studentData.get("name").toString());
        setExamGrade(Double.parseDouble(studentData.get("examGrade").toString()));
    }

    @Override
    public double finalGrade() {
        double finalGrade = projectGrade * projectWeight + getExamGrade() * examWeight;
        if (finalGrade > maxGrade){
            finalGrade = maxGrade;
        }
        return finalGrade;
    }
}
