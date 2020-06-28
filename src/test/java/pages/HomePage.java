package pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private By buscar = By.name("search_query");
	private By botaoBuscar = By.cssSelector("#search-icon-legacy .ytd-searchbox:nth-child(1)");
	private By clicarMusica = By.cssSelector("#contents > ytd-video-renderer:nth-child(1)");
	private By anuncios = By.className("ytp-ad-skip-button-icon");
	private By fimMusica = By.className("ytp-upnext-autoplay-icon");
	ArrayList<String> listaMusica = new ArrayList<String>();

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void escolherMusica() {
		listaMusica.add("Djonga - Procuro Alguém");
		listaMusica.add("Rodrigo Ogi - Nuvens Part. Marcela Maita (Video Clipe Oficial)");
		listaMusica.add("O ceu é o limite");
		listaMusica.add("bluesman (filme oficial)");

		int n = listaMusica.size();
		for (int i = 0; i <= n; i++) {
			driver.findElement(buscar).clear();
			driver.findElement(buscar).sendKeys(listaMusica.get(i));
			driver.findElement(botaoBuscar).click();

			this.clicarNaMusica();
			this.pularAnuncios();
			this.verificaFim();
			
		}
	}

	public void clicarNaMusica() {
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1))
				.ignoring(org.openqa.selenium.NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clicarMusica));

		driver.findElement(clicarMusica).click();
	}

	public void pularAnuncios() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(anuncios));

			driver.findElement(anuncios).click();
		} catch (Exception e) {
			System.out.print("If resposta FALSE1");
		}
	}
	
	public void verificaFim() {
		FluentWait waitFim = new FluentWait(driver).withTimeout(Duration.ofSeconds(600000))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(org.openqa.selenium.NoSuchElementException.class);
		try {
			waitFim.until(ExpectedConditions.visibilityOfElementLocated(anuncios));
			driver.findElement(anuncios).click();
		} catch (Exception e) {
			waitFim.until(ExpectedConditions.visibilityOfElementLocated(fimMusica));
			driver.findElement(fimMusica);
		}
	}
}
