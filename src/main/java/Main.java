import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ArrayList<String> chromeConfigs = new ArrayList<String>();
        chromeConfigs.add("--use-fake-ui-for-media-stream");
        chromeConfigs.add("--use-fake-device-for-media-stream");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(chromeConfigs);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://webrtc.github.io/samples/src/content/getusermedia/gum/");
        // driver.switchTo().alert().accept();
        driver.findElement(By.id("showVideo")).click();
    }
}
