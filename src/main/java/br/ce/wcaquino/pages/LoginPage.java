package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;

public class LoginPage extends BasePage {

    public void acessarTelaInicial() {
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
    }

    public void setEmail(String email){
        escreve("email", email);
    }

    public void setSenha(String senha){
        escreve("senha", senha);
    }
    public void entrar(){
       clicarBotaoPorTexto("Entrar");

    }
    //metodo para simplificar os metodos criados acima
    public void logar(String email, String senha) {
        setEmail(email);
        setSenha(senha);
        entrar();
    }
}
