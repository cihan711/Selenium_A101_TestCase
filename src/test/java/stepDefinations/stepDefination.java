package stepDefinations;

import resources.base;

import java.io.IOException;

import org.junit.runner.RunWith;

import com.mongodb.internal.connection.tlschannel.NeedsWriteException;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageobject.ShoppingPage;

@RunWith(Cucumber.class)
public class stepDefination extends base {


		
	    @Given("Initialize the browser with chrome")
	    public void initialize_the_browser_with_chrome() throws IOException {
	    	driver =initializeDriver();
	    }
	    @When("user enter homepage without regsiter and user click woman black sock")
	    public void user_enter_homepage_without_regsiter_and_user_click_woman_black_sock() throws InterruptedException {
	    	ShoppingPage shp = new ShoppingPage(driver);
	    	shp.GiyimAksesuarUrunBul();
	    }
	    
	    @Then("Verify black sock")
	    public void verify_black_sock() {
	    	ShoppingPage shp = new ShoppingPage(driver);
	    	shp.SiyahUrun();
	    }
	    
	    ////Basket page
	    @Given("Contiune from product page")
	    public void contiune_from_product_page()  {
	    
	    	System.out.println("Now we are product page");
	    }
	    
	    @When("^user add basket this product and user look basket page and aprove basket and user contiunue and enter (.+) adress$")
	    public void user_add_basket_this_product(String email) {
	        
	    	ShoppingPage shp = new ShoppingPage(driver);
	    	shp.sepetekleIlerle(email);
	    }
	  
	    
	    @Then("user direct address area")
	    public void user_direct_address_area() {
	      	System.out.println("Now we are adreess area");
	    }
	    
	    
	    //Address page
	    @Given("Contiunue from basket page")
	    public void contiunue_from_basket_page() {
	    	System.out.println("add adress");
	    }
	    @When("user write address information")
	    public void user_write_address_information() throws InterruptedException {
	    	ShoppingPage shp = new ShoppingPage(driver);
	       shp.AdresOlustur();
	       
	       
	    }
	    
	    
	    @Then("user direct payment area")
	    public void user_direct_payment_area() {
	    	ShoppingPage shp = new ShoppingPage(driver);
		       shp.KaydetveDevamEt();
	    }
	    
	    
	   //payment page and final case
	    
	    @When("user check payment page title")
	    public void user_check_payment_page_title() throws InterruptedException {
	    	ShoppingPage shp = new ShoppingPage(driver);
	    	shp.OdemeEkranKontrol();
	    	Thread.sleep(1000);
	    }
	    
	    @Then("user complete shopping")
	    public void user_complete_shopping() {
	        base bs = new base();
	        bs.teardown();
	    }
	    
	    }

	
	
	
	

