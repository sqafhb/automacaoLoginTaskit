package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public LoginPage informaUsuário (String usuario) {
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("admin");
        return this;
    }

    public LoginPage informaSenha (String senha) {
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("admin");
        return this;
    }

    public LoginPage submeterLogin() {
        navegador.findElement(By.id("signinbox")).findElement(By.linkText("SIGN IN")).click();
        return this;
    }

    public String caputuraMensagemApresentada() {
        return navegador.findElement(By.linkText("Hi, Administrator")).getText();
    }

}
