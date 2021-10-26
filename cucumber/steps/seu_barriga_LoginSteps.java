package tests.seubarriga.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.seubarriga.pageobjects.HomePage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class seu_barriga_LoginSteps {
    //Driver
    public WebDriver driver;

    //By
    private By novoUsuarioBtn = By.cssSelector("[href='/cadastro']");
    private By campoNome = By.cssSelector("#nome");
    private By campoEmail = By.cssSelector("#email");
    private By campoSenha = By.cssSelector("#senha");
    private By btn = By.cssSelector(".btn");
    private By mensagemCadastroSucesso = By.xpath("//div[@class='alert alert-success']");

    //Globais
    HomePage homePage;

    //Variáveis
    String mensagemDeAcesso;
    String mensagemRecebida;
    String nomeLogin = "Rai Lima";

    @Before
    public void inicializar() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\marcos.ramos\\drivers\\chromedriver(94).exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Dado("que estou na pagina incial")
    public void que_estou_na_pagina_incial() {
        homePage = new HomePage(driver);
        homePage.carregarPaginaInicial();
    }

    @Dado("seleciono novo usuario")
    public void seleciono_novo_usuario() {
        driver.findElement(novoUsuarioBtn).click();
    }

    @Quando("eu preencho o campo nome com {string}")
    public void eu_preencho_o_campo_nome_com(String nome) {
        driver.findElement(campoNome).sendKeys(nome);
    }

    @Quando("preencho o campo email com {string}")
    public void preencho_o_campo_email_com(String email) {
        driver.findElement(campoEmail).sendKeys(email);
    }

    @Quando("preencho o campo senha com {string}")
    public void preencho_o_campo_senha_com(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
    }

    @Quando("clico no botao cadastrar")
    public void clico_no_botao_cadastrar() {
        driver.findElement(btn).click();
    }

    @Entao("sou cadastrado com sucesso")
    public void sou_cadastrado_com_sucesso() {
        mensagemDeAcesso = driver.findElement(mensagemCadastroSucesso).getText();
        assertThat(mensagemDeAcesso.toLowerCase(), is("Usuário inserido com sucesso".toLowerCase()));
    }

    @Quando("clico no botao entrar")
    public void clico_no_botao_entrar() {
      driver.findElement(btn).click();
    }

    @Entao("eu sou logado com sucesso")
    public void eu_sou_logado_com_sucesso() {
        mensagemDeAcesso = driver.findElement(mensagemCadastroSucesso).getText();
        MatcherAssert.assertThat(mensagemDeAcesso.toUpperCase(), Matchers.is("Bem vindo, ".toUpperCase() + nomeLogin.toUpperCase() + "!"));

    }

    @After
    public void finalizar(){
        driver.close();
        driver.quit();
    }

}
