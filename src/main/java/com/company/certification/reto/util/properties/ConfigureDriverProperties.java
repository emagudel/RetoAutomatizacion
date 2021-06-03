package com.company.certification.reto.util.properties;


import com.company.certification.reto.exceptions.BuyArticleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

public class ConfigureDriverProperties {

    private ConfigureDriverProperties() {
        throw new IllegalStateException();

    }

    public static WebDriver loadDriver() {
        Properties prop = new Properties();
        File objclasspathRoot = new File(System.getProperty("user.dir"));
        String strFilePath = objclasspathRoot.getAbsolutePath();
        try {
            prop.load(new FileReader(strFilePath + "/serenity.properties"));
            String webdriver = prop.getProperty("webdriver.driver");
            switch(webdriver) {
                case "iexplorer":
                    InternetExplorerOptions optionsIExplorer = new InternetExplorerOptions();
                    return new InternetExplorerDriver(
                            optionsIExplorer.addCommandSwitches("--start-maximized")
                    );
                case "edge":
                    return new EdgeDriver();
                case "chrome":
                    ChromeOptions optionsChrome = new ChromeOptions();
                    return new ChromeDriver(
                            optionsChrome.addArguments(
                                    "--start-maximized", "--disable-popup-blocking", "--disable-download-notification",
                                    "--disk-cache-dir=null", "--test-type", "--ignore-certificate-errors", "--allow-running-insecure-content",
                                    "--disable-translate", "--always-authorize-plugins", "--disable-extensions", "--disable-notifications",
                                    "--disable-infobars", "--enable-file-cookies", "--enable-application-cache", "--disable-web-security",
                                    "--allow-insecure-localhost", "--acceptInsecureCerts", "--incognito")
                                    .setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation")));
                default:
                    throw new RuntimeException("Unsupported webdriver: " + webdriver);
            }
        } catch (IOException e) {
            throw new BuyArticleException(e);
        }
    }
}
