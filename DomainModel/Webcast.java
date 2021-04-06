package DomainModel;

import java.sql.Date;

public class Webcast extends ContentItem {
  private String title;
  private String speakerName;
  private String speakerEmail;
  private String url;

  public Webcast(int contentId, Date publicationDate, String status, String description, String title,
      String speakerName, String speakerEmail, String url) {
    super(contentId, publicationDate, status, description);
    this.title = title;
    this.speakerName = speakerName;
    this.speakerEmail = speakerEmail;
    this.url = url;
  }

}
