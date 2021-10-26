package tests.seubarriga.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.seubarriga.pageobjects.ContaPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class seu_barriga_ContaSteps {
    //Driver
    private WebDriver driver;

    //By
    By contas = By.cssSelector(".dropdown-toggle");
    By adicionarConta = By.cssSelector("[href='/addConta']");
    By campoTxtNomeConta = By.cssSelector("#nome");
    By btnSalvar = By.cssSelector(".btn");
    By mensagemContaAdicionada = By.cssSelector(".alert");
    By listar = By.cssSelector("[href='/contas']");
    By alterarConta = By.cssSelector("tr:nth-of-type(5) .glyphicon-edit");


    //Globais
    ContaPage contaPage;

    //Variáveis
    String contaAdicionada;
    String mensagemValida = "Conta adicionada com sucesso!";
    String mensagemContaAlterada = "Conta alterada com sucesso!";

    @Before
    public void inicializar() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\marcos.ramos\\drivers\\chromedriver(94).exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Dado("que estou logado")
    public void que_estou_logado() {
        contaPage = new ContaPage(driver);
        contaPage.logarUsuario();
    }

    @Quando("clico em contas")
    public void clico_em_contas() {
        driver.findElement(contas).click();
    }

    @Quando("clico em adicionar")
    public void clico_em_adicionar() {
        driver.findElement(adicionarConta).click();
    }

    @Quando("escrevo no campo nome {string}")
    public void escrevo_no_campo_nome(String nomeConta) {
        driver.findElement(campoTxtNomeConta).sendKeys(nomeConta);
    }

    @Quando("clico em salvar")
    public void clico_em_salvar() {
        driver.findElement(btnSalvar).click();
    }

    @Entao("minha conta e criada com sucesso")
    public void minha_conta_e_criada_com_sucesso() {
        contaAdicionada = driver.findElement(mensagemContaAdicionada).getText();
        assertThat(contaAdicionada.toUpperCase(), is(mensagemValida.toUpperCase()));
    }

    @Entao("eu vejo as contas em forma de lista")
    public void eu_vejo_as_contas_em_forma_de_lista() {
        driver.findElement(listar).click();
    }
    @Dado("que eu veja as contas em forma de lista")
    public void que_eu_veja_as_contas_em_forma_de_lista() {
        driver.findElement(listar).click();
    }

    @Quando("clico em alterar")
    public void clico_em_alterar() {
        driver.findElement(alterarConta).click();
    }

    @Quando("escrevo o nome da conta {string}")
    public void escrevo_o_nome_da_conta(String nomeContaAlterada) {
        driver.findElement(campoTxtNomeConta).clear();
        driver.findElement(campoTxtNomeConta).sendKeys(nomeContaAlterada);
    }

    @Quando("e clico em salvar")
    public void e_clico_em_salvar(){
        driver.findElement(btnSalvar).click();
    }

    @Entao("o nome da conta e alterado")
    public void o_nome_da_conta_e_alterado() {
        contaAdicionada = driver.findElement(mensagemContaAdicionada).getText();
        assertThat(contaAdicionada.toUpperCase(), is(mensagemContaAlterada.toUpperCase()));

    }

    @After
    public void finalizar(){
        driver.close();
        driver.quit();
    }

}
