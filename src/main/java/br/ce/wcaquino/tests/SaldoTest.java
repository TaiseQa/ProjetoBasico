package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.HomePage;
import br.ce.wcaquino.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {
    HomePage page = new HomePage();
    MenuPage menu = new MenuPage();

    @Test
    public void  testeSAldoConta(){
        menu.acessarTelaPrincipal();

        Assert.assertEquals("500.00", page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));

    }

}
