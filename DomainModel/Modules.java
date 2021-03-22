package DomainModel;

public class Modules {
  private String title;
  private String version;
  private int duration;
  private String contactPersonEmail;
  private int courseNumber;

  public Modules(String title, String version, int duration, String contactPersonEmail, int courseNumber) {
    this.title = title;
    this.version = version;
    this.duration = duration;
    this.contactPersonEmail = contactPersonEmail;
    this.courseNumber = courseNumber;
  }

}
