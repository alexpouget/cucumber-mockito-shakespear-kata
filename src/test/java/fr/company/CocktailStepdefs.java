package fr.company;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CocktailStepdefs {


    private Order order;

    @Given("^(.*) who wants to buy a drink$")
    public void romeoWhoWantsToBuyADrink(String owner) throws Throwable {
        order = new Order();
        order.declareOwner(owner);
    }

    @When("^an order is declared for (.*)$")
    public void anOrderIsDeclaredForJuliette(String target) throws Throwable {
        order.declareTarget(target);
    }

    @Then("^there is (\\d) cocktail in the order$")
    public void thereIsNoCocktailInTheOrder(int cocktailsNumber) throws Throwable {
        List<String> cocktails = order.getCocktails();
        assertThat(cocktails.size()).isEqualTo(cocktailsNumber);
    }

    @And("^a message saying \"([^\"]*)\" is added$")
    public void aMessageSayingIsAdded(String message) throws Throwable {
        order.withMessage(message);
    }

    @Then("^the ticket must say \"([^\"]*)\"$")
    public void theTicketMustSay(String arg0) throws Throwable {
        String expected = String.format("From %s to %s: %s",
                order.getOwner(), order.getTarget(), order.getMessage());
        Assertions.assertThat(arg0).isEqualTo(expected);
    }
}
