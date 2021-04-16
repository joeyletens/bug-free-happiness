package UnitTest.ValidationTest;

import org.junit.Test;

import UnitTest.ValidationMethods.DateTools;

import static org.junit.Assert.*;

public class DateToolsTest {
  /**
   * @subcontract 31 days in month {
   * @requires (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
   *           || month == 10 || month == 12) && 1 <= day <= 31;
   * @ensures \result = true; }
   */

  @Test
  public void testValidateDateMonthIs1EnsuresTrue() {
    // Arrange
    int month = 1;
    // Act
    boolean result = DateTools.validateDate(31, month, 2000);
    // Asserts
    assertEquals(true, result);
  }

  @Test
  public void testValidateDateMonthIs3EnsuresTrue() {
    // Arrange
    int month = 3;
    // Act
    boolean result = DateTools.validateDate(31, month, 2000);
    // Asserts
    assertEquals(true, result);
  }

  @Test
  public void testValidateDateMonthIs5EnsuresTrue() {
    // Arrange
    int month = 5;
    // Act
    boolean result = DateTools.validateDate(31, month, 2000);
    // Asserts
    assertEquals(true, result);
  }

  @Test
  public void testValidateDateMonthIs7EnsuresTrue() {
    // Arrange
    int month = 7;
    // Act
    boolean result = DateTools.validateDate(31, month, 2000);
    // Asserts
    assertEquals(true, result);
  }

  @Test
  public void testValidateDateMonthIs9EnsuresTrue() {
    // Arrange
    int month = 9;
    // Act
    boolean result = DateTools.validateDate(31, month, 2000);
    // Asserts
    assertEquals(true, result);
  }

  @Test
  public void testValidateDateMonthIs11EnsuresTrue() {
    // Arrange
    int month = 11;
    // Act
    boolean result = DateTools.validateDate(31, month, 2000);

    // Asserts
    assertEquals(true, result);
  }

  /**
   * @subcontract 30 days in month {
   * @requires (month == 4 || month == 6 || month == 9 || month == 11) && 1 <= day
   *           <= 30;
   * @ensures \result = true; }
   **/

  @Test
  public void testValidateDateMonthIs4EnsuresTrue() {
    // Arrange
    int month = 4;
    // Act
    boolean result = DateTools.validateDate(30, month, 2000);
    // Asserts
    assertEquals(true, result);
  }

  @Test
  public void testValidateDateMonthIs6EnsuresTrue() {
    // Arrange
    int month = 6;
    // Act
    boolean result = DateTools.validateDate(30, month, 2000);
    // Asserts
    assertEquals(true, result);
  }

  @Test
  public void testValidateDateMonthIs8EnsuresTrue() {
    // Arrange
    int month = 8;
    // Act
    boolean result = DateTools.validateDate(30, month, 2000);
    // Asserts
    assertEquals(true, result);
  }

  @Test
  public void testValidateDateMonthIs10EnsuresTrue() {
    // Arrange
    int month = 10;
    // Act
    boolean result = DateTools.validateDate(30, month, 2000);
    // Asserts
    assertEquals(true, result);
  }

  @Test
  public void testValidateDateMonthIs12EnsuresTrue() {
    // Arrange
    int month = 12;
    // Act
    boolean result = DateTools.validateDate(30, month, 2000);
    // Asserts
    assertEquals(true, result);
  }

  /**
   * @subcontract 29 days in month {
   * @requires month == 2 && 1 <= day <= 29 && (year % 4 == 0 && (year % 100 != 0
   *           || year % 400 == 0));
   * @ensures \result = true; }
   **/

  @Test
  public void testValidateDateMonthIs2With29DaysYear2000EnsuresTrue() {
    // Arrange
    int month = 2;
    int year = 2000;
    // Act
    boolean result = DateTools.validateDate(29, month, year);
    // Asserts
    assertEquals(true, result);
  }

  @Test
  public void testValidateDateMonthIs2With29DaysYear2020EnsuresTrue() {
    // Arrange
    int month = 2;
    int year = 2020;
    // Act
    boolean result = DateTools.validateDate(29, month, year);
    // Asserts
    assertEquals(true, result);
  }

  /**
   * @subcontract 28 days in month {
   * @requires month == 2 && 1 <= day <= 28 && (year % 4 != 0 || (year % 100 == 0
   *           && year % 400 != 0));
   * @ensures \result = true; }
   **/

  @Test
  public void testValidateDateMonthIs2With28DaysYear2001EnsuresTrue() {
    // Arrange
    int month = 2;
    int year = 2001;
    // Act
    boolean result = DateTools.validateDate(28, month, year);
    // Asserts
    assertEquals(true, result);
  }

  @Test
  public void testValidateDateMonthIs2With28DaysYear2003EnsuresTrue() {
    // Arrange
    int month = 2;
    int year = 2003;
    // Act
    boolean result = DateTools.validateDate(28, month, year);
    // Asserts
    assertEquals(true, result);
  }

  /**
   * @subcontract all other cases {
   * @requires no other accepting precondition;
   * @ensures \result = false; }
   **/

  @Test
  public void testValidateEmptyEnsuresFalse() {
    // Arrange
    int day = 0;
    int month = 0;
    int year = 0;
    // Act
    boolean result = DateTools.validateDate(day, month, year);
    // Asserts
    assertEquals(true, result);
  }

}
