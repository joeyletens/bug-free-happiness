package DomainModel;

import java.sql.Date;

public class Student {
  private String emai;
  private String firstName;
  private String lastName;
  private Date dateOfBirth;
  private String gender;
  private String address;
  private String postalCode;
  private String city;
  private String country;

  public Student(String emai, String firstName, String lastName, Date dateOfBirth, String gender, String address,
      String postalCode, String city, String country) {
    this.emai = emai;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.address = address;
    this.postalCode = postalCode;
    this.city = city;
    this.country = country;
  }

}