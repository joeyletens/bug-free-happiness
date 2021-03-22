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

}
