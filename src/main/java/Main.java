import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


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

        System.out.println(video.getAttribute("height"));
        System.out.println(video.getAttribute("width"));
        System.out.println(video.getAttribute("paused"));
        System.out.println(video.getAttribute("autoplay"));

        showVideoButton.click();

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.querySelector('#gum-local').pause()", video);

        System.out.println(video.getAttribute("height"));
        System.out.println(video.getAttribute("width"));
        System.out.println(video.getAttribute("paused"));
        System.out.println(video.getAttribute("autoplay"));
    }
}
