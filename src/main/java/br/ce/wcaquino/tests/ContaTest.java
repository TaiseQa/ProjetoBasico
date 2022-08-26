package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//sequência em ordem alfabetica
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test

    public void test1_Inserirconta() {
        menuPage.acessarTelaInserirconta();

        contasPage.setNome("Conta do Teste");
        contasPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());

    }

    @Test
    public void test2_AlterarConta() {
        menuPage.acessarTelaListarConta();

        contasPage.clicarAltertarConta("Conta do Teste");
        contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
        contasPage.salvar();

        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());

    }

    @Test
    public void test3_InserirContaComMesmoNome() {
        menuPage.acessarTelaInserirconta();

        contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
        contasPage.salvar();

        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }


}
