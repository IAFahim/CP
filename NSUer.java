public class NSUer extends Person implements Student {

    private String studentID=null;
    public NSUer(String fullName, String NID, String dateOfBirth) {
        super(fullName, NID, dateOfBirth);
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public String studentId() {
        return this.studentID;
    }
}