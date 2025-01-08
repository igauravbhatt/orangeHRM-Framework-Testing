package framework;

import java.io.*;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {
    FileInputStream file;
    public WebDriver driver;
    Properties prop = new Properties();
    Properties  TestDataProp = new Properties();
    final static String filePath=System.getProperty("user.dir")+"\\src\\main\\java\\framework\\resources\\";
    ChromeOptions options = new ChromeOptions(); 
      
public void browser_config(){
    options.addArguments("--start-maximized"); 
    options.addArguments("--incognito");    
}
   /* public void init_prop() {
        try {
            file = new FileInputStream(ConfigPropFilePath);
            prop.load(file);
        } catch (Exception e) {
            System.out.println("Error in reading the properties file");
        }
    }

    public void init_testdata_prop() {
        try (FileInputStream file = new FileInputStream(TestDataPropFilePath)) {
            TestDataProp.load(file);
        } catch (Exception e) {
            System.out.println("Error reading testdata.properties file: " + e.getMessage());
        }
    } */

    public WebDriver init_driver() throws IOException{
        String browser = Property.readData("config","browser").toLowerCase();
        String url = Property.readData("config","url");
        switch (browser) {
            case "chrome":
                System.out.println("Launching Chrome browser");
                WebDriverManager.chromedriver().setup();
                browser_config();     
                driver = new ChromeDriver(options);
                System.out.println("Chrome browser configured");
                driver.get(url);
                break;
                
                case "firefox":
                System.out.println("Launching firefox browser");
                WebDriverManager.firefoxdriver().setup();
                browser_config();
                driver = new FirefoxDriver();
                
                System.out.println("Firefox browser configured");
                break;


                case "edge":
                System.out.println("Launching edge browser");
                WebDriverManager.edgedriver().setup();
                browser_config();
                driver = new EdgeDriver();
                System.out.println("edge browser connfigured");
                break;
        
            default:
            System.out.println("Invalid browser: "+browser);
                return driver;
        }
        return driver;
        }
        
        //getter for driver and prop
        public WebDriver getDriver(){
          if (driver==null) {
                 throw new IllegalStateException("Driver is not initialized. Please call init_driver() first.");
                            }         
          return driver;
        }
        public Properties getProp() {
            if(prop==null){

             throw new UnsupportedOperationException("Unable to find Prop");
            }
            return prop;
        }
        public Properties getTestDataProp() {
            System.out.println(TestDataProp.getProperty("user"));
            if(TestDataProp==null){
                    
             throw new UnsupportedOperationException("Unable to find Prop");
            }
            return TestDataProp;
        }

      /*  public Objects getObjects(){
            if (driver==null) {
                throw new IllegalStateException("Driver is not initialized. Please call init_driver() first.");
                           }         
                           if(prop==null){

                            throw new UnsupportedOperationException("Unable to find Prop");
                           }if(TestDataProp==null){

                            throw new UnsupportedOperationException("Unable to find Prop");
                           }
                           return new Objects(driver,prop,testdataprop);
        } */
       

    }
    

