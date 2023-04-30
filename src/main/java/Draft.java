import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Draft {
    public static WebDriver driver;
    public static String shortname = "Tom";

    public static String landingPageProductName;
    public static String offerPageProductName;



    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("driver", "D:\\Programs\\chromedriver_win32\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        System.out.println("User is on GreenKart Landing page: " + driver.getCurrentUrl());

        driver
                .findElement(By.className("search-keyword"))
                .sendKeys(shortname, Keys.RETURN);


        Thread.sleep(2000);

        landingPageProductName = driver
                .findElement(By.cssSelector("h4.product-name"))
                .getText()
                .split("-")[0]
                .trim();

        System.out.println(landingPageProductName + " is extracted from Home page");

        Thread.sleep(2000);
        driver.quit();

        System.out.println("Successful flow!");
    }

}
