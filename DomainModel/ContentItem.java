package DomainModel;

public class ContentItem {
  private int contentId;
  private String publicationDate;
  private Status status;
  private String description;
  protected int duration;
  protected int progress;

  public ContentItem(int contentId, String publicationDate, Status status, String description, int duration) {
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

  public String getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(String publicationDate) {
    this.publicationDate = publicationDate;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
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
