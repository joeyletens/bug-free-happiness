package ApplicationLogic;

import DomainModel.Viewed;

public class CourseController {
  public void getModuleProgress(Viewed viewed) {
    // This method return a students progress in a certain module and display it
  }

  public void getWebcastProgress(Viewed viewed) {
    // This method returns the progress made by a student and displays it
  }

  public void makeProgressInModule(int progress, Viewed viewed) {
    // lets a student make progress in a module
  }

  public void makeProgressInWebcast(int progress, Viewed viewed) {
    // lets a student make progress in a webcast
  }

  public boolean checkIfStudentIsRegisteredToCourse(Viewed viewed) {
    // This method returns a boolean value to check if the student is registrered to
    // a course
    return false;
  }

}
