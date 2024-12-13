package Modulos.RecuperarContra;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecuperarContra {

    private WebDriver driver;
    private ExtentTest test;
    private String user, code;
    String url = "https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar#!";

    public RecuperarContra(WebDriver driver, ExtentTest test, String user, String code){
        this.driver = driver;
        this.test = test;
        this.user = user;
        this.code = code;
    }

    public void validacionTextos(){
        try {

            driver.get(url);
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("Validación de Textos en el modulo de Recuperación de Contraseña");
            System.out.println("----------------------------------------");

            String aOlvideContraXpath = "//*[@id=\"btnOpenModalPassword\"]";
            WebElement aOlvideContra = driver.findElement(By.xpath(aOlvideContraXpath));
            String aOlvideContraText = aOlvideContra.getText();

            if (aOlvideContraText.equals("Olvidé mi contraseña")){
                test.log(Status.INFO, "El texto del a es funcional ✓");
                System.out.println("El texto del a es funcional");
            }else{
                System.out.println("El texto del a - FAIl");
                test.log(Status.FAIL, "El texto del a - FAIL X");
            }

        }catch (Exception e) {
            throw e;

        }

    }

}
