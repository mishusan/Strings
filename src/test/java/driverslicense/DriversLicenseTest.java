package driverslicense;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;


public class DriversLicenseTest {

    DriversLicense testLicense;

    String name = "Mike Jones";
    String address = "123 Atl drive";
    String eyeColor = "Brown";
    Date dateOfBirth = new Date(); // 3 times
    Date issueDate = dateOfBirth;
    Date expirationDate = dateOfBirth;
    String licenseNum = "007";
    String issuingState = "TX";
    String endorsements = "Trump";
    char sex = 'M';
    int height = 72;
    double weight = 100;
    boolean organDonor = true;
    boolean federallyCompliant = true;
    char licenseClassification = 'C';


    @Before
    public void setUp() throws Exception {
        testLicense = new DriversLicense();
        testLicense.setName(name);
        testLicense.setAddress(address);
        testLicense.setEyeColor(eyeColor);
        testLicense.setDateOfBirth(dateOfBirth);
        testLicense.setIssueDate(issueDate);
        testLicense.setExpirationDate(expirationDate);
        testLicense.setLicenseNumber(licenseNum);
        testLicense.setIssuingState(issuingState);
        testLicense.setEndorsements(endorsements);
        testLicense.setSex(sex);
        testLicense.setHeight(height);
        testLicense.setWeight(weight);
        testLicense.setOrganDonor(organDonor);
        testLicense.setFederallyCompliant(federallyCompliant);
        testLicense.setLicenseClassification(licenseClassification);
    }

    @Test
    public void testSerializeToCSV() throws Exception {

        String actualCSVResult = testLicense.serializeToCSV();

        String expectedCSVResult = String.format("%s,%s,%s,%tc,%tc,%tc,%s,%s,%s,%c,%d,%.1f,%b,%b,%c",
                name, address, eyeColor, dateOfBirth, issueDate, expirationDate, licenseNum, issuingState, endorsements, sex,
                height, weight, organDonor, federallyCompliant, licenseClassification);

        assertEquals("Actual CSV result did not match expectations.",expectedCSVResult, actualCSVResult);



    }

    @Test
    public void testGetCSVHeader(){
        /*
        order: name, address, eyeColor, expectedDOB,expectedIssueDate, expectedExpirationDate,
                licenseNum, issuingState, trump, male, federallyCompliantStatus, licenseClassification
         */
        String expectedHeader = "NAME,ADDRESS,EYE COLOR,DATE OF BIRTH,ISSUE DATE,EXPIRATION DATE," +
                "LICENSE NUMBER,STATE,ENDORSEMENTS,SEX,FEDERAL COMPLIANCE,CLASSIFICATION";

        String actualHeader = DriversLicense.getCSVHeader();

        assertEquals(expectedHeader, actualHeader);
    }
    @Test
    public void deserializeCsvTest(){
        String expectedValue = "DriversLicense{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", licenseNumber='" + licenseNum + '\'' +
                ", endorsements='" + endorsements + '\'' +
                ", issuingState='" + issuingState + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", licenseClassification=" + licenseClassification +
                ", sex=" + sex +
                ", organDonor=" + organDonor +
                ", federallyCompliant=" + federallyCompliant +
                ", dateOfBirth=" + dateOfBirth +
                ", issueDate=" + issueDate +
                ", expirationDate=" + expirationDate +
                '}';
    }

}