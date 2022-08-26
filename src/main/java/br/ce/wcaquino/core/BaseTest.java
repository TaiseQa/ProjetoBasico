package br.ce.wcaquino.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static br.ce.wcaquino.core.DriverFactory.killDriver;

public class BaseTest {


    //Logica para que o print tenha o nome do seu metodo
    @Rule
    public TestName testName = new TestName();


    //Após cada teste execute o conteudo desse método
    @After
    public void finaliza() throws IOException {
        //Tirar um print da tela no final de cada teste
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                File.separator + testName.getMethodName() + ".jpj"));
        if (Propriedades.FECHAR_BROWSER) {
            killDriver();
        }
    }
}
