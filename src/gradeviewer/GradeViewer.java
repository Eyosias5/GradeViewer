/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeviewer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author eyosias
 */
public class GradeViewer {

    /**
     * @param args the command line arguments
     * Prepared By Eyosias Samson ATR/0484/09
     * Section 2 Third Year
     * Password Eliminated cause Repository is public
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
         WebDriver driver;
         
          driver = new ChromeDriver();
          driver.get("https://portal.aait.edu.et");
          WebElement atr = driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
          WebElement password = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
          WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button"));
          
          atr.sendKeys("ATR/0484/09");
          password.sendKeys("3484");
          loginButton.click();
          
          driver.navigate().to("https://portal.aait.edu.et/Grade/GradeReport");
          String content = driver.findElement(By.xpath("/html/body")).getText();
          
          try{
              File file = new File("GradeInfo.txt");
            try (FileWriter writeToFile = new FileWriter(file)) {
                writeToFile.write(content);
                writeToFile.flush();
            }
          }catch(IOException e){
              System.out.println(e);
          }
      Thread.sleep(1000);
      driver.quit();
      
          
         
    }
    
}
