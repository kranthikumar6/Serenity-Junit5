package webtests.download.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("http://the-internet.herokuapp.com/download")
public class DownloadPage extends PageObject {
    public void downloadSampleTextFile() {
        $(By.linkText("random_data.txt")).click();
    }
}
