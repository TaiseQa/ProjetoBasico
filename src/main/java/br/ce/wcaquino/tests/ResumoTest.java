package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {

    private MenuPage menupage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

   @Test
    public void text1ExcluirMovimentacao() {
        menupage.acessarTelaResumo();

        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }

    @Test
    public void test2ResumoMensal() {
        menupage.acessarTelaResumo();
        //Verificar o titulo da pagina
        Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());

        List<WebElement> elementosEncontrados =
         DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        Assert.assertEquals(0, elementosEncontrados.size());
    }
//try {
    //DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
    //Assert.fail();
    // }catch (NoSuchElementException e ){

    //}
}
