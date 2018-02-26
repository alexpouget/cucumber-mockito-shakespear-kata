package fr.company;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<String> cocktails = new ArrayList<>();
    private String owner;
    private String target;

    public void declareOwner(String romeo) {
        owner = romeo;
    }

    public void declareTarget(String juliette) {

        target = juliette;
    }

    public List<String> getCocktails() {
        return cocktails;
    }
}
