package webtests.download;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.WithTag;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.model.configuration.SessionLocalTempDirectory;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import webtests.download.pageobjects.DownloadPage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
@WithTag("local")
public class WhenDownloadingFiles {

    @Managed(driver = "chrome")
    WebDriver driver;

    DownloadPage downloadPage;

    @Test
    public void weCanDownloadAFileToOurHardDrive() {

        downloadPage.open();

        // Download a file
        downloadPage.downloadSampleTextFile();

        // Identify the temporary download directory
        File downloadedFile = SessionLocalTempDirectory.forTheCurrentSession().resolve("random_data.txt").toFile();

        // Wait for the file to download
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(downloadedFile::exists);

        // Check that the file exists
        assertThat(downloadedFile).exists();
    }
}
