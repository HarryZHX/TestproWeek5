import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

    public class KwidoPageTest {

        WebDriver  driver = new ChromeDriver();;

        @BeforeMethod
        public  void setup() throws InterruptedException {
            System.setProperty("webdriver.chrome.silentOutput","true");

            driver.get("https://testkwidos.tk/auth/register/contractor");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Test //with the all information task 1
        public void Task1() throws InterruptedException {
            // add the waiting time
//            System.setProperty("webdriver.chrome.silentOutput","true");
//            WebDriver driver = new ChromeDriver();
//            driver.get("https://testkwidos.tk/auth/register/contractor");
//            driver.manage().window().maximize();
//            Thread.sleep(4000);
            //set up all the elements
            WebElement firstName = driver.findElement(By.cssSelector("input[formcontrolname='firstName']"));
            // fill the first name filed
            firstName.sendKeys("Tester");
            //find the last name filed
            WebElement lastName = driver.findElement(By.cssSelector("input[formcontrolname='lastName']"));
            // fill the last name filed
            lastName.sendKeys("Junior");
            // find the business name filed
            WebElement businessName = driver.findElement(By.cssSelector("input[formcontrolname='businessName']"));
            // fill the business name filed
            businessName.sendKeys("Testpro");
            // find the phone number filed
            WebElement phoneNumber = driver.findElement(By.cssSelector("input[formcontrolname='phone']"));
            // fill the phone name filed
            phoneNumber.sendKeys("858-402-5910");
            // find the email filed
            WebElement email = driver.findElement(By.cssSelector("input[formcontrolname='email']"));
            // fill the email filed //generate the timestamp
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat timeOnly = new SimpleDateFormat("HH-mm-ss");
            email.sendKeys(timeOnly.format(cal.getTime()) + "@gmail.com");
            // find the password filed
            WebElement password = driver.findElement(By.cssSelector("input[formcontrolname='password']"));
            password.sendKeys("passowrd123");
            // find the click accept the terms
            WebElement clickTerms = driver.findElement(By.cssSelector(".col-lg-12 .ng-untouched"));
            // click the terms filed
            clickTerms.click();
            // find submit button
            WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
            // click the submit button
            submitBtn.click();
            WebDriverWait wait = new WebDriverWait(driver,15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-content .card-title")));
            WebElement result = driver.findElement(By.cssSelector(".card-content .card-title"));
            //assert the sign up successfully
            String expectResult = "Please enter your email address and password";
            Assert.assertEquals(result.getText(), expectResult);
        }
        @AfterMethod
        public void teardown(){
            driver.quit();
        }

    }

