package com.jsonplaceholder.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/jsonplaceholder/features", glue = { "com/jsonplaceholder/step/stepdefinitions", "com/jsonplaceholder/hooks" }, plugin = { "pretty",
		"html:target/cucumber-reports.html" })
public class TestRunner {
}
