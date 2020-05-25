import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizadoChrome {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com.br");
		
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		
		campoDeTexto.sendKeys("hebaja");
		
		campoDeTexto.submit();
		
		
	}
}
