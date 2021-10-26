package tests.seubarriga.pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void carregarPaginaInicial(){
        driver.get("https://seubarriga.wcaquino.me/login");
    }
}
