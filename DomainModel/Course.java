package DomainModel;

import java.util.ArrayList;

public class Course {
  private int idNumber;
  private String courseName;
  private String subject;
  private String introductionText;
  private String courseLevel;
  private ArrayList<Course> relatedCourses;

  public Course(int idNumber, String courseName, String subject, String introductionText, String courseLevel) {
    this.idNumber = idNumber;
    this.courseName = courseName;
    this.subject = subject;
    this.introductionText = introductionText;
    this.courseLevel = courseLevel;
  }

  public int getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(int idNumber) {
    this.idNumber = idNumber;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getIntroductionText() {
    return introductionText;
  }

  public void setIntroductionText(String introductionText) {
    this.introductionText = introductionText;
  }

  public String getCourseLevel() {
    return courseLevel;
  }

  public void setCourseLevel(String courseLevel) {
    this.courseLevel = courseLevel;
  }

  public ArrayList<Course> getRelatedCourses() {
    return relatedCourses;
  }

  public void setRelatedCourses(ArrayList<Course> relatedCourses) {
    this.relatedCourses = relatedCourses;
  }

}
