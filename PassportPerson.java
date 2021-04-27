import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PassportPerson implements Comparable<PassportPerson> {
    private final String passportNumber;
    private final String firstName;
    private final String lastName;
    private final String nID;
    private final String dateOfBirth;
    private Long dateOfBirthLong = 0L;

    public String getPassportNumber() {
        return passportNumber;
    }

    public Long getDateOfBirth() {
        return dateOfBirthLong;
    }

    public String getnID() { return nID; }

    PassportPerson(String passportNumber, String firstName, String lastName, String nID, String dateOfBirth) throws ParseException {
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nID = nID;
        this.dateOfBirth = dateOfBirth;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = simpleDateFormat.parse(dateOfBirth);
        this.dateOfBirthLong = date.getTime();
    }

    @Override
    public String toString() {
        return passportNumber + ' ' + firstName + ' ' + lastName + ' ' + nID + ' ' + dateOfBirth;
    }

    @Override
    public int compareTo(PassportPerson o) {
        return nID.compareTo(o.nID);
    }
}