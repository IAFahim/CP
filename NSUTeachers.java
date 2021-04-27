public class NSUTeachers extends Person implements Teacher {

    String teacherId=null;
    public NSUTeachers(String fullName, String NID, String dateOfBirth) {
        super(fullName, NID, dateOfBirth);
    }
    public String getTeacherId() {
        return teacherId;
    }

    @Override
    public String teacherId() {
        return teacherId;
    }
}