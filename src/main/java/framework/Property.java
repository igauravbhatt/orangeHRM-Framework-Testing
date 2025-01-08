package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property {
    
    public static String readData(String fileName,String Key) throws FileNotFoundException{
    try {
        FileInputStream fis=new FileInputStream(DriverFactory.filePath+fileName+".properties");
        Properties prop=new Properties();
        prop.load(fis);
        prop.getProperty(Key);
        if(prop.containsKey(Key)){
        return prop.getProperty(Key);
      
    }        
    } catch (IOException e) {
        System.out.println("Unable to Read File. Please check if file is available at location "+DriverFactory.filePath+fileName);
    }
        return null;
    }
}
