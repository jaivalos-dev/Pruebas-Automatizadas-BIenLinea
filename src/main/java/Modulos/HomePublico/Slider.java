package Modulos.HomePublico;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Validación de Dots e Imagenes");
        System.out.println("----------------------------------------");

        // XPath para los dots e imágenes
        String dotXpath1 = "/html/body/div[2]/div/div[1]/div/span[1]"; // Reemplazar con el XPath del primer dot
        String dotXpath2 = "/html/body/div[2]/div/div[1]/div/span[2]"; // Reemplazar con el XPath del segundo dot
        String dotXpath3 = "/html/body/div[2]/div/div[1]/div/span[3]"; // Reemplazar con el XPath del tercer dot

        String imgXpath1 = "/html/body/div[2]/div/div[1]/a[1]"; // Reemplazar con el XPath de la primera imagen
        String imgXpath2 = "/html/body/div[2]/div/div[1]/a[2]"; // Reemplazar con el XPath de la segunda imagen
        String imgXpath3 = "/html/body/div[2]/div/div[1]/a[3]"; // Reemplazar con el XPath de la tercera imagen

        // WebDriverWait para esperar los elementos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navegar por los dots y hacer clic en las imágenes asociadas
        try{
            WebElement dot1 = driver.findElement(By.xpath(dotXpath1));
            WebElement img1 = driver.findElement(By.xpath(imgXpath1));

            dot1.click();
            img1.click();
            System.out.println("Image: 1");

            wait.until(ExpectedConditions.urlToBe("https://www.corporacionbi.com/gt/bancoindustrial/beneficios-de-ser-cliente-bi/?utm_id=2023_febrero_abierta_trafico&utm_campaign=cuentadigital_ahorro_monetaria&utm_campaign_id=acquisition&utm_source=home_bel&utm_medium=medios_propios"));

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://www.corporacionbi.com/gt/bancoindustrial/beneficios-de-ser-cliente-bi/?utm_id=2023_febrero_abierta_trafico&utm_campaign=cuentadigital_ahorro_monetaria&utm_campaign_id=acquisition&utm_source=home_bel&utm_medium=medios_propios")) {
                System.out.println("Se navego correctamente al sitio: https://www.corporacionbi.com/gt/bancoindustrial/beneficios-de-ser-cliente-bi/?utm_id=2023_febrero_abierta_trafico&utm_campaign=cuentadigital_ahorro_monetaria&utm_campaign_id=acquisition&utm_source=home_bel&utm_medium=medios_propios");
                test.log(Status.INFO, "Primer DOT e Imagen funcional");
            } else {
                System.out.println("No se navego al sitio esperado. URL actual: " + currentUrl);
                test.log(Status.FAIL, "Primer DOT e Imagen - FAIL");
            }

            driver.navigate().back();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dotXpath1))); // Esperar a que el primer dot sea visible

        } catch (Exception e) {
            test.log(Status.FAIL, e);
            throw e;
        }

        try{
            WebElement dot2 = driver.findElement(By.xpath(dotXpath2));
            WebElement img2 = driver.findElement(By.xpath(imgXpath2));

            dot2.click();
            img2.click();
            System.out.println("Image: 2");

            wait.until(ExpectedConditions.urlToBe("https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar#!"));

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar#!")) {
                System.out.println("Se navego correctamente al sitio: https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar");
                test.log(Status.INFO, "Segundo DOT e Imagen funcional");
            } else {
                System.out.println("No se navego al sitio esperado. URL actual: " + currentUrl);
                test.log(Status.INFO, "Segundo DOT e Imagen - FAIL");
            }

            driver.navigate().back();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dotXpath2))); // Esperar a que el segundo dot sea visible

        } catch (Exception e) {
            test.log(Status.FAIL, e);
            throw e;
        }

        try{
            WebElement dot3 = driver.findElement(By.xpath(dotXpath3));
            WebElement img3 = driver.findElement(By.xpath(imgXpath3));

            dot3.click();
            img3.click();
            System.out.println("Image: 3");

            wait.until(ExpectedConditions.urlToBe("https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar#!"));

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar#!")) {
                System.out.println("Se navego correctamente al sitio: https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar");
                test.log(Status.INFO, "Tercer DOT e Imagen funcional");
            } else {
                System.out.println("No se navego al sitio esperado. URL actual: " + currentUrl);
                test.log(Status.INFO, "Tercer DOT e Imagen - FAIL");
            }

            driver.navigate().back();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dotXpath3))); // Esperar a que el tercer dot sea visible

        } catch (Exception e) {
            test.log(Status.FAIL, e);
            throw e;
        }

        return driver;

    }
}
