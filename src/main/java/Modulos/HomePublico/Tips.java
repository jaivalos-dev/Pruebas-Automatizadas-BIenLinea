package Modulos.HomePublico;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sun.tools.jconsole.JConsoleContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Tips {

    private WebDriver driver;
    private ExtentTest test;
    String url = "https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar#!";

    public Tips(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;
    }

    public WebDriver validateTips() {

        driver.get(url);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Validación de Tips de Seguridad");
        System.out.println("----------------------------------------");

        // XPath para los dots e imágenes
        String pXpath = "//*[@id=\"login1\"]/div[3]/div/div/a/div/p";
        String h2Xpath = "//*[@id=\"login1\"]/div[3]/div/div/a/div/h2";

        try {
            String p = driver.findElement(By.xpath(pXpath)).getText();
            String h2 = driver.findElement(By.xpath(h2Xpath)).getText();

            //System.out.println(p + " - " + h2);

            if (p.equals("Ingresa aquí para conocer tips de seguridad y ayuda con tu banca en línea.")){
                test.log(Status.INFO, "El texto de los Tips es funcional");
            } else test.log(Status.FAIL, "El texto de los Tips - FAIL");

            if (h2.equals("TIPS DE SEGURIDAD Y AYUDA")){
                test.log(Status.INFO, "El titulo de los Tips es funcional");
            } else test.log(Status.FAIL, "El texto de los Tips - FAIL");

        }catch (Exception e){
            test.log(Status.FAIL, e);
            throw e;
        }

        String btnTipsXpath = "//*[@id=\"login1\"]/div[3]/div/div/a";

        try {
            WebElement btnTips = driver.findElement(By.xpath(btnTipsXpath));
            btnTips.click();

            System.out.println("BTN Tips presionado ✓");

            Set<String> handles = driver.getWindowHandles();
            List<String> handleList = new ArrayList<>(handles);

            String newTab = handleList.get(1);

            driver.switchTo().window(newTab);
            wait.until(ExpectedConditions.urlToBe("https://www.corporacionbi.com/gt/bancoindustrial/ciberseguridad/"));
            String currentUrl = driver.getCurrentUrl();

            if (currentUrl.equals("https://www.corporacionbi.com/gt/bancoindustrial/ciberseguridad/")) {
                System.out.println("Se navego correctamente al sitio: https://www.corporacionbi.com/gt/bancoindustrial/ciberseguridad/");
                test.log(Status.INFO, "BTN Tips funcional");
            } else {
                System.out.println("No se navego al sitio esperado. URL actual: " + currentUrl);
                test.log(Status.FAIL, "BTN Tips - FAIL");
            }

            driver.close();
            driver.switchTo().window(handleList.get(0));


        }catch (Exception e){
            test.log(Status.FAIL, e);
            throw e;
        }

        return null;
    }
}
