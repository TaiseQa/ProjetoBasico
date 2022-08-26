package br.ce.wcaquino.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

public class BasePage {
    //*********** TextField e TextArea ****************//
    //metodo
    public void escreve(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void escreve(String id_campo, String texto) {
        escreve(By.id(id_campo), texto);
    }

    public String obterValorCampo(String id_campo) {
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    //*********** Radio E Check **********//
    public void clicarRadio(By by) {

        getDriver().findElement(by).click();
    }

    public void clicarRadio(String id) {

        clicarRadio(By.id(id));
    }

    public boolean isRadioMarcado(String id) {

        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void clicarCheck(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean isCheckMarcado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    //************** Combo *************//
    public void selecionarCombo(String id, String valor) {

        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void deselecionarCombo(String id, String valor) {

        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public String obterValorCombo(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> obeterValoresCombo(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for (WebElement opcao : allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public int obterQuantidadeOpcoescombo(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public boolean verificarOpcaoCombo(String id, String opcao) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(opcao)) {
                return true;
            }
        }
        return false;
    }

    public void selecionarComboPrime(String radical, String valor) {
        clicarRadio(By.xpath("//*[@id='" + radical + "_input']/../..//span"));
        clicarRadio(By.xpath("//*[@id='" + radical + "_items']//li[.='" + valor + "']"));

    }

    //*********** Botao ***********//
    public void clicarbotao(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarBotao(String id) {
        clicarbotao(By.id(id));

    }

    public void clicarBotaoPorTexto(String texto) {
        clicarbotao(By.xpath("//button[.='" + texto + "']"));

    }

    public String obterValueElemento(String id) {
        return getDriver().findElement(By.id(id)).getAttribute("value");
    }

    //***************** Link ****************//
    public void clicarLink(String link) {

        getDriver().findElement(By.linkText(String.valueOf(link))).click();
    }

    //************ Texto *****************//
    public String obeterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public String obeterTexto(String id) {
        return obeterTexto(By.id(id));
    }

    //****************Alerts******************//
    public String alertaObterTexto() {
        Alert alerta = getDriver().switchTo().alert();
        return alerta.getText();
    }

    public String alertaObterTextoEAceita() {
        Alert alerta = getDriver().switchTo().alert();
        String valor = alerta.getText();
        alerta.accept();
        return valor;
    }

    public String alertaObterTextoENega() {
        Alert alerta = getDriver().switchTo().alert();
        String valor = alerta.getText();
        alerta.dismiss();
        return valor;
    }

    public void alertaEscreve(String valor) {
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    //************ Frames e Janelas ********//
    public void entrarNoFrame(String id) {
        getDriver().switchTo().frame(id);
    }

    public void sairDoFrame() {
        getDriver().switchTo().defaultContent();

    }

    public void trocarJanelas(String id) {
        getDriver().switchTo().window(id);
    }

    //*********************js****************//
    public Object executorJS(String cmd, Object... parametros) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, parametros);

    }

    //**********************tabela*******************//

    public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idtabela) {
        //procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath(".//*[@id='" + idtabela + "']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);
        //encontrar linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);
        //procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
        //clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
        return celula;
    }


    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idtabela) {

        WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idtabela);
        celula.findElement(By.xpath(".//input")).click();
    }

    private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinha = i + 1;
                break;
            }
        }
        return idLinha;
    }


    private int obterIndiceColuna(String colunaBusca, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equals(colunaBusca)) {
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }
}
