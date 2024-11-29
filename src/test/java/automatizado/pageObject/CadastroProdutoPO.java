package automatizado.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroProdutoPO extends BasePO {

    @FindBy(id = "btn-adicionar")
    private WebElement botaoAdicionar;

    @FindBy(id = "cadastro-produto")
    public WebElement modalCadastro;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement botaoSalvar;

    @FindBy(id = "btn-sair")
    public WebElement botaoSair;

    @FindBy(css = ".alert-danger span#mensagem")
    public WebElement mensagemErro;

    @FindBy(css = ".alert-success")
    public WebElement mensagemSucesso;

    @FindBy(css = ".alert-danger .close")
    private WebElement botaoFecharErro;

    public CadastroProdutoPO(WebDriver driver) {
        super(driver);
    }

    public void abrirModalCadastro() {
        botaoAdicionar.click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOf(modalCadastro));
    }

    public void cadastrarProduto(String codigo, String nome, String quantidade, String valor, String data) {
        inputCodigo.sendKeys(codigo);
        inputNome.sendKeys(nome);
        inputQuantidade.sendKeys(quantidade);
        inputValor.sendKeys(valor);
        inputData.sendKeys(data);
        botaoSalvar.click();
    }

    public String obterMensagemErro() {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        return wait.until(ExpectedConditions.visibilityOf(mensagemErro)).getText();
    }

    public boolean mensagemErroVisivel() {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        return wait.until(ExpectedConditions.visibilityOf(mensagemErro)).isDisplayed();
    }

    public boolean mensagemSucessoVisivel() {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        return wait.until(ExpectedConditions.visibilityOf(mensagemSucesso)).isDisplayed();
    }

    public void fecharModal() {
        botaoSair.click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.invisibilityOf(modalCadastro));
    }

    public void limparCampos() {
        inputCodigo.clear();
        inputNome.clear();
        inputQuantidade.clear();
        inputValor.clear();
        inputData.clear();
    }

    public void fecharMensagemErro() {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOf(botaoFecharErro));
        wait.until(ExpectedConditions.elementToBeClickable(botaoFecharErro)).click();
        wait.until(ExpectedConditions.invisibilityOf(mensagemErro));
    }
}