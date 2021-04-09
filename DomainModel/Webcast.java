package DomainModel;

import java.sql.Date;

public class Webcast extends ContentItem {
  private String title;
  private String speakerName;
  private String speakerEmail;
  private String url;
  private String duration;

  public Webcast(int contentId, Date publicationDate, String status, String description, String title,
      String speakerName, String speakerEmail, String url, String duration, int progress) {
    super(contentId, publicationDate, status, description, progress);
    this.title = title;
    this.speakerName = speakerName;
    this.speakerEmail = speakerEmail;
    this.url = url;
    this.duration = duration;
  }

}
