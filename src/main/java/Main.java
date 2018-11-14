import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {

    private static void initBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    public static void main(String[] args) {

        initBrowser();

        ArrayList<String> chromeConfigs = new ArrayList<String>();
        chromeConfigs.add("--use-fake-ui-for-media-stream");
        chromeConfigs.add("--use-fake-device-for-media-stream");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(chromeConfigs);
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://webrtc.github.io/samples/src/content/getusermedia/gum/");

        WebElement showVideoButton = driver.findElement(By.id("showVideo"));
        WebElement video = driver.findElement(By.id("gum-local"));

        Assert.assertEquals(video.getAttribute("videoHeight"), "0");
        Assert.assertEquals(video.getAttribute("videoWidth"), "0");
        Assert.assertEquals(video.getAttribute("paused"), "true");

        showVideoButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.attributeToBe(video, "readyState", "4"));

        Assert.assertEquals(video.getAttribute("videoHeight"), "480");
        Assert.assertEquals(video.getAttribute("videoWidth"), "640");
        Assert.assertNull(video.getAttribute("paused"));
    }
}
