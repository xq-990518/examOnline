package entity;


import java.util.List;

//考题类
public class Question {
    private int q_id;
    private String q_name;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int mark;
    private String answer;
    private String resolution;
    private Subject subject;
    private List<Exam> exams;

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getQ_id() {
        return q_id;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }

    public String getQ_name() {
        return q_name;
    }

    public void setQ_name(String q_name) {
        this.q_name = q_name;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question(int q_id, String q_name, String optionA, String optionB, String optionC, String optionD, int mark, String answer, String resolution, Subject subject) {
        this.q_id = q_id;
        this.q_name = q_name;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.mark = mark;
        this.answer = answer;
        this.resolution = resolution;
        this.subject = subject;
    }

    public Question(int q_id, String q_name, String optionA, String optionB, String optionC, String optionD, int mark, String answer, String resolution) {
        this.q_id = q_id;
        this.q_name = q_name;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.mark = mark;
        this.answer = answer;
        this.resolution = resolution;
    }

    public Question(int q_id, String q_name, String optionA, String optionB, String optionC, String optionD, int mark, String answer, String resolution, Subject subject, List<Exam> exams) {
        this.q_id = q_id;
        this.q_name = q_name;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.mark = mark;
        this.answer = answer;
        this.resolution = resolution;
        this.subject = subject;
        this.exams = exams;
    }

    public Question() {
    }
}
