package br.ce.wcaquino.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    //Instância
    private static WebDriver driver;

    //construtor
    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (Propriedades.browser) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
            }

            return driver;

        }


    public static void killDriver() {
        if (driver != null) {
            getDriver().quit();
            driver = null;
        }
    }
}
