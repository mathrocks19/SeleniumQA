package automatizado.testes;

import automatizado.pageObject.CadastroProdutoPO;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static automatizado.testes.BaseTest.driver;
import static org.junit.Assert.assertTrue;

public class CadastroProdutoTest extends BaseTest {

    @Test
    public void TC006_FecharMensagemErro() {

        CadastroProdutoPO cadastroPage = new CadastroProdutoPO(driver);
        cadastroPage.abrirModalCadastro();

        cadastroPage.cadastrarProduto("999", "", "1", "1000", "2024-12-01");

        WebDriverWait wait = new WebDriverWait(driver, 7);
        assertTrue(cadastroPage.mensagemErroVisivel());

        cadastroPage.fecharMensagemErro();
        wait.until(ExpectedConditions.invisibilityOf(cadastroPage.mensagemErro));
    }

    @Test
    public void TC007_DeveFecharTelaCadastroAoClicarNoBotaoSair() {
        CadastroProdutoPO cadastroPage = new CadastroProdutoPO(driver);

        cadastroPage.abrirModalCadastro();

        WebDriverWait wait = new WebDriverWait(driver, 7);
        assertTrue(wait.until(ExpectedConditions.visibilityOf(cadastroPage.modalCadastro)).isDisplayed());

        cadastroPage.fecharModal();

        assertTrue(wait.until(ExpectedConditions.invisibilityOf(cadastroPage.modalCadastro)));
    }

    @Test
    public void TC008_AoClicarUmaVezNoBotaoCriarDeveAbrirTelaCadastro() {
        CadastroProdutoPO cadastroPage = new CadastroProdutoPO(driver);

        WebDriverWait wait = new WebDriverWait(driver, 7);
        assertTrue(wait.until(ExpectedConditions.invisibilityOf(cadastroPage.modalCadastro)));

        cadastroPage.abrirModalCadastro();

        assertTrue(wait.until(ExpectedConditions.visibilityOf(cadastroPage.modalCadastro)).isDisplayed());
    }

    @Test
    public void TC009_DeveSairDaMensagemErroAoClicarNoIconeX() {
        CadastroProdutoPO cadastroPage = new CadastroProdutoPO(driver);

        cadastroPage.cadastrarProduto("999", "", "1", "1000", "2024-12-01");

        WebDriverWait wait = new WebDriverWait(driver, 7);
        assertTrue(cadastroPage.mensagemErroVisivel());

        cadastroPage.fecharMensagemErro();

        assertTrue(wait.until(ExpectedConditions.invisibilityOf(cadastroPage.mensagemErro)));
    }

    @Test
    public void TC010_DeveExibirErroAoDeixarNomeProdutoEmBranco() {
        CadastroProdutoPO cadastroPage = new CadastroProdutoPO(driver);

        cadastroPage.abrirModalCadastro();

        // Deixa o campo vazio ou branco
        cadastroPage.cadastrarProduto("", "Descrição do Produto", "1", "1000", "2024-12-01");

        WebDriverWait wait = new WebDriverWait(driver, 10); // Aumentando o tempo de espera
        // Espera  que a mensagem de erro seja visível
        assertTrue(wait.until(ExpectedConditions.visibilityOf(cadastroPage.mensagemErro)).isDisplayed());
        assertTrue(cadastroPage.mensagemErroVisivel());
    }

}