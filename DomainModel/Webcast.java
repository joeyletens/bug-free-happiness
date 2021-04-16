package DomainModel;

public class Webcast extends ContentItem {
  private String title;
  private String speakerName;
  private String speakerEmail;
  private String url;

  public Webcast(int contentId, String publicationDate, Status status, String description, int duration, String title,
      String speakerName, String speakerEmail, String url) {
    super(contentId, publicationDate, status, description, duration);
    this.title = title;
    this.speakerName = speakerName;
    this.speakerEmail = speakerEmail;
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSpeakerName() {
    return speakerName;
  }

  public void setSpeakerName(String speakerName) {
    this.speakerName = speakerName;
  }

  public String getSpeakerEmail() {
    return speakerEmail;
  }

  public void setSpeakerEmail(String speakerEmail) {
    this.speakerEmail = speakerEmail;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
