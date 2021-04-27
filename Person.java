abstract class Person {

    private String fullName=null;
    private String nID=null;
    private String dateOfBirth=null;

    public Person(String fullName, String nid, String dateOfBirth) {
        this.fullName=fullName;
        this.nID=nid;
        this.dateOfBirth=dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getnID() {
        return nID;
    }

    public void setnID(String nID) {
        this.nID = nID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", nID='" + nID + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

}