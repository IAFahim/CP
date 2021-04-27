public class NSUStaff extends Person implements Teacher,Student {

    public NSUStaff(String fullName, String NID, String dateOfBirth) {
        super(fullName, NID, dateOfBirth);
    }

    @Override
    public String teacherId() {
        return null;
    }

    @Override
    public String studentId() {
        return null;
    }
}