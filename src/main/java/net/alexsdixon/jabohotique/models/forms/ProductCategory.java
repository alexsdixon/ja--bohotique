package net.alexsdixon.jabohotique.models.forms;

public enum ProductCategory {

    WomenClothes ("WomenClothes"),
    WomenAccessories ("WomenAccessories"),
    MenClothes ("MenClothes"),
    MenAccessories ("MenAccessories"),
    GirlClothes ("GirlClothes"),
    BoyClothes ("BoyClothes");

    private final String name;

    ProductCategory(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
