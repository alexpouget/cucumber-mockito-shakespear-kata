package fr.company;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<String> cocktails = new ArrayList<>();
    private String owner;
    private String target;
    private String message;
    private Menu menu;

    public void declareOwner(String romeo) {
        owner = romeo;
    }

    public void declareTarget(String juliette) {

        target = juliette;
    }

    public List<String> getCocktails() {
        return cocktails;
    }

    public String getOwner() {
        return owner;
    }

    public String getTarget() {
        return target;
    }

    public String getMessage() {
        return message;
    }

    public void withMessage(String message) {
        this.message =  message;
    }

    public void addMenu(Menu menu) {
        this.menu = menu;
    }

    public void addCocktails(int id) {
        cocktails.add(menu.getPrettyName(id));
    }
}
