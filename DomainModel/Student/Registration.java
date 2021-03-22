package DomainModel.Student;

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

}
