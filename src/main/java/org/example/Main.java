package org.example;

import Modulos.HomePublico.NavBar;
import Modulos.HomePublico.Slider;
import Modulos.HomePublico.Tips;

import Modulos.RecuperarContra.RecuperarContra;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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

        System.out.println("------ Validaciones del Home Público ------");

        try{
            Slider slider = new Slider(driver, test);
            try {
                slider.leftSlides();
                test.log(Status.INFO, "Slider funcional");
            } catch (Exception e){
                test.log(Status.FAIL, "Slider - FAIL");
                throw e;
            }

            NavBar navbar = new NavBar(driver, test);
            try {
                navbar.botonesNavbar();
                test.log(Status.INFO, "NavBar funcional");
            } catch (Exception e){
                test.log(Status.FAIL, "NavBar - FAIL");
                throw e;
            }

            Tips tips = new Tips(driver, test);
            try {
                tips.validateTips();
                test.log(Status.INFO, "Tips funcional");
            } catch (Exception e){
                test.log(Status.FAIL, "Tips - FAIL");
                throw e;
            }

            test.log(Status.PASS, "Home Público Funcional ✓");

        }catch (Exception e){
            test.log(Status.FAIL, "Home Público - FAIL - "+e);
            throw e;
        }

    }


    @Test(priority = 2)
    public void RecuperarContra() throws InterruptedException{

        test = extent.createTest("Recuperar Contraseña");

        System.out.println("------ Validaciones de Recuperar Contraseña ------");

        try{
            RecuperarContra RecContra = new RecuperarContra(driver, test, "9893", "kjasdjf");
            try {
                RecContra.validacionTextos();
                test.log(Status.INFO, "Textos de recuperación de contraseña funcionales");
            } catch (Exception e){
                test.log(Status.FAIL, "Textos de recuperación de contraseña - FAIL");
                throw e;
            }

            try {
                RecContra.validarContenedor();
                test.log(Status.INFO, "Contenedores funcionales");
            } catch (Exception e){
                test.log(Status.FAIL, "Contenedores - FAIL");
                throw e;
            }

            /*NavBar navbar = new NavBar(driver, test);
            try {
                navbar.botonesNavbar();
                test.log(Status.INFO, "NavBar funcional");
            } catch (Exception e){
                test.log(Status.FAIL, "NavBar - FAIL");
            }

            Tips tips = new Tips(driver, test);
            try {
                tips.validateTips();
                test.log(Status.INFO, "Tips funcional");
            } catch (Exception e){
                test.log(Status.FAIL, "Tips - FAIL");
            }*/

            test.log(Status.PASS, "Recuperar Contraseña Funcional ✓");

        }catch (Exception e){
            test.log(Status.FAIL, "Home Público - FAIL - "+e);
            throw e;
        }

    }


    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }

}