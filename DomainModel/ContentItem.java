package DomainModel;

import java.sql.Date;

public class ContentItem {
  private int contentId;
  private Date publicationDate;
  private String status;
  private String description;

  public ContentItem(int contentId, Date publicationDate, String status, String description) {
    this.contentId = contentId;
    this.publicationDate = publicationDate;
    this.status = status;
    this.description = description;
  }

}
