package UnitTest.ValidationMethods;

public class PostalCode {
  /**
   * @desc Formats the input postal code to a uniform output in the form
   *       nnnn<space>MM, where nnnn is numeric and > 999 and MM are 2 capital
   *       letters. Spaces before and after the input string are trimmed.
   * 
   * @subcontract null postalCode {
   * @requires postalCode == null;
   * @signals (NullPointerException) postalCode == null; }
   * 
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
   * 
   * @subcontract invalid postalCode {
   * @requires no other valid precondition;
   * @signals (IllegalArgumentException); }
   * 
   */
  public static boolean formatPostalCode(/* non_null */ String postalCode) {

    String regex = " *[1-9][0-9]{3} ?(?!sa|sd|ss)[a-z]{2} *";
    if (postalCode.toLowerCase().matches(regex)) {
      return true;
    } else {
      return false;
    }

  }
}
