public class StudentAccommodation extends Accommodation {
    private String studentName;
    private String studentId;

    public StudentAccommodation(String blockName, int roomNumber, double price, String studentName, String studentId) {
        super(blockName, roomNumber, price);
        this.studentName = studentName;
        this.studentId = studentId;
    }
    @Override
    public String getReport() {
        return super.getReport() + " | Student: " + studentName + " (" + studentId + ")";
    }
}