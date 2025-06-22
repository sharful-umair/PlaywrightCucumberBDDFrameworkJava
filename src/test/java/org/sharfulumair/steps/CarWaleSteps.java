package org.sharfulumair.steps;

import org.testng.Assert;

import org.sharfulumair.base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sharfulumair.pages.HomePage;
import org.sharfulumair.pages.NewCarsPage;
import org.sharfulumair.utils.PlaywrightDriver;

public class CarWaleSteps {

	
	HomePage home = new HomePage();
	NewCarsPage car = new NewCarsPage();
	
	@Given("user navigates to carwale website")
	public void user_navigates_to_carwale_website() {

		PlaywrightDriver.openPage(PlaywrightDriver.config.getProperty("testsiteurl"));
		
	}
	@When("user mouseover to newcars")
	public void user_mouseover_to_newcars() {
	  
		home.mouseOverNewCars();
	}
	@Then("user clicks on Findnewcars link")
	public void user_clicks_on_findnewcars_link() {
	   
		home.clickFindNewCars();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user clicks on {string} car")
	public void user_clicks_on_car(String carBrand) {
	  
		if(carBrand.equals("Toyota")) {
			
			car.gotoToyota();
		}else if(carBrand.equals("Kia")) {
			
			car.gotoKia();
		}else if(carBrand.equals("BMW")) {
			
			car.gotoBMW();
		}else if(carBrand.equals("Honda")) {
			
			car.gotoHonda();
		}

	}
	@Then("user validates carTitle as {string}")
	public void user_validates_car_title_as(String carTitle) {
	   
		System.out.println(BasePage.carBase.getCarTitle());
		Assert.assertEquals(BasePage.carBase.getCarTitle(), carTitle);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Then("user find the car names and prices")
	public void user_find_the_car_names_and_prices() {
	
		BasePage.carBase.getCarBrandNameAndPrices();
		
	}
}
