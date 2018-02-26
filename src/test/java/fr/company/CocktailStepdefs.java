package fr.company;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CocktailStepdefs {


    private Order order;

    @Given("^Romeo who wants to buy a drink$")
    public void romeoWhoWantsToBuyADrink() throws Throwable {
        order = new Order();
        order.declareOwner("romeo");
    }

    @When("^an order is declared for Juliette$")
    public void anOrderIsDeclaredForJuliette() throws Throwable {
        order.declareTarget("juliette");
    }

    @Then("^there is no cocktail in the order$")
    public void thereIsNoCocktailInTheOrder() throws Throwable {
        List<String> cocktails = order.getCocktails();
        assertThat(cocktails).isEmpty();
    }
}
