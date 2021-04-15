package DomainModel;

import java.sql.Date;

public class Modules extends ContentItem {
  private String title;
  private String version;
  private String contactPersonEmail;
  private int followNumber;
  private Course course;

  public Modules(int contentId, Date publicationDate, String status, String description, String title, String version,
      String contactPersonEmail, int followNumber, int progress) {
    super(contentId, publicationDate, status, description, progress);
    this.title = title;
    this.version = version;
    this.contactPersonEmail = contactPersonEmail;
    this.followNumber = followNumber;
  }

  public String getTitle() {
    return title;
  }

  public Course returnCourse() {
    return course;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getContactPersonEmail() {
    return contactPersonEmail;
  }

  public void setContactPersonEmail(String contactPersonEmail) {
    this.contactPersonEmail = contactPersonEmail;
  }

  public int getfollowNumber() {
    return followNumber;
  }

  public void setfollowNumber(int followNumber) {
    this.followNumber = followNumber;
  }

}
