package com.practice.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver(){}
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){
    if(driverPool.get() == null){

        // We will read our browserType from configuration.properties file. This way, we can control which browser is opened from outside our code.
        String browserType = ConfigurationReader.getProperty("browser");

        // Depending on the browserType returned from the configuration.properties
        // Switch statement will determine the "case", and open the matching browser.
        switch (browserType){
            case "chrome":
                //WebDriverManager.chromedriver().setup();
                driverPool.set(new ChromeDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            case "firefox":
                //WebDriverManager.firefoxdriver().setup();
                driverPool.set(new FirefoxDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            case "edge":
                // WebDriverManager.edgedriver().setup();
                driverPool.set(new EdgeDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            // opens Browser in the background
            case "headless-chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                driverPool.set(new ChromeDriver(options));
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            // for Driver updated version
            case "remote-allow-origins":
                ChromeOptions options2 = new ChromeOptions();
                options2.addArguments("--remote-allow-origins=*");
                driverPool.set(new ChromeDriver(options2));
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
        }//switch
    }//SDP
        return driverPool.get();
}//getDriver()

    // Create a new Driver.closeDriver(); it will use get().quit() method to quit browsers, and then remove the driver.
    public static void closeDriver(){
        if (driverPool.get()!=null){
            // This line will terminate the currently existing driver completely. It will not exist going forward.
            driverPool.get().quit();
            // We use remove() to remove the driver from existence and reset the value to null.
            driverPool.remove();
        }//if
    }//closeDriver()

}
