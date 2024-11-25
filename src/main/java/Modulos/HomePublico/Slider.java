package Modulos.HomePublico;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

public class Slider {

    private WebDriver driver;
    private ExtentTest test;
    String url = "https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar#!";

    public Slider(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;
    }

    public WebDriver leftSlides() throws InterruptedException {

        driver.get(url);
        driver.manage().window().maximize();

        List<WebElement> dots = driver.findElements(By.className("dot"));

        System.out.println("Dots from slider");
        System.out.println("----------------------------------------");

        int id = 0;
        for (WebElement dot : dots) {
            id++;
            dot.click();
            System.out.println("Dot: " + id);
            Thread.sleep(3000);
        }

        for (int i = dots.size() - 1 ;i>=0 ;i--){
            WebElement dot = dots.get(i);
            dot.click();
            System.out.println("Dot: " + (i+1));
            Thread.sleep(3000);
        }

        test.log(Status.INFO, "Prueba de Slider funcional");

        return driver;

    }
}
