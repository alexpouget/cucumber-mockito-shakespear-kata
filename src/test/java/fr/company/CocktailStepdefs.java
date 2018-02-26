package fr.company;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CocktailStepdefs {


    private Order order;
    private Menu menu;

    @Given("^(.*) who wants to buy a drink$")
    public void romeoWhoWantsToBuyADrink(String owner) throws Throwable {
        order = new Order();
        order.declareOwner(owner);
    }

    @When("^an order is declared for (.*)$")
    public void anOrderIsDeclaredForJuliette(String target) throws Throwable {
        order.declareTarget(target);
    }

    @Then("^there is (\\d) cocktails in the order$")
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

    @When("^a mocked menu is used$")
    public void aMockedMenuIsUsed() throws Throwable {
        menu = mock(Menu.class);
        order.addMenu(menu);
    }

    @And("^the mock binds #(\\d+) to (.*)")
    public void theMockBindsToMojito(int id, String cocktailsName) throws Throwable {
        when(menu.getPrettyName(id)).thenReturn(cocktailsName);
    }

    @And("^a cocktail #(\\d+) is added to the order$")
    public void aCocktailIsAddedToTheOrder(int id) throws Throwable {
        order.addCocktails(id);
    }

    @And("^the order contains a (.*)")
    public void theOrderContainsACocktail(String expectedCocktailName) throws Throwable {
        assertThat(order.getCocktails()).contains(expectedCocktailName);
    }
}
