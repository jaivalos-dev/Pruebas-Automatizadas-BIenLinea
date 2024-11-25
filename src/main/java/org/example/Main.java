package org.example;

import Modulos.HomePublico.Slider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    private WebDriver driver;

    // ExtentReports variables
    ExtentReports extent;
    ExtentSparkReporter spark;
    ExtentTest test;

    @BeforeSuite
    public void setUpReport() {
        spark = new ExtentSparkReporter("Bi en Linea.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setBaseUrl(){
        driver = new EdgeDriver();
    }

    @Test(priority = 1)
    public void HomePublico() throws InterruptedException{

        test = extent.createTest("Home Público");

        Slider slider = new Slider(driver, test);
        slider.leftSlides();

    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }

}