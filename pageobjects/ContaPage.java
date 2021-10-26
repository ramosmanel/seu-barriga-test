package tests.seubarriga.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContaPage {
    //Driver
    private WebDriver driver;

    //Globais
    HomePage homePage;

    //By
    private By campoEmail = By.cssSelector("#email");
    private By campoSenha = By.cssSelector("#senha");
    private By btnEntrar = By.cssSelector(".btn");
    private By mensagemValidacao = By.cssSelector(".alert");

    //Variáveis
    String email = "lima.raipapai@gmail.com";
    String senha= "PapaiJaAma123";
    String nome = "Rai Lima";
    String mensagemValida;

    public ContaPage(WebDriver driver){
        this.driver = driver;
    }

    public void logarUsuario(){
        homePage = new HomePage(driver);
        homePage.carregarPaginaInicial();
        driver.findElement(campoEmail).sendKeys(email);
        driver.findElement(campoSenha).sendKeys(senha);
        driver.findElement(btnEntrar).click();
       mensagemValida = driver.findElement(mensagemValidacao).getText();
       assertThat(mensagemValida.toUpperCase(), is("Bem vindo, ".toUpperCase() + nome.toUpperCase() + "!"));
    }
}
