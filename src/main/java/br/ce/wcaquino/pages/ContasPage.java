package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNome(String nome) {
        escreve("nome", nome);
    }

    public void salvar() {
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemSucesso() {
        return obeterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public String obterMensagemErro() {
        return obeterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }


    public void clicarAltertarConta(String string) {
        obterCelula("Conta", string, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();


    }
    public void clicarEcluirConta(String string) {
        obterCelula("Conta", string, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();


    }


}
