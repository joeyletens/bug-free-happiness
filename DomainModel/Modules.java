package DomainModel;

import java.sql.Date;

public class Modules extends ContentItem {
  private String title;
  private String version;
  private String contactPersonEmail;
  private int courseNumber;

  public Modules(int contentId, Date publicationDate, String status, String description, String title, String version,
      String contactPersonEmail, int courseNumber, int progress) {
    super(contentId, publicationDate, status, description, progress);
    this.title = title;
    this.version = version;
    this.contactPersonEmail = contactPersonEmail;
    this.courseNumber = courseNumber;
  }

  public String getTitle() {
    return title;
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

  public int getCourseNumber() {
    return courseNumber;
  }

  public void setCourseNumber(int courseNumber) {
    this.courseNumber = courseNumber;
  }

}
