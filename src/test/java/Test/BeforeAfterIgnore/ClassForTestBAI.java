package Test.BeforeAfterIgnore;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
import utils.Log;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ClassForTestBAI {
    private WebDriver driver = Driver.getChromeDriver();

    @BeforeAll //fixture
    public void OpenPage() {
        Log.info("Open Page");
        driver.get("http://a.testaddressbook.com/");
    }

    @Test
    @Order(1)
    @DisplayName("Sign In")
    public void SignIn() {
        Log.info("Sign In");
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.findElement(By.id("session_email")).sendKeys("zlobina_test@mail.ru");
        driver.findElement(By.id("session_password")).sendKeys("7777777password");
        driver.findElement(By.xpath("//input [@value = 'Sign in']")).click();

        WebElement PageTitle1 = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome to Address Book')]"));
        String Page = PageTitle1.getText();
        Assertions.assertEquals("Welcome to Address Book", Page);
    }

    @Test
    @Order(2)
    @DisplayName("Add Address")
    public void AddAddress() {
        Log.info("Add Address");
        driver.findElement(By.xpath("//a[contains(@href,'/addresses') ]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'/addresses/new') ]")).click();
        driver.findElement(By.name("address[first_name]")).sendKeys("Kris");
        driver.findElement(By.name("address[last_name]")).sendKeys("Zlobina");
        driver.findElement(By.name("address[address1]")).sendKeys("Texas, The USA");
        driver.findElement(By.name("address[address2]")).sendKeys("Texas, The USA");
        driver.findElement(By.name("address[city]")).sendKeys("Корпус-Кристи");

        Select state = new Select(driver.findElement(By.name("address[state]")));
        state.selectByVisibleText("Texas");

        driver.findElement(By.name("address[zip_code]")).sendKeys("78336");
        driver.findElement(By.xpath("//input [@value = 'us']")).click();
        driver.findElement(By.id("address_birthday")).sendKeys("16/03/1994");
        driver.findElement(By.xpath("//input [@value = '#000000']")).sendKeys("#C71585");
        driver.findElement(By.name("address[age]")).sendKeys("27");
        driver.findElement(By.name("address[website]")).sendKeys("https://www.youtube.com/");
        driver.findElement(By.name("address[phone]")).sendKeys("29-345-76-45");
        driver.findElement(By.xpath("//input [@id = 'address_interest_dance']")).click();
        driver.findElement(By.name("address[note]")).sendKeys("Some notes about me");
        driver.findElement(By.xpath("//input [@value = 'Create Address']")).click();
        driver.findElement(By.xpath("//a[contains(@href,'/addresses') ]")).click();

        WebElement FirstName = driver.findElement(By.xpath("//td[contains(text(), 'Kris')]"));
        String Name = FirstName.getText();
        Assertions.assertEquals("Kris", Name, "Wrong name");

    }

    @Disabled
    @Test
    @Order(3)
    @DisplayName("Edit Address")
    public void EditAddress() {
        Log.info("Edit Address");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//tr//td//a[contains(@data-test,'edit')]")).click();
        driver.findElement(By.name("address[first_name]")).clear();
        driver.findElement(By.name("address[last_name]")).clear();
        driver.findElement(By.name("address[first_name]")).sendKeys("Bob");
        driver.findElement(By.name("address[last_name]")).sendKeys("Grams");
        driver.findElement(By.xpath("//input [@type = 'submit']")).click();

        WebElement LastName = driver.findElement(By.xpath("//span[contains(@data-test,'last_name')]"));
        String LName = LastName.getText();
        Assertions.assertEquals("Grams", LName, "Wrong last name");

        driver.findElement(By.xpath("//a[contains(@href,'/addresses') ]")).click();
    }

    @Test
    @Order(4)
    @DisplayName("Destroy Address")
    public void DestroyAddress() {
        Log.info("Destroy Address");
        driver.findElement(By.xpath("//a [@data-confirm = 'Are you sure?']")).click();
        driver.switchTo().alert().accept();

        WebElement NoAddress = driver.findElement(By.xpath("//table//tbody "));
        String q = NoAddress.getText();
        Assertions.assertEquals("", q);
    }

    @AfterAll //fixture
    public void SignOut() {
        Log.info("Sign Out");
        driver.findElement(By.xpath("//a[contains(@href,'/sign_out') ]")).click();
        driver.quit();
    }

}







