package in.policyhack.byldajob;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by raghav on 18/04/15.
 */
public class Employee {
    String name;
    String dob;
    String motherTongue;

    public int getLastEmployedAt() {
        return lastEmployedAt;
    }

    public void setLastEmployedAt(int lastEmployedAt) {
        this.lastEmployedAt = lastEmployedAt;
    }

    public int getRetention() {
        return retention;
    }

    public void setRetention(int retention) {
        this.retention = retention;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getPreviousSalary() {
        return previousSalary;
    }

    public void setPreviousSalary(int previousSalary) {
        this.previousSalary = previousSalary;
    }

    public int getWorkEx() {
        return workEx;
    }

    public void setWorkEx(int workEx) {
        this.workEx = workEx;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAdhaarNumber() {
        return adhaarNumber;
    }

    public void setAdhaarNumber(String adhaarNumber) {
        this.adhaarNumber = adhaarNumber;
    }

    public String getPoliceVerification() {
        return policeVerification;
    }

    public void setPoliceVerification(String policeVerification) {
        this.policeVerification = policeVerification;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String state;
    String district;
    String policeVerification;
    String adhaarNumber;
    String mobileNumber;
    String highestEducation;
    int workEx;
    int previousSalary;
    String sector;
    String speciality;
    int marks;
    int retention;
    int lastEmployedAt;

    static ArrayList<Employee> chosenEmployee = new ArrayList<>();

    public static double rateEmployee(Employee employee){
        double rating = 0;
        double workexrating = 2.0*(employee.workEx)/4.0;
        double marksRating = 1.0*(employee.marks)/100.0;
        double lastEmployedRating = 2.0*(employee.lastEmployedAt)/6.0;
        double retentionRating = 2.0*(employee.retention)/6.0;
        double policeVerificationRating = 2.0;
        if(employee.policeVerification.equals("No")){
            policeVerificationRating = 0;
        }
        rating = (workexrating+marksRating+lastEmployedRating+retentionRating+policeVerificationRating)/9.0;
        Log.d("Rating", rating+"");
        return rating;
    }

}
