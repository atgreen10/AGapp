package model;

public class Outsource extends Part {

    private String companyName;

    public Outsource(int partID, String partName, double partPrice, int partStock, int partMax, int partMin, String companyName, boolean sourcedInHouse ) {
        super(partID, partName, partPrice, partStock, partMax, partMin, sourcedInHouse);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;
    }
}

