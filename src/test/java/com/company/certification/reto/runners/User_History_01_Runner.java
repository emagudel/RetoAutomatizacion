package com.company.certification.reto.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/user_history_01.feature",
        glue = { "com.company.certification.reto.stepdefinitions" },
        snippets = SnippetType.CAMELCASE)

public class User_History_01_Runner {}
