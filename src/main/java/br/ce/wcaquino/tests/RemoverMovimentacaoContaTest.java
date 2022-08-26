package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class RemoverMovimentacaoContaTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirContaComMovimentacao() {
        menuPage.acessarTelaListarConta();

        contasPage.clicarEcluirConta(Propriedades.NOME_CONTA_ALTERADA);

        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}
