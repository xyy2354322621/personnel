package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/21 0021.
 */
public class Resume {
    private long resume_no;
    private String tourist_no;
    private String tourist_name;
    private String birthday;
    private String id_no;
    private String phone;
    private String email;
    private String introduction;
    private String education;
    private String gender;
    private String graduate_academy;
    private String employment_record;
    private String education_background;
    private String project_experience;
    private int exist;

    public long getResume_no() {
        return resume_no;
    }

    public void setResume_no(long resume_no) {
        this.resume_no = resume_no;
    }

    public String getTourist_no() {
        return tourist_no;
    }

    public void setTourist_no(String tourist_no) {
        this.tourist_no = tourist_no;
    }

    public String getTourist_name() {
        return tourist_name;
    }

    public void setTourist_name(String tourist_name) {
        this.tourist_name = tourist_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGraduate_academy() {
        return graduate_academy;
    }

    public void setGraduate_academy(String graduate_academy) {
        this.graduate_academy = graduate_academy;
    }

    public String getEmployment_record() {
        return employment_record;
    }

    public void setEmployment_record(String employment_record) {
        this.employment_record = employment_record;
    }

    public String getEducation_background() {
        return education_background;
    }

    public void setEducation_background(String education_background) {
        this.education_background = education_background;
    }

    public String getProject_experience() {
        return project_experience;
    }

    public void setProject_experience(String project_experience) {
        this.project_experience = project_experience;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "resume_no=" + resume_no +
                ", tourist_no='" + tourist_no + '\'' +
                ", tourist_name='" + tourist_name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", id_no='" + id_no + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", introduction='" + introduction + '\'' +
                ", education='" + education + '\'' +
                ", gender='" + gender + '\'' +
                ", graduate_academy='" + graduate_academy + '\'' +
                ", employment_record='" + employment_record + '\'' +
                ", education_background='" + education_background + '\'' +
                ", project_experience='" + project_experience + '\'' +
                ", exist=" + exist +
                '}';
    }
}
