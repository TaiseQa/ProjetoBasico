package br.ce.wcaquino.suites;

import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.tests.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class
})
public class SuiteGeral {
   private static LoginPage page = new LoginPage();

    //Antes de executar a suite ele vai logar, quando os test forem executar a aplicação vai estar logada
    @BeforeClass
    public static void inicializa() {
        page.acessarTelaInicial();
        page.setEmail("Taise@Almeida");
        page.setSenha("142536");
        page.entrar();
    }
    @AfterClass
    public static void finaliza(){
        DriverFactory.killDriver();
    }
}
