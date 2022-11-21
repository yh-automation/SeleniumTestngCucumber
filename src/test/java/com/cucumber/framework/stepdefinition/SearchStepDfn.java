/**
 * @author rahul.rathore
 *	
 *	16-Aug-2016
 */
package com.cucumber.framework.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import com.cucumber.framework.helper.PageObject.homepage.HomePage;
import com.cucumber.framework.settings.ObjectRepo;

/**
 * @author rahul.rathore
 *
 *         16-Aug-2016
 *
 */
public class SearchStepDfn {
	
	private HomePage hPage;

	@Given("I am at the home page")
	public void i_am_at_the_home_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("HA-HA");
//		ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
//		hPage = new HomePage(ObjectRepo.driver);
//		ObjectRepo.data.put("HomePage", hPage);
	}

	@Given("^: I am at the home page$")
	public void _i_am_at_the_home_page() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
		hPage = new HomePage(ObjectRepo.driver);
		ObjectRepo.data.put("HomePage", hPage);
	}

	@When("^: I click on the \"([^\"]*)\" search filter$")
	public void _i_click_on_the_something_search_filter(String search)
			throws Throwable {
		hPage.navigateTo(search);
	}
	
	@Then("^: I should be at the \"([^\"]*)\" search page with \"([^\"]*)\"$")
	public void _i_should_be_at_the_something_search_page_with_something(
			String title, String items) throws Throwable {
		Assert.assertEquals(hPage.getItems(),items);
	}
	
	@And("^: The title should be \"([^\"]*)\" search page$")
    public void _the_title_should_be_something_search_page(String title)
			throws Throwable {
		Assert.assertTrue(hPage.checkForTitle(title));
	}

}
