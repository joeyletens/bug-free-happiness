package DomainModel;

public class Webcast {
  private String title;
  private int duration;
  private String speakerName;
  private String speakerEmail;
  private String url;

  public Webcast(String title, int duration, String speakerName, String speakerEmail, String url) {
    this.title = title;
    this.duration = duration;
    this.speakerName = speakerName;
    this.speakerEmail = speakerEmail;
    this.url = url;
  }

}
