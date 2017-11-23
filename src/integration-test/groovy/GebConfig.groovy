import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver

reportsDir = "target/geb-reports"

environments {
    htmlUnit {
        driver = { new HtmlUnitDriver() }
    }

    chrome {
        System.setProperty("webdriver.chrome.driver", "C:/Users/The_Wolf/IdeaProjects/libs/selenium/chromedriver.exe")
        driver = { new ChromeDriver() }
    }

    firefox {
        System.setProperty("webdriver.gecko.driver","C:/Users/The_Wolf/IdeaProjects/libs/selenium/geckodriver.exe")
        driver = {new FirefoxDriver()}
    }

    phantomJs {
        driver = { new PhantomJSDriver() }
    }
}
