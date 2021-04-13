package DomainModel;

public class Viewed {
  private int contentId;
  private String email;
  private int progress;

  public Viewed(int contentId, String email) {
    this.contentId = contentId;
    this.email = email;
  }

  public int getContentId() {
    return contentId;
  }

  public void setContentId(int contentId) {
    this.contentId = contentId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getProgress() {
    return progress;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

}
