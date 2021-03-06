package UnitTest.ValidationMethods;

public class MailTools {
  /**
   * @desc Validates if mailAddress is valid. It should be in the form of: <at
   *       least 1 character>@<at least 1 character>.<at least 1 character>
   * 
   * @subcontract no mailbox part {
   * @requires !mailAddress.contains("@") || mailAddress.split("@")[0].length < 1;
   * @ensures \result = false; }
   * 
   * @subcontract subdomain-tld delimiter {
   * @requires !mailAddress.contains("@") ||
   *           mailAddress.split("@")[1].split(".").length > 2;
   * @ensures \result = false; }
   * 
   * @subcontract no subdomain part {
   * @requires !mailAddress.contains("@") ||
   *           mailAddress.split("@")[1].split(".")[0].length < 1;
   * @ensures \result = false; }
   * 
   * @subcontract no tld part {
   * @requires !mailAddress.contains("@") ||
   *           mailAddress.split("@")[1].split(".")[1].length < 1;
   * @ensures \result = false; }
   * 
   * @subcontract valid email {
   * @requires no other precondition
   * @ensures \result = true; }
   * 
   */
  public static boolean validateMailAddress(String email) {
    String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    if (email.matches(regex)) {
      return true;
    } else {
      return false;
    }
  }
}
