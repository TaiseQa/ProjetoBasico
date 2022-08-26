package br.ce.wcaquino.core;

public class Propriedades {

    public static boolean FECHAR_BROWSER = false;
public static String NOME_CONTA_ALTERADA = "Conta Alterada" + System.nanoTime();
    //Definido que por padrão ira abrir o chrome
    public static Browsers browser = Browsers.CHROME;

    //Definido quais browsers irei utilizar
    public enum Browsers {
        CHROME,
        FIREFOX
    }
}
