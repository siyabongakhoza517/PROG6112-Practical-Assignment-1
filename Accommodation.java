public class Accommodation {
    private String blockName;
    private int roomNumber;
    private double price;

    public Accommodation(String blockName, int roomNumber, double price) {
        this.blockName = blockName;
        this.roomNumber = roomNumber;
        this.price = price;
    }
    public String getBlockName() { return blockName; }
    public int getRoomNumber() { return roomNumber; }
    public double getPrice() { return price; }
    public String getReport() {
        return "Block: " + blockName + " | Room: " + roomNumber + " | Price: R" + price;
    }
}
