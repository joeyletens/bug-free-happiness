package UnitTest.ValidationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;

import UnitTest.ValidationMethods.PostalCode;

public class PostalCodeTest {
  /**
   * @subcontract null postalCode {
   * @requires postalCode == null;
   * @signals (NullPointerException) postalCode == null; }
   */

  @Test(expected = NullPointerException.class)
  public void testFormatPostalCodeRequiresNullSignalsNullPointerException() {
    // Arrange
    String postalCode = null;

    // Act
    String result = PostalCode.formatPostalCode(postalCode);

  }

  /**
   * @subcontract valid postalCode {
   * @requires Integer.valueOf(postalCode.trim().substring(0, 4)) > 999 &&
   *           Integer.valueOf(postalCode.trim().substring(0, 4)) <= 9999 &&
   *           postalCode.trim().substring(4).trim().length == 2 && 'A' <=
   *           postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <=
   *           'Z' && 'A' <=
   *           postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <=
   *           'Z';
   * @ensures \result = postalCode.trim().substring(0, 4) + " " +
   *          postalCode.trim().substring(4).trim().toUpperCase() }
   */

  @Test
  public void testFormatPostalCodeRequiresPostalCodeThousandEnsuresPostalCodeAboveThousand() {
    // Arrange
    String postalCode = "1000AA";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);

    // Assert
    assertEquals("1000AA", result);
  }

  @Test
  public void testFormatPostalCodeRequiresPostalCodeTenThousandEnsuresPostalCodeBelowTenThousand() {
    // Arrange
    String postalCode = "9999AA";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);

    // Assert
    assertEquals("9999AA", result);
  }

  @Test
  public void testFormatPostalCodeRequiresPostalCodeWithASpaceBeforeThePostalCodeEnsuresValidPostalCode() {
    // Arrange
    String postalCode = " 1000AA";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);

    // Assert
    assertEquals("1000AA", result);
  }

  @Test
  public void testFormatPostalCodeRequiresLowerCaseLettersEnsuresPutLettersToUpperCase() {
    // Arrange
    String postalCode = "1000AA ";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);

    // Assert
    assertEquals("1000AA", result);
  }

  @Test
  public void testFormatPostalCodeRequiresPostalCodeWithASpaceInTheFirstPartEnsureValidPostalCode() {
    // Arrange
    String postalCode = "10 00AA";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);

    // Assert
    assertEquals("1000AA", result);
  }

  @Test
  public void testFormatPostalCodeRequiresPostCodeWithSpaceBetweenTheLetters() {
    // Arrange
    String postalCode = "1000A A";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);

    // Assert
    assertEquals("1000AA", result);
  }

  @Test
  public void testFormatPostalCodeRequiresPostCodeWithLowerCaseLettersEnsureValidPostalCodeWithUpperCase() {
    // Arrange
    String postalCode = "1000aa";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);

    // Assert
    assertEquals("1000AA", result);
  }

  /**
   * @subcontract invalid postalCode {
   * @requires no other valid precondition;
   * @signals (IllegalArgumentException); }
   */

  @Test(expected = IllegalArgumentException.class)
  public void testFormatPostalCodeRequiresThreeNumbersAndTwoLettersSignalsIllegalArgumentException() {
    // Arrange
    String postalCode = "999AA";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFormatPostalCodeRequiresFiveNumbersAndTwoLettersSignalsIllegalArgumentException() {
    // Arrange
    String postalCode = "99999AA";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFormatPostalCodeRequiresFourNumbersAndOneLettersSignalsIllegalArgumentException() {
    // Arrange
    String postalCode = "1000A";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testFormatPostalCodeRequiresFourNumbersAndThreeLettersSignalsIllegalArgumentException() {
    // Arrange
    String postalCode = "1000AAA";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);
  }

  public void testFormatPostalCodeRequiresEmptyPostalCodeSignalsIllegalArgumentException() {
    // Arrange
    String postalCode = "";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFormatPostalCodeRequiresOnlyNumbersSignalsIllegalArgumentException() {
    // Arrange
    String postalCode = "1000";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testFormatPostalCodeRequiresOnlyLettersSignalsIllegalArgumentException() {
    // Arrange
    String postalCode = "AA";

    // Act
    String result = PostalCode.formatPostalCode(postalCode);
  }

}
