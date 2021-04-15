package DomainModel;

public class Registration {
  private String courseName;
  private String email;
  private String applicationDate;

  public Registration(String email, String courseName, String applicationDate) {
    this.courseName = courseName;
    this.email = email;
    this.applicationDate = applicationDate;

  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(String applicationDate) {
    this.applicationDate = applicationDate;
  }

}
