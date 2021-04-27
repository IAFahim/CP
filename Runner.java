public class Runner {

    public static void main(String[] args) {
        NSUer nsUer=new NSUer("Md. Student","BD215","6/9/1969");
        nsUer.setStudentID("201420");
        NSUTeachers nsuTeachers=new NSUTeachers("Md. Teacher","BD215ProMax","6/9/1900");
        nsUer.setnID("T20");
        NSUStaff nsuStaff=new NSUStaff("Md. Stuff","BD215Lite","6/9/1908");
        nsUer.setnID("T50");
        System.out.println(nsUer.toString());

    }
}