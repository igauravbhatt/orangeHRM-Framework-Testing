package framework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class Base {
    WebDriver driver;
    Properties ConfigProp,TestDataProps;
    
    DriverFactory df=new DriverFactory();
    String currentuser="gaurav";


    @BeforeSuite
    public void setup() throws IOException {
       // df.init_prop();  
       Property.readData("config","url");
        df.init_driver();
        //df.init_testdata_prop();   
        driver = df.getDriver();
       // ConfigProp = df.getProp();
        //TestDataProps=df.getTestDataProp();         
        }

    @Test
    public void geturl() throws FileNotFoundException{
        driver.get(Property.readData("config","url"));
    }

    @Test
    public void login() throws IOException{
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));

    if(Property.readData("TestData","tester").toLowerCase().equals(currentuser)){
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Property.readData("TestData","username1")); 
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Property.readData("TestData","password1"));   
        driver.findElement(By.cssSelector("button[type='submit']")).click();     
    }else{
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Property.readData("TestData","username2")); 
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Property.readData("TestData","password2"));   
        driver.findElement(By.cssSelector("button[type='submit']")).click();     
    }
       
    }

    
        
    }
    

