package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public WebDriver webDriverManager() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(/*System.getProperty("user.dir")+"/"+*/"src/test/resources/global.properties");
            Properties properties = new Properties();
            properties.load(fis);
            String qaUrl = properties.getProperty("QAUrl");

            String browser_properties = properties.getProperty("browser");
            String browser_maven = System.getProperty("browser");
            String browser = browser_maven!=null ? browser_maven : browser_properties;

            if(driver==null) {

                switch (browser.toLowerCase()) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    default:
                        System.out.println("Invalid browser type");
                }
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.get(qaUrl);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
