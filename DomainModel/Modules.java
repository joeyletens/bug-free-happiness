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

}
