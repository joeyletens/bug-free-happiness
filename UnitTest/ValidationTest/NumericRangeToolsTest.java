package UnitTest.ValidationTest;

import static org.junit.Assert.*;
import org.junit.Test;

import UnitTest.ValidationMethods.NumericRangeTools;

public class NumericRangeToolsTest {
  /**
   * @subcontract value within valid range {
   * @requires 0 <= percentage <= 100;
   * @ensures \result = true; }
   **/
  @Test
  public void testNumericRangeRequires50EnsuresTrue() {
    // Arrange
    int percentage = 50;

    // Act
    boolean result = NumericRangeTools.isValidPercentage(percentage);

    // Asserts
    assertEquals(true, result);
  }

  /**
   * @subcontract value within valid range {
   * @requires 0 <= percentage <= 100;
   * @ensures \result = true; }
   **/
  @Test
  public void testNumericRangeRequires0EnsuresTrue() {
    // Arrange
    int percentage = 0;

    // Act
    boolean result = NumericRangeTools.isValidPercentage(percentage);

    // Asserts
    assertEquals(true, result);
  }

  /**
   * @subcontract value within valid range {
   * @requires 0 <= percentage <= 100;
   * @ensures \result = true; }
   **/
  @Test
  public void testNumericRangeRequires100EnsuresTrue() {
    // Arrange
    int percentage = 100;

    // Act
    boolean result = NumericRangeTools.isValidPercentage(percentage);

    // Asserts
    assertEquals(true, result);
  }

  /**
   * @subcontract value out of range low {
   * @requires percentage < 0;
   * @ensures \result = false; }
   **/
  public void testNumericRangeRequiresMinus1EnsuresFalse() {
    // Arrange
    int percentage = -1;

    // Act
    boolean result = NumericRangeTools.isValidPercentage(percentage);

    // Asserts
    assertEquals(false, result);
  }

  /**
   * @subcontract value out of range high {
   * @requires percentage > 100;
   * @signals \result = false; }
   **/
  public void testNumericRangeRequires101EnsuresFalse() {
    // Arrange
    int percentage = 101;

    // Act
    boolean result = NumericRangeTools.isValidPercentage(percentage);

    // Asserts
    assertEquals(false, result);
  }
}
