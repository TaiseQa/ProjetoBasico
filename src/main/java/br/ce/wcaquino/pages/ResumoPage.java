package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import org.openqa.selenium.By;

public class ResumoPage extends BasePage {

    public void excluirMovimentacao(){
       clicarbotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
    }
    public String obterMensagemSucesso() {

        return obeterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
