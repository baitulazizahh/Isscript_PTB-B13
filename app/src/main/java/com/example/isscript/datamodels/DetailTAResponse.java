package com.example.isscript.datamodels;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DetailTAResponse{

    @SerializedName("student")
    private Student student;

    @SerializedName("student_id")
    private int studentId;

    @SerializedName("grade_by")
    private int gradeBy;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("abstract")
    private String jsonMemberAbstract;

    @SerializedName("title")
    private String title;

    @SerializedName("start_at")
    private String startAt;

    @SerializedName("created_by")
    private int createdBy;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("trials")
    private List<TrialsItem> trials;

    @SerializedName("seminars")
    private List<SeminarsItem> seminars;

    @SerializedName("grade")
    private String grade;

    @SerializedName("id")
    private int id;

    @SerializedName("topic_id")
    private int topicId;

    @SerializedName("status")
    private int status;

    @SerializedName("supervisors")
    private List<SupervisorsItem> supervisors;

    public Student getStudent(){
        return student;
    }

    public int getStudentId(){
        return studentId;
    }

    public int getGradeBy(){
        return gradeBy;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public String getJsonMemberAbstract(){
        return jsonMemberAbstract;
    }

    public String getTitle(){
        return title;
    }

    public String getStartAt(){
        return startAt;
    }

    public int getCreatedBy(){
        return createdBy;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public List<TrialsItem> getTrials(){
        return trials;
    }

    public List<SeminarsItem> getSeminars(){
        return seminars;
    }

    public String getGrade(){
        return grade;
    }

    public int getId(){
        return id;
    }

    public int getTopicId(){
        return topicId;
    }

    public int getStatus(){
        return status;
    }

    public List<SupervisorsItem> getSupervisors(){
        return supervisors;
    }
}