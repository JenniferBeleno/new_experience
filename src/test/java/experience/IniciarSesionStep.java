package experience;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IniciarSesionStep {

	public WebDriver driver;

	@Before()
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		this.driver = new ChromeDriver();
	}

	@After()
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Given("Ingreso a la pagina new experience")
	public void ingreso_a_la_pagina_new_experience() {
		driver.get("http://automationpractice.com/index.php");
	}

	@When("Ingreso a Sign In")
	public void ingreso_a_sign_in() {
		WebElement btnSignIn = driver.findElement(By.className("login"));
		btnSignIn.click();
	}

	@And("Digito Email address {string}")
	public void digito_email_address(String email) {
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys(email);
	}

	@And("Digito Password {string}")
	public void digito_password(String password) {
		WebElement txtPassword = driver.findElement(By.name("passwd"));
		txtPassword.sendKeys(password);
	}

	@Then("accedo a la pagina new experience con el cliente {string}")
	public void accedo_a_la_pagina_new_experience(String cliente) {
		driver.findElement(By.id("SubmitLogin")).click();
		String clienteActual = driver.findElement(By.cssSelector("a.account > span")).getText();
		assertEquals(cliente, clienteActual);
	}
}
