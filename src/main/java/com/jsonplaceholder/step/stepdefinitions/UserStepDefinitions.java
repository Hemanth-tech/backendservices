package com.jsonplaceholder.step.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStepDefinitions {
	
	@Given("the user API is available")
	public void the_json_place_holder_api_is_available() {
	    
	}
	
	@Given("A new user with name {string} and email {string} is added")
	public void a_new_user_with_name_and_email_is_added(String string, String string2) {
	    
	}
	
	@Given("there is user with name {string} and email {string}")
	public void there_is_user_with_name_and_email(String string, String string2) {
	    
	}
	
	@When("user name  is updated to {string} and email is updated to {string} should be present in response")
	public void user_name_is_updated_to_and_email_is_updated_to_should_be_present_in_response(String string, String string2) {
	 
	}
	
	@Then("user name {string} and email {string} should {string} in response")
	public void user_name_and_email_should_in_response(String string, String string2, String string3) {
	   
	}

	@When("{string} created by user retrived")
	public void created_by_user_retrived(String string) {
	   
	}
	
	@Then("Created {string} should be present in the response")
	public void created_should_be_present_in_the_response(String string) {
	    
	}
	
	@When("user details are retrievd")
	public void user_details_are_retrievd() {
	    
	}

	@When("complete list of user details are retrievd")
	public void complete_list_of_user_details_are_retrievd() {
	
	}
	
	@When("user details are deleted")
	public void user_details_are_deleted() {
	
	}
}
