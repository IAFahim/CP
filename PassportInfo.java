import java.util.Random;

import static java.lang.Math.*;

public class PassportInfo {

    private String firstName = null;
    private String lastName = null;
    private String NIDNumber = null;
    public String passportNumber = null;
    private DateOfBirth dateOfBirth = null;

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Color[][] getPicture() {
        return picture;
    }

    public void setPicture(Color[][] picture) {
        this.picture = picture;
    }

    private Color picture[][]=null;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNIDNumber() {
        return NIDNumber;
    }

    public void setNIDNumber(String NIDNumber) {
        this.NIDNumber = NIDNumber;
    }


    public String getPassportNumber() {
        return passportNumber;
    }

    private void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }


    private static char cap[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public String toString() {
        return "PassportInfo\n" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", NIDNumber='" + NIDNumber + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '\n';
    }


    public static PassportInfo Builder() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append(cap[random.nextInt(cap.length)]);
        sb.append(cap[random.nextInt(cap.length)]);
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }
        PassportInfo passportInfo = new PassportInfo();
        passportInfo.setPassportNumber(sb.toString());
        return passportInfo;
    }

    private PassportInfo() {
    }

}