package Modulos.RecuperarContra;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public void validarContenedor(){
        try {

            driver.get(url);
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("Validar contenedor de recuperación de contraseña");
            System.out.println("----------------------------------------");

            WebElement login1 = driver.findElement(By.id("login1"));
            WebElement recuperarContra = driver.findElement(By.xpath("//*[@id=\"btnOpenModalPassword\"]"));
            recuperarContra.click();

            // Espera a que el contenedor de login1 esté oculto
            wait.until(ExpectedConditions.invisibilityOf(login1));

            // Encuentra el nuevo contenedor de recuperarpassword
            WebElement recuperarPassword = driver.findElement(By.id("recuperarpassword"));

            // Verifica que el contenedor de recuperarpassword sea visible
            WebDriverWait waitVisibility = new WebDriverWait(driver, Duration.ofSeconds(10));
            waitVisibility.until(ExpectedConditions.visibilityOf(recuperarPassword));

            // Verifica las propiedades de display
            String displayLogin1 = login1.getCssValue("display");
            String displayRecuperarPassword = recuperarPassword.getCssValue("display");

            // Imprime los resultados de la validación
            if (displayLogin1.equals("none") && !displayRecuperarPassword.equals("none")) {
                System.out.println("El contenedor 'login1' está oculto y el contenedor 'recuperarpassword' está visible funcional");
                test.log(Status.INFO, "El contenedor 'login1' está oculto y el contenedor 'recuperarpassword' está visible funcional");
            } else {
                System.out.println("No se muestran los contenedores como se espera - FAIL");
                test.log(Status.FAIL, "No se muestran los contenedores como se espera - FAIL");
            }

        }catch (Exception e) {
            throw e;

        }

    }

}
