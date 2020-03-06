import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;

    public class KwidoPageTest {

        @Test
        public void titleTest(){
            // Go to the homepage https://tstkwidos.tk/
            // Verify title is equal to kwidos
            // turn the log off
            System.setProperty("webdriver.chrome.silentOutput","true");
            WebDriver driver = new ChromeDriver();
            driver.get("https://testkwidos.tk");
            driver.manage().window().maximize();
            String title = driver.getTitle();
            Assert.assertEquals(title, "Kwidos");
            driver.quit();
        }

        @Test
        public void Homework1() throws InterruptedException {
            // Go to the homepage https://tstkwidos.tk/
            // Verify title is equal to kwidos
            // turn the log off
            System.setProperty("webdriver.chrome.silentOutput","true");
            WebDriver driver = new ChromeDriver();
            driver.get("https://testkwidos.tk/auth/register/contractor");
            driver.manage().window().maximize();
            // add the waiting time
            Thread.sleep(4000);
            //find the first name filed
            WebElement firstName = ((ChromeDriver) driver).findElementByCssSelector("input[formcontrolname='firstName']");
            // fill the first name filed
            firstName.sendKeys("Tester");
            //find the last name filed
            WebElement lastName = ((ChromeDriver) driver).findElementByCssSelector("input[formcontrolname='lastName']");
            // fill the last name filed
//        Random rand = new Random();
//        int lastNameNumber = rand.nextInt(100);
            lastName.sendKeys("Junior");
            // find the business name filed
            WebElement businessName = ((ChromeDriver) driver).findElementByCssSelector("input[formcontrolname='businessName']");
            // fill the business name filed
            businessName.sendKeys("Testpro");
            // find the phone number filed
            WebElement phoneNumber = ((ChromeDriver) driver).findElementByCssSelector("input[formcontrolname='phone']");
            // fill the phone name filed
            phoneNumber.sendKeys("858-402-5910");
            // find the email filed
            WebElement email = ((ChromeDriver) driver).findElementByCssSelector("input[formcontrolname='email']");
            // fill the email filed
            //generate the timestamp
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat timeOnly = new SimpleDateFormat("HH-mm-ss");
            email.sendKeys(timeOnly.format(cal.getTime()) + "@gmail.com");
            // find the password filed
            WebElement password = ((ChromeDriver) driver).findElementByCssSelector("input[formcontrolname='password']");
            // turn off the password display and fill the password filed
            password.sendKeys("passowrd123");
            // find the click accept the terms
            WebElement clickTerms = ((ChromeDriver) driver).findElementByCssSelector(".col-lg-12 .ng-untouched");
            // click the terms filed
            clickTerms.click();
            // find submit button
            WebElement submitBtn = ((ChromeDriver) driver).findElementByCssSelector("button[type='submit']");
            // click the submit button
            submitBtn.click();
            //Thread.sleep(4000);
            WebDriverWait wait = new WebDriverWait(driver,15);
            //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
            //assert the sign up successfully
            WebElement result = ((ChromeDriver) driver).findElementByCssSelector(".btn");
            System.out.println(result.getText());
            String expectResult = "SIGN IN";
            Assert.assertEquals(result.getText(), expectResult);
            driver.quit();
        }

    }

