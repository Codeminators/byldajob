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

    public String getCertificateAvailable() {
        return certificateAvailable;
    }

    public void setCertificateAvailable(String certificateAvailable) {
        this.certificateAvailable = certificateAvailable;
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

    public Double getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Double mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Double getAdhaarNumber() {
        return adhaarNumber;
    }

    public void setAdhaarNumber(Double adhaarNumber) {
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
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
