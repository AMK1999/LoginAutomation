import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import dev.failsafe.internal.util.Assert;

import java.util.Arrays;
import java.util.List;

public class LoginAutomation {
    static String baseUrl = "https://rahulshettyacademy.com/locatorspractice/";
    static WebDriver web = new ChromeDriver();

    public static void main(String[] args) {
        String name = "rahul";
        String TempPassword = "rahulshettyacademy";
        String Email = "leenaAndorson@org.com";
        String number = "78745272";
        web.get(baseUrl);
        web.findElement(By.id("inputUsername")).sendKeys("JohnPaul");
        web.findElement(By.name("inputPassword")).sendKeys("password");
        web.findElement(By.id("chkboxOne")).click();
        web.findElement(By.className("submit")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(web.findElement(By.className("error")).getText());
        web.findElement(By.linkText("Forgot your password?")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        web.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
        web.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Email);
        web.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys(number);
        web.findElement(By.className("reset-pwd-btn")).click();
        // Assert.assertEquals(web.findElement(By.className("infoMsg")).getText(),"Please
        // use temporary password 'rahulshettyacademy' to Login.");
        System.out.println(web.findElement(By.className("infoMsg")).getText());
        String passWord = getPassword();
        web.findElement(By.className("go-to-login-btn")).click();
        web.findElement(By.id("inputUsername")).sendKeys("JohnPaul");
        web.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        System.out.println(web.findElement(By.className("error")).getText());
        // Assert.assertEquals(web.findElement(By.className("error")).getText(),"*
        // Incorrect username or password");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        web.findElement(By.id("inputUsername")).clear();
        web.findElement(By.id("inputUsername")).sendKeys(name);
        web.findElement(By.name("inputPassword")).clear();
        web.findElement(By.name("inputPassword")).sendKeys(passWord);
        web.findElement(By.className("submit")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(web.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
        // Assert.assertEquals(web.findElement(By.cssSelector("div[class='login-container']
        // h2")).getText(),"Hello rahul,");
        // web.close();
        AutomationPractice();
    }

    // getting password for login
    public static String getPassword() {
        // web.get(baseUrl);
        String passWord = (web.findElement(By.className("infoMsg")).getText());
        String[] arr = passWord.split("'");
        String firstArr = passWord.split("'")[1];
        String arr2 = firstArr.split("'")[0];
        System.out.println(Arrays.toString(arr));
        System.out.println(firstArr);
        System.out.println(arr2);
        return arr2;
    }

    // Dropdown practice
    public static void AutomationPractice() {
        web.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement StaticDropdown = web.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropdown = new Select(StaticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        dropdown.selectByValue("INR");
        web.findElement(By.id("divpaxinfo")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < 4; i++) {
            web.findElement(By.id("hrefIncAdt")).click();
        }
        for (int i = 0; i < 2; i++) {
            web.findElement(By.id("hrefIncChd")).click();
        }
        web.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(web.findElement(By.id("divpaxinfo")).getText());

        web.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        web.findElement(By.xpath("//a[@ value= 'PNQ']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        web.findElement(By.xpath("(//a[@ value='BOM'])[2]")).click();
        web.findElement(By.linkText("19")).click();
        web.findElement(By.id("autosuggest")).sendKeys("ind");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        List<WebElement> options = web.findElements(By.xpath("//li[@class = 'ui-menu-item'] //a"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
        // web.findElement(By.linkText("India")).click();

        System.out.println(web.findElement(By.xpath("//input[@ placeholder='Type to Select']")).getText());

    }
}
