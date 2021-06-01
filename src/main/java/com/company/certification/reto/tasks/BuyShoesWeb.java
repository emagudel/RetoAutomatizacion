package com.company.certification.reto.tasks;



import com.company.certification.reto.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.List;


import static com.company.certification.reto.model.DataTest.obtain;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuyShoesWeb implements Task {
    Exception capturar;
    public static final String EMAIL = "emailAddress";
    public static final String PASSWORD = "password";

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Robot robot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            robot.mouseMove(-screenSize.width, -screenSize.height);
        } catch (Exception e) {
            capturar = e;
        }
        WebDriver driver = actor.recall("driverBrowser");
        driver.findElement(By.xpath("//*[@class='join-log-in text-color-grey prl3-sm pt2-sm pb2-sm fs12-sm d-sm-b']")).click();
        driver.findElement(By.name(EMAIL)).sendKeys(obtain("user"));
        driver.findElement(By.name(PASSWORD)).sendKeys(obtain("passwordUser"));
        driver.findElement(By.xpath("//*[@class='nike-unite-submit-button loginSubmit nike-unite-component']")).click();
        skipPopupLogInProblemWeb(driver);
        actor.attemptsTo(Wait.aTime(5000));
        selectionShoes(driver);
        actor.attemptsTo(Wait.aTime(5000));
        selectionShoesSize(driver);
        actor.attemptsTo(Wait.aTime(5000));

        //BOTON AGREGAR AL CARRITO
        driver.findElement(By.xpath("//*[@class='ncss-btn-primary-dark btn-lg']")).click();
        actor.attemptsTo(Wait.aTime(10000));
        //BOTON IR AL CARRITO DE COMPRA
        driver.findElement(By.xpath("//*[@class='hover-color-black text-color-grey bg-transparent prl3-sm pt2-sm pb2-sm m0-sm fs12-sm d-sm-b jewel-cart-container']")).click();
        actor.attemptsTo(Wait.aTime(10000));
        //BOTON CHECKOUT
        driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div[2]/aside/div[7]/div/button[1]")).click();
        actor.attemptsTo(Wait.aTime(20000));
        //BOTON PEDIR ORDEN
        if (driver.findElement(By.xpath("//*[@class='ncss-col-sm-12 va-sm-t ta-sm-r']//button")).isDisplayed()){
            System.out.println("objeto encontrado");
        }else {
            System.out.println("objeto no encontrado");
        }

        //driver.close();
    }

    private void selectionShoes(WebDriver driver) {
        Actions actions = new Actions(driver);
        String reference ="";
        List<WebElement> listaZapatos = driver.findElements(By.xpath("//*[contains(@class,'pb2-sm va-sm-t ncss-col-sm-12 ncss-col-md-6 ncss-col-lg-4 pb4-md prl0-sm prl2-md ncss-col-sm-6 ncss-col-lg-3 pb4-md prl2-md')]"));
        for (WebElement listaZapato : listaZapatos) {
            reference = listaZapato.getText().replace(" ", "").replace("\n", "");
            if (reference.equalsIgnoreCase(obtain("reference"))) {
                actions.moveToElement(listaZapato).click().build().perform();
                break;
            }
        }
    }

    private void selectionShoesSize(WebDriver driver) {
        Actions actions = new Actions(driver);
        String reference ="";
        List<WebElement> tallaZapatos = driver.findElements(By.xpath("//*[@class='size va-sm-m d-sm-ib va-sm-t ta-sm-c  ']"));
        for (WebElement tallaZapato : tallaZapatos) {
            reference = tallaZapato.getText().replace(" ", "");
            if (reference.equalsIgnoreCase(obtain("shoeSize"))) {
                actions.moveToElement(tallaZapato).click().build().perform();
                break;
            }
        }
    }

    private void skipPopupLogInProblemWeb(WebDriver driver) {
        try {
            while (driver.findElement(By.xpath("//*[@class='nike-unite-error-close']")).isDisplayed()) {
                driver.findElement(By.xpath("//*[@class='nike-unite-error-close']")).click();
                driver.findElement(By.name(EMAIL)).clear();
                driver.findElement(By.name(EMAIL)).sendKeys(obtain("user"));
                driver.findElement(By.name(PASSWORD)).sendKeys(obtain("passwordUser"));
                driver.findElement(By.xpath("//*[@class='nike-unite-submit-button loginSubmit nike-unite-component']")).click();
            }
        } catch (Exception e) {
            capturar = e;
        }
    }

    public static BuyShoesWeb inTheAplication() {
        return instrumented(BuyShoesWeb.class);
    }
}
