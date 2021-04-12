package DomainModel;

import java.sql.Date;

public class Registration {
  private String courseName;
  private String email;
  private Date applacationDate;

  public Registration(String courseName, String email, Date applacationDate) {
    this.courseName = courseName;
    this.email = email;
    this.applacationDate = applacationDate;
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

  public Date getApplacationDate() {
    return applacationDate;
  }

  public void setApplacationDate(Date applacationDate) {
    this.applacationDate = applacationDate;
  }

}
