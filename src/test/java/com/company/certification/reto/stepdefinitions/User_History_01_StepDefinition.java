package com.company.certification.reto.stepdefinitions;


import com.company.certification.reto.exceptions.ExpectedResultErr;
import com.company.certification.reto.questions.VerifyExpectedResult;
import com.company.certification.reto.tasks.BuyArticles;
import com.company.certification.reto.util.properties.ConfigureDriverProperties;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
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

import static com.company.certification.reto.exceptions.ExpectedResultErr.EXPECTED_RESULT;
import static com.company.certification.reto.tasks.LoadDataTest.loadData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class User_History_01_StepDefinition {

    @Managed()
    Actor Jesus = Actor.named("Jesus");

    @Before()
    public void configuracionInicial2() {
        Jesus.can(BrowseTheWeb.with(ConfigureDriverProperties.loadDriver()));
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^I visit the page Mercado Libre in app$")
    public void i_visit_the_page_mercado_libre() {
        Jesus.wasAbleTo(Open.url("https://www.linio.com.co/"));
    }

    @When("^I look the articles especific with this information in app$")
    public void i_look_the_articles_especific_with_this_information(List<Map<String, Object>> information) {
        Jesus.attemptsTo(loadData(information));
    }

    @Then("^I buy the article that me like in app$")
    public void i_buy_the_article_that_me_like() {
        Jesus.attemptsTo(BuyArticles.inTheAplication());
    }

    @And("^Verify the user authentication$")
    public void verify_the_user_authentication() {
        Jesus.should(seeThat(VerifyExpectedResult.inAplication())
                .orComplainWith(ExpectedResultErr.class, EXPECTED_RESULT)
        );
    }

}
