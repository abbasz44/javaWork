package grader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public final class Roster {
    private ArrayList<Student> studentList;

    public static void main(String[] args) {
        Roster roster = new Roster("src/main/resources/roster.json");
        ArrayList<Student> thing = roster.getStudents();
        System.out.println(thing.get(0).finalGrade());
        System.out.println(thing.get(1).finalGrade());
        System.out.println(thing.get(2).finalGrade());
    }
    public Roster(String jsonFilename) {
        JSONParser parser = new JSONParser();
        studentList = new ArrayList<Student>();
        try {
            Object obj = parser.parse(new FileReader(jsonFilename));

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray students = (JSONArray) jsonObject.get("students");
            addStudents(students);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Student> getStudents() {
        return studentList;
    }

    private void addStudents(JSONArray studentData) {
        Iterator<?> i = studentData.iterator();

        while (i.hasNext()) {
            JSONObject studentJSON = (JSONObject) i.next();
            String stream = studentJSON.get("stream").toString();

            addStudentByStream(stream, studentJSON);
        }
    }

    private void addStudentByStream(String stream, JSONObject studentJSON) {
        if (stream.equals("challenge")) {
            studentList.add(new ChallengeStudent(studentJSON));
        } else if (stream.equals("assignment")) {
            studentList.add(new AssignmentStudent(studentJSON));
        } else if (stream.equals("project")) {
            studentList.add(new ProjectStudent(studentJSON));
        }
    }
}
