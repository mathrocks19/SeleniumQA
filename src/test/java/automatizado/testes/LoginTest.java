package automatizado.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.pageObject.LoginPO;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	@Before
	public void setUp() {
		BaseTest.iniciar();
	}

	@Test
	public void TC001_LoginValido() {
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, 5);

		assertTrue(wait.until(ExpectedConditions.urlContains("produtos.html")));
	}
}