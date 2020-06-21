package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	private By buscar = By.id("search");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escolherMusica(String musica) {
		driver.findElement(buscar).click();
		driver.findElement(buscar).sendKeys(musica);
	}
	
	public int a() {
		return 8;
	}

}
