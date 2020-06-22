package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HomePage {
	
	private WebDriver driver;
	private By buscar = By.name("search_query");
	private By botaoBuscar = By.cssSelector("#search-icon-legacy .ytd-searchbox:nth-child(1)");
	private By clicarMusica = By.cssSelector("#contents > ytd-video-renderer:nth-child(1)");
	private By fimMusica = By.cssSelector("ytp-next-button ytp-button");

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escolherMusica(String musica) {
		driver.findElement(buscar).sendKeys(musica);
		driver.findElement(botaoBuscar).click();
	}
	
	public void clicarNaMusica() {
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(1)).ignoring(org.openqa.selenium.NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clicarMusica));
		
		driver.findElement(clicarMusica).click();
	}
	
	public void verificaFimDaMusica() {
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(1)).ignoring(org.openqa.selenium.NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(fimMusica));
		
		driver.findElement(fimMusica).click();
	}

}
