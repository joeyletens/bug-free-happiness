package DomainModel;

import java.sql.Date;

public class ContentItem {
  private int contentId;
  private Date publicationDate;
  private String status;
  private String description;
  private int duration;
  private int progress;

  public ContentItem(int contentId, Date publicationDate, String status, String description, int duration) {
    this.contentId = contentId;
    this.publicationDate = publicationDate;
    this.status = status;
    this.description = description;
    this.duration = duration;
  }

  public int getProgress() {
    return progress;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

}
