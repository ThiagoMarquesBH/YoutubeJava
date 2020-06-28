package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;

public class BaseTests {
	
	private static WebDriver driver;
	protected HomePage homePage;
	
	@BeforeAll
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\Cursos\\IIterasys\\Workspace\\Driver\\Chrome\\83\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@BeforeEach
	public void carregarPaginaInicial() {
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		homePage = new HomePage(driver);
	}
	
	@AfterEach
	public void finalizar() {
		driver.quit();
	}

}
