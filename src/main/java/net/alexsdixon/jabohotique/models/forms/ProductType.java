package net.alexsdixon.jabohotique.models.forms;

public enum ProductType {

    SHIRT ("Shirt"),
    PANTS ("Pants"),
    SHOES("Shoes"),
    SKINCARE("SkinCare"),
    JEWELLERY ("Jewellery");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}

