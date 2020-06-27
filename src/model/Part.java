package model;

public abstract class Part {
    private int partID;
    private int partStock;
    private int partMax;
    private int partMin;
    private String partName;
    private double partPrice;
    boolean sourcedInHouse;

    public Part(int partID, String partName, double partPrice, int partStock, int partMax, int partMin, boolean sourcedInHouse) {
        this.partID = partID;
        this.partName = partName;
        this.partStock = partStock;
        this.partPrice = partPrice;
        this.partMax = partMax;
        this.partMin = partMin;
        this.sourcedInHouse = sourcedInHouse;
    }

    public int getPartID() {
        return partID;
    }
    public void setPartID(int partID) {
        this.partID = partID;
    }

    public int getPartStock() {
        return partStock;
    }

    public void setPartStock(int partStock) {
        this.partStock = partStock;
    }

    public int getPartMax() {
        return partMax;
    }

    public void setPartMax(int partMax) {
        this.partMax = partMax;
    }

    public int getPartMin() {
        return partMin;
    }

    public void setPartMin(int partMin) {
        this.partMin = partMin;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public double getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }

    public boolean getSourcedInHouse() {
        return sourcedInHouse;
    }

    public void setSourcedInHouse(boolean sourcedInHouse) {
        this.sourcedInHouse = sourcedInHouse;
    }
}
