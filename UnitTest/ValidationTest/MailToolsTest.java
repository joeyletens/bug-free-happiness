package UnitTest.ValidationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import UnitTest.ValidationMethods.MailTools;

public class MailToolsTest {
  /**
   * @subcontract no mailbox part {
   * @requires !mailAddress.contains("@") || mailAddress.split("@")[0].length < 1;
   * @ensures \result = false; }
   */
  @Test
  public void testValidateEmailRequiresNoAtEnsuresFalse() {
    // Arrange
    String email = "@gmail.com";

    // Act
    boolean result = MailTools.validateMailAddress(email);

    // Assert
    assertEquals(false, result);
  }

  /**
   * @subcontract subdomain-tld delimiter {
   * @requires !mailAddress.contains("@") ||
   *           mailAddress.split("@")[1].split(".").length > 2;
   * @ensures \result = false; }
   */
  @Test
  public void testValidateEmailRequiresTwoDotsEnsuresFalse() {
    // Arrange
    String email = "email@gmail.com.nl";

    // Act
    boolean result = MailTools.validateMailAddress(email);

    // Assert
    assertEquals(false, result);
  }

  /**
   * @subcontract no subdomain part {
   * @requires !mailAddress.contains("@") ||
   *           mailAddress.split("@")[1].split(".")[0].length < 1;
   * @ensures \result = false; }
   */
  @Test
  public void testValidateMailAddressRequiresNoCharacterBetweenAtAndDotEnsuresFalse() {
    // Arrange
    String email = "email@.com";

    // Act
    boolean result = MailTools.validateMailAddress(email);
    // Assert
    assertEquals(false, result);
  }

  /**
   * @subcontract no tld part {
   * @requires !mailAddress.contains("@") ||
   *           mailAddress.split("@")[1].split(".")[1].length < 1;
   * @ensures \result = false; }
   */
  @Test
  public void testValidationMailAddressRequiresNoCharacterAfterDotEnsuresFalse() {
    // Arrange
    String email = "email@gmail.";

    // Act
    boolean result = MailTools.validateMailAddress(email);

    // Assert
    assertEquals(false, result);
  }

  /**
   * @subcontract valid email {
   * @requires no other precondition
   * @ensures \result = true; }
   * 
   */
  @Test
  public void testValidationMailAddressRequiresNoOtherPreconditionEnsuresTrue() {
    // Arrange
    String email = "email@gmail.com";

    // Act
    boolean result = MailTools.validateMailAddress(email);

    // Assert
    assertEquals(true, result);
  }
}
