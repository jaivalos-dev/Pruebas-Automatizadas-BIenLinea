package Modulos.HomePublico;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

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
        String btnIdiomaXpath = "//*[@id=\"menu_gral\"]/ul/li/a";

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


            //Lista Idioma
            WebElement btnIdioma = driver.findElement(By.xpath(btnIdiomaXpath));

            // Usa la clase Actions para hacer hover sobre el título
            Actions actions = new Actions(driver);
            actions.moveToElement(btnIdioma).perform();

            System.out.println("BTN Idioma Hover ✓");

            try{
                // Validar la opción Español
                WebElement opcionEspanol = driver.findElement(By.cssSelector("#menu_gral > ul > li > ul > li:nth-child(1) > a"));
                if (opcionEspanol.isDisplayed() && opcionEspanol.getText().equalsIgnoreCase("Español")) {
                    System.out.println("La opción 'Español' está visible y es correcta.");
                    test.log(Status.INFO, "La opción 'Español' está visible y es correcta.");
                } else {
                    System.out.println("La opción 'Español' no está visible o es incorrecta.");
                    test.log(Status.INFO, "La opción 'Español' no está visible o es incorrecta.");
                }

                // Validar la opción Inglés
                WebElement opcionIngles = driver.findElement(By.cssSelector("#menu_gral > ul > li > ul > li:nth-child(2) > a"));
                if (opcionIngles.isDisplayed() && opcionIngles.getText().equalsIgnoreCase("English")) {
                    System.out.println("La opción 'English' está visible y es correcta.");
                    test.log(Status.INFO, "La opción 'English' está visible y es correcta.");
                } else {
                    System.out.println("La opción 'English' no está visible o es incorrecta.");
                    test.log(Status.INFO, "La opción 'English' no está visible o es incorrecta.");
                }
                Thread.sleep(3000);

                test.log(Status.INFO, "BTN Idioma funcional");

            }catch (Exception e){
                test.log(Status.FAIL, "No se muestran las opciones al hacer Hover: " + e);
            }


        }catch (Exception e){
            test.log(Status.FAIL, e);
            throw e;
        }

        return driver;
    }

}
