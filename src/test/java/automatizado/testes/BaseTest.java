package automatizado.testes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	// Defina URL_BASE como a única variável para a URL dinâmica
	public static String URL_BASE;

	protected static WebDriver driver;

	private static final String PATH_DRIVER = "src/test/resources/chromedriver.exe";

	@BeforeClass
	public static void iniciar() {
		URL_BASE = "file:///C:/Users/Matheus/Desktop/automatizado/sistema/produtos.html";  // Página de Produtos
		 //URL_BASE = "file:///C:/Users/Matheus/Desktop/automatizado/sistema/login.html"; // Página de Login

		System.setProperty("webdriver.chrome.driver", PATH_DRIVER);

		// Inicializa o WebDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();  // Maximiza a janela do navegador
		driver.get(URL_BASE);
	}

	// Novo método para iniciar o login
	public static void iniciarLogin() {

		URL_BASE = "file:///C:/Users/Matheus/Desktop/automatizado/sistema/login.html";
		driver.get(URL_BASE);
	}

	@AfterClass
	public static void finalizar() {
		// Fecha o navegador após os testes
		if (driver != null) {
			driver.quit();
		}
	}
}
