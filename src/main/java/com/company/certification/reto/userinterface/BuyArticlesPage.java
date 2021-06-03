package com.company.certification.reto.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static com.company.certification.reto.util.constant.BuyArticlesConstantManager.CLASE_INTERFAZ_USUARIO;

public class BuyArticlesPage {

    //Page mercado libre
    public static final Target BUTTON_LOGIN = Target.the("Button login").located(By.xpath(("//*[@id='nav-header-menu']/a[2]")));
    public static final Target EMAIL_PRELOADED = Target.the("Email preloaded").located(By.id(("change-user-link")));
    public static final Target TXT_EMAIL = Target.the("Campo email").located(By.id("user_id"));
    public static final Target BUTTON_CONTINUE_LOGIN = Target.the("Button continue login").located(By.xpath(("//*[@id='login_user_form']/div[2]/button/span")));
    public static final Target TXT_PASSWORD = Target.the("Campo password").located(By.id("password"));
    public static final Target BUTTON_SIGN_IN = Target.the("Button sing in").located(By.xpath(("//*[@id='action-complete']/span")));
    public static final Target USER_LOGIN = Target.the("Label result expected").locatedBy("//span[contains(text(),'{0}')]");

    //Page linio
    public static final Target BUTTON_LOGIN_LINIO = Target.the("Button login linio").located(By.xpath(("//*[@id='navbar']/div/div[3]/div[1]/a[3]/span")));
    public static final Target BUTTON_SESION_LINIO = Target.the("Button sesion linio").located(By.xpath(("//*[@id='user-menu']/ul/li[1]/a")));
    public static final Target TXT_EMAIL_LINIO = Target.the("Campo email linio").located(By.id("login_form_email"));
    public static final Target TXT_PASSWORD_LINIO = Target.the("Campo password linio").located(By.id("login_form_password"));
    public static final Target BUTTON_CONTINUE_LOGIN_LINIO = Target.the("Button continue login linio").located(By.xpath(("//*[@id='login-form']/form/button")));
    public static final Target USER_LOGIN_LINIO = Target.the("Label result expected linio").locatedBy("//span[contains(text(),'{0}')]");
    public static final Target LABEL_USER = Target.the("Label user").located(By.xpath("//*[@id='subheader-navbar']/div/div[2]/span"));


    private BuyArticlesPage(){
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}