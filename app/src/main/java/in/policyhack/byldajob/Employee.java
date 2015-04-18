package in.policyhack.byldajob;

import java.util.ArrayList;

/**
 * Created by raghav on 18/04/15.
 */
public class Employee {
    String name;
    char gender;
    String dob;
    String motherTongue;
    String state;
    String district;
    String policeVerification;
    Double adhaarNumber;
    Double mobileNumber;
    String highestEducation;
    int workEx;
    int previousSalary;
    String sector;
    String speciality;
    String certificateAvailable;
    int marks;
    int retention;
    int lastEmployedAt;

    static ArrayList<Employee> chosenEmployee = new ArrayList<>();

    public static int rateEmployee(Employee employee){
        int rating = 0;
        int workexrating = 2*employee.workEx/4;
        int marksRating = 1*employee.marks/100;
        int lastEmployedRating = 2*employee.lastEmployedAt/6;
        int retentionRating = 2*employee.retention/6;
        int policeVerificationRating = 2;
        if(employee.policeVerification.equals("NO")){
            policeVerificationRating = 0;
        }
        rating = (workexrating+marksRating+lastEmployedRating+retentionRating+policeVerificationRating)/9;
        return rating;
    }

}
