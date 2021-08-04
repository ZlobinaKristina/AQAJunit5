package Test.Suites;

import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;

public class ClassForTestS {

    private WebDriver driver = Driver.getChromeDriver();
    String m1;

    public ClassForTestS(String m1) {
        this.m1 = m1;    }

    public String OpenPageURL() {
        Log.info("URL are equal");
        driver.get("http://a.testaddressbook.com/");
        String  m1 = driver.getCurrentUrl();
        return m1;
     }

   public String OpenPageTitle() {
       Log.info("Title are equal");
       driver.get("http://a.testaddressbook.com/");
       String  m1 = driver.getTitle();
       return m1;
   }
}
