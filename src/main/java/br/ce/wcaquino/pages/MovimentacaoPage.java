package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MovimentacaoPage extends BasePage {
    public void setDataMovimentacao(String data) {
        escreve("data_transacao", data);
    }

    public void setDataPagamento(String data) {
        escreve("data_pagamento", data);
    }

    public void setDescricao(String descricao) {
        escreve("descricao", descricao);
    }

    public void setInteressado(String interessado) {
        escreve("interessado", interessado);
    }

    public void setValor(String valor) {
        escreve("valor", valor);
    }

    public void setConta(String conta) {
        selecionarCombo("conta", conta);
    }

    public void setStatusPago() {
        clicarRadio("status_pago");
    }

    public void salvar() {
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemSucesso() {
        return obeterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

   public List<String> obterErros(){
       List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
       List<String> retorno = new ArrayList<String>();
       for (WebElement erro:erros){
           retorno.add(erro.getText());
       }
       return retorno;
    }


    }

