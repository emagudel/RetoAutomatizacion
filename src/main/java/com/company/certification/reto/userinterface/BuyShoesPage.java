package com.company.certification.reto.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static com.company.certification.reto.util.constant.BuyShoeConstantManager.CLASE_INTERFAZ_USUARIO;

public class BuyShoesPage {
    public static final Target IMAGE_AVATAR = Target.the("Image avatar").located(By.xpath(("//*[@id='root']/div/div/div[1]/div/header/div[1]/section/div/ul/li[1]/div/div/button/div/img")));
    public static final Target BUTTON_LOGIN = Target.the("Button login").located(By.xpath(("//*[@class='join-log-in text-color-grey prl3-sm pt2-sm pb2-sm fs12-sm d-sm-b']")));
    public static final Target TXT_EMAIL = Target.the("Campo email").located(By.name("emailAddress"));
    public static final Target TXT_PASSWORD = Target.the("Campo password").located(By.name("password"));
    public static final Target CHECK_LOGIN = Target.the("Check login").located(By.xpath(("//*[@id='keepMeLoggedIn']/label")));

    public static final Target BUTTON_SIGN_IN = Target.the("Button sing in").located(By.xpath(("//*[@class='nike-unite-submit-button loginSubmit nike-unite-component']")));
    public static final Target LIST_SHOES = Target.the("List shoes").located(By.xpath(("//*[contains(@class,'pb2-sm va-sm-t ncss-col-sm-12 ncss-col-md-6 ncss-col-lg-4 pb4-md prl0-sm prl2-md ncss-col-sm-6 ncss-col-lg-3 pb4-md prl2-md')]")));
    public static final Target LIST_SHOES_SIZE = Target.the("List shoes size").located(By.xpath(("//*[@class='size va-sm-m d-sm-ib va-sm-t ta-sm-c  ']")));
    public static final Target BUTTON_ADD_TO_CAR = Target.the("Button add to car").located(By.xpath(("//*[@class='ncss-btn-primary-dark btn-lg']")));
    public static final Target BUTTON_ADD_TO_CAR_RAFFLE = Target.the("Button add to car raffle").located(By.xpath(("//*[@class='ncss-btn-primary-dark buyable-full-width ']")));
    public static final Target BUTTON_GO_TO_CAR = Target.the("Button go to car").located(By.xpath(("//*[@class='hover-color-black text-color-grey bg-transparent prl3-sm pt2-sm pb2-sm m0-sm fs12-sm d-sm-b jewel-cart-container']")));
    public static final Target BUTTON_CHECKOUT = Target.the("Button checkout").located(By.xpath(("//*[@id='maincontent']/div[2]/div[2]/aside/div[7]/div/button[1]")));
    public static final Target BUTTON_PLACE_ORDER = Target.the("Button place orden").located(By.xpath(("//*[@class='ncss-col-sm-12 va-sm-t ta-sm-r']//button")));
    public static final Target LABEL_THANKYOU = Target.the("Label thankyou").located(By.xpath(("//*[@id='app-container']/div[3]/div/div[1]/div/h1")));

    public static final Target LABEL_DETAIL_SHOE = Target.the("Label detail shoe").located(By.xpath(("//*[@class='test-available-date']")));
    public static final Target POPOUP_ERROR = Target.the("Popup error").located(By.xpath(("//*[@class='nike-unite-error-close']")));
    public static final Target BUTTON_RAFFLE_GENERAL = Target.the("Button raffle general").located(By.xpath(("//*[contains(@class, 'ncss-btn-primary-dark')]")));

    public static final Target LIST_SHOES_IN_STOCK = Target.the("List shoes in stock").locatedBy(("//*[@class='pb2-sm va-sm-t ncss-col-sm-6 ncss-col-md-3 ncss-col-xl-2 prl1-sm']//*[@aria-label=\"{0}\"]"));

    public static final Target BUTTON_RAFFLE_1 = Target.the("Button raffle 1").located(By.xpath(("//*[@id='checkout-sections']/div[3]/div/div/div[6]/button")));
    public static final Target BUTTON_RAFFLE_2 = Target.the("Button raffle 2").located(By.xpath(("//*[@id='root']/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div[2]/button")));
    public static final Target BUTTON_RAFFLE_3 = Target.the("Button raffle 3").located(By.xpath(("//*[@id='root']/div/div/div[2]/div/div/div/div/div/div/div/div/div/div[5]/button")));

    public static final Target IMAGE_NUMBER_CAR = Target.the("Image number car").located(By.xpath(("//*[@id='root']/div/div/div[1]/div/header/div[1]/section/div/ul/li[3]/a/span")));
    public static final Target BUTTON_USER_SESION = Target.the("Button user sesion").located(By.xpath(("//*[@id='app-container']/div[1]/div/div[3]/div[2]/a/span")));
    public static final Target BUTTON_USER_SESION_2 = Target.the("Button user sesion").located(By.xpath(("//*[@id='AccountMenu']/a/div/div")));
    public static final Target BUTTON_LOGOUT = Target.the("Button log out").located(By.xpath(("//*[@id='AccountMenu-Menu']/div/nav/ul/li[7]/button")));

    private BuyShoesPage(){
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}