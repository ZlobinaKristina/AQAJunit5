package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Driver {

    public static WebDriver driver;

    private static void initializeChromeChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\senlacourse\\Test\\src\\main\\resources\\chromedriver.exe");
    }

    public static WebDriver getChromeDriver() {
        initializeChromeChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

}
