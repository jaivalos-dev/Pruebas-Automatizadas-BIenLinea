package Modulos.HomePublico;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NavBar {

    private WebDriver driver;
    private ExtentTest test;
    String url = "https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar";

    public NavBar(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;
    }

    public WebDriver botonesNavbar() throws InterruptedException{

        driver.get(url);
        driver.manage().window().maximize();

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Validación de Botones de Navbar");
        System.out.println("----------------------------------------");

        String btnLogoXpath = "/html/body/div[1]/div[1]/ul/li/a";
        String btnProductosXpath = "/html/body/div[1]/div[2]/ul/li[1]/a";
        String btnAgenciaXpath = "/html/body/div[1]/div[2]/ul/li[2]/a";
        String btnHorariosXpath = "/html/body/div[1]/div[2]/ul/li[3]/a";

        String currentUrl = "";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try{

            //BTN Logo
            WebElement btnLogo = driver.findElement(By.xpath(btnLogoXpath));
            btnLogo.click();

            System.out.println("BTN Logo presionado ✓");
            wait.until(ExpectedConditions.urlToBe("https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar"));

            currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar")) {
                System.out.println("Se navego correctamente al sitio: https://www.bienlinea.bi.com.gt/InicioSesion/Inicio/Autenticar");
                test.log(Status.INFO, "BTN Logo funcional");
            } else {
                System.out.println("No se navego al sitio esperado. URL actual: " + currentUrl);
                test.log(Status.FAIL, "BTN Logo - FAIL");
            }

            //BTN Productos
            WebElement btnProductos = driver.findElement(By.xpath(btnProductosXpath));
            btnProductos.click();

            System.out.println("BTN Productos presionado ✓");

            String newTab = "";

            //Se obtienen los hashes de todas las pestañas que tiene el driver actualmente abiertas
            Set<String> handles = driver.getWindowHandles();
            List<String> handleList = new ArrayList<>(handles);  // Convertimos el Set a una lista

            newTab = handleList.get(1);
            driver.switchTo().window(newTab);
            wait.until(ExpectedConditions.urlToBe("https://www.corporacionbi.com/gt/bancoindustrial/solicitud-de-productos-en-linea/"));
            currentUrl = driver.getCurrentUrl();

            if (currentUrl.equals("https://www.corporacionbi.com/gt/bancoindustrial/solicitud-de-productos-en-linea/")) {
                System.out.println("Se navego correctamente al sitio: https://www.corporacionbi.com/gt/bancoindustrial/solicitud-de-productos-en-linea/");
                test.log(Status.INFO, "BTN Productos funcional");
            } else {
                System.out.println("No se navego al sitio esperado. URL actual: " + currentUrl);
                test.log(Status.FAIL, "BTN Productos - FAIL");
            }

            driver.close();
            driver.switchTo().window(handleList.get(0));

            //BTN Agencia
            WebElement btnAgencia = driver.findElement(By.xpath(btnAgenciaXpath));
            btnAgencia.click();

            System.out.println("BTN Agencia presionado ✓");

            handles = driver.getWindowHandles();
            handleList = new ArrayList<>(handles);
            newTab = handleList.get(1);

            driver.switchTo().window(newTab);
            wait.until(ExpectedConditions.urlToBe("https://www.corporacionbi.com/gt/bancoindustrial/agencia-virtual/"));
            currentUrl = driver.getCurrentUrl();

            if (currentUrl.equals("https://www.corporacionbi.com/gt/bancoindustrial/agencia-virtual/")) {
                System.out.println("Se navego correctamente al sitio: https://www.corporacionbi.com/gt/bancoindustrial/agencia-virtual/");
                test.log(Status.INFO, "BTN Agencias funcional");
            } else {
                System.out.println("No se navego al sitio esperado. URL actual: " + currentUrl);
                test.log(Status.FAIL, "BTN Agencias - FAIL");
            }

            driver.close();
            driver.switchTo().window(handleList.get(0));

            //BTN Horario
            WebElement btnHorario = driver.findElement(By.xpath(btnHorariosXpath));
            btnHorario.click();

            System.out.println("BTN Horario presionado ✓");

            wait.until(ExpectedConditions.urlToBe("https://www.bienlinea.bi.com.gt/InicioSesion/Contenido/horarios.html"));

            currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://www.bienlinea.bi.com.gt/InicioSesion/Contenido/horarios.html")) {
                System.out.println("Se navego correctamente al sitio: https://www.bienlinea.bi.com.gt/InicioSesion/Contenido/horarios.html");
                test.log(Status.INFO, "BTN Horario funcional");
            } else {
                System.out.println("No se navego al sitio esperado. URL actual: " + currentUrl);
                test.log(Status.FAIL, "BTN Horario - FAIL");
            }

            driver.navigate().back();

        }catch (Exception e){
            test.log(Status.FAIL, e);
            throw e;
        }

        return driver;
    }

}
