package modulos.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;


@DisplayName("Teste Web de Login no site taskit")
public class LoginTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){

        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\ChromeDriver\\chromedriver.exe");
        this.navegador = new ChromeDriver();
        this.navegador.manage().window().maximize();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        this.navegador.get("http://www.juliodelima.com.br/taskit/");
        this.navegador.findElement(By.linkText("Sign in")).click();

    }

    @Test
    @DisplayName("Validando usuário e mensagem")
    public void testFazerLoginEValidarMensagem(){

        String mensagemApresentada = new LoginPage(navegador)
                .informaUsuário("admin")
                .informaSenha("admin")
                .submeterLogin()
                .caputuraMensagemApresentada();

        Assertions.assertEquals("Hi, Administrator", mensagemApresentada);
    }

    @AfterEach
    public void afterEach(){
        navegador.quit();
    }

}
