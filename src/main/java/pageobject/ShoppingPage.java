package pageobject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShoppingPage {
	
	public WebDriver driver;

	@FindBy(xpath ="(//*[@title='GİYİM & AKSESUAR'])[1]")
   WebElement giyimAksesuarKategori;


   @FindBy(xpath="//*[text()='Dizaltı Çorap']")
	WebElement dizaltıCorap;

	@FindBy(xpath= "//h3[@class='name']")
	List<WebElement> siyahUrun;


	@FindBy(xpath= "//div[@class='selected-variant-text']/span")
	WebElement siyahUrunDogrula;

	@FindBy(xpath= "/html/body/section/section[2]/div[2]/div[1]/div/div[3]/div[2]/div[1]/button")
	WebElement sepeteEkle;

	@FindBy(linkText= "Sepeti Görüntüle")
			WebElement sepetiGoruntule;

	@FindBy(className= "js-checkout-button")
			WebElement sepetiOnayla;

	@FindBy(className= "js-proceed-to-checkout-btn")
			WebElement uyeOlmadanIlerle;



	@FindBy(xpath= "//input[@type='text' and @name='user_email']")
	WebElement email;

	@FindBy(xpath= "/html/body/section/div[1]/div/div[2]/div/div/form/button")
	WebElement emailDevamEt;



	@FindBy(className= "js-new-address")
	WebElement adresOlustur;



	@FindBy(xpath= "//input[@name='title']")
	WebElement adresBaslik;


	@FindBy(xpath= "//input[@name='first_name']")
	WebElement ad;

	@FindBy(xpath= "//input[@name='last_name']")
	WebElement soyad;

	@FindBy(xpath= "//input[@name='phone_number']")
	WebElement telefon;

	@FindBy(xpath= "//select[@name='city']")
	WebElement sehir;


	@FindBy(xpath= "//select[@name='township']")
	WebElement ilce;

	@FindBy(className= "js-district")
	WebElement mahalle;

	@FindBy(xpath= "//textarea[@name='line']")
	WebElement adresTarif;

	@FindBy(xpath= "//button[normalize-space()='KAYDET']")
	WebElement kaydetButon;


	@FindBy(className= "js-proceed-button")
	WebElement kaydetDevametButon;

	@FindBy(xpath= "//div[@data-type='masterpass' and @data-pk='37']")
	WebElement odemeKontrol;

	
	
	
	
	public ShoppingPage (WebDriver driver) {
		this.driver=driver;

		PageFactory.initElements(driver, this);
	}
	
	
	public void GiyimAksesuarUrunBul() throws InterruptedException {
		
		Actions a = new Actions(driver);
		a.moveToElement(giyimAksesuarKategori).build().perform();
		Thread.sleep(1000);
		dizaltıCorap.click();
	}
	

	
public void SiyahUrun() {
	
	
	List<WebElement>  urunler = siyahUrun;
	for (int i=0; i<urunler.size();i++) {
		if(urunler.get(i).getText().contains("Siyah")) {
			urunler.get(i).click();
			break;
	}}
	
	Assert.assertEquals(siyahUrunDogrula.getText(), "SİYAH");

}


public void sepetekleIlerle(String Email) {

	sepeteEkle.click();
	sepetiGoruntule.click();
	sepetiOnayla.click();
	uyeOlmadanIlerle.click();

	email.sendKeys(Email);
	emailDevamEt.click();
}





public void AdresOlustur() throws InterruptedException {

	adresOlustur.click();
	adresBaslik.sendKeys("Ev");
	ad.sendKeys("Cıhan");
	soyad.sendKeys("Mut");
	telefon.sendKeys("5367234343");
	WebElement city = sehir;
	WebElement town = ilce;
	WebElement district = mahalle;
	Select citydropdown = new Select(city);
	citydropdown.selectByVisibleText("İSTANBUL");
	Select towndropdown = new Select(town);
	towndropdown.selectByVisibleText("AVCILAR");
	Thread.sleep(1000);
	Select districtdropdown = new Select(district);
	districtdropdown.selectByVisibleText("AMBARLI MAH"); 

	Random rand = new Random();
	adresTarif.sendKeys("Demir sokak no:" + rand.nextInt(1000));
	Thread.sleep(1000);

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,250)", "");
	kaydetButon.click();
	Thread.sleep(2000);
}

public void KaydetveDevamEt() {
	
	WebDriverWait wait = new WebDriverWait(driver,30);
	//kaydetDevametButon
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.
			className("js-proceed-button"))).click();
}


public void OdemeEkranKontrol() {
	
	Assert.assertEquals("Kart ile ödeme", odemeKontrol.getText());

}




}
