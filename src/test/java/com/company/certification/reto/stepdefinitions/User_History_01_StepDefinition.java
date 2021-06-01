package com.company.certification.reto.stepdefinitions;


import com.company.certification.reto.tasks.BuyShoes;
import com.company.certification.reto.util.properties.ConfigureDriverProperties;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;

import java.util.List;
import java.util.Map;

import static com.company.certification.reto.tasks.LoadData.loadDataTestWithTheFollowing;


public class User_History_01_StepDefinition {

    @Managed()
    Actor Jesus = Actor.named("Jesus");

    @Before()
    public void configuracionInicial2() {
        Jesus.can(BrowseTheWeb.with(ConfigureDriverProperties.loadDriver()));
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^I visit the page nike in app$")
    public void i_visit_the_page_nike() {
        Jesus.attemptsTo(Open.url("https://www.nike.com/launch?s=upcoming"));
    }

    @When("^I look for shoes with this information in app$")
    public void i_look_for_shoes_with_this_information(List<Map<String, Object>> information) {
        Jesus.attemptsTo(loadDataTestWithTheFollowing(information));
    }

    @Then("^I buy the shoes that me like in app$")
    public void i_buy_the_shoes_that_me_like() {
        Jesus.attemptsTo(BuyShoes.inTheAplication());
    }

}
