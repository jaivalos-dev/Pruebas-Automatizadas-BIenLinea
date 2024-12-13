package Modulos.RecuperarContra;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
            String aOlvideContraXpath = "//*[@id=\"btnOpenModalPassword\"]";
            WebElement aOlvideContra = driver.findElement(By.xpath(aOlvideContraXpath));
            String aOlvideContraText = aOlvideContra.getText();
        }



    }

}
