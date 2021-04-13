package DomainModel;

import java.sql.Date;

public class ContentItem {
  private int contentId;
  private Date publicationDate;
  private String status;
  private String description;
  private int duration;
  protected int progress;

  public ContentItem(int contentId, Date publicationDate, String status, String description, int duration) {
    this.contentId = contentId;
    this.publicationDate = publicationDate;
    this.status = status;
    this.description = description;
    this.duration = duration;
    this.progress = 0;
  }

  public int getProgress() {
    return progress;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

  public int getContentId() {
    return contentId;
  }

  public void setContentId(int contentId) {
    this.contentId = contentId;
  }

  public Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(Date publicationDate) {
    this.publicationDate = publicationDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

}
