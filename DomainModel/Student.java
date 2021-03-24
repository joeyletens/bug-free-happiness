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

  public String getEmai() {
    return emai;
  }

  public void setEmai(String emai) {
    this.emai = emai;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

}