package experience;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusquedaProducto {

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

	@Given("Ingreso a la pagina")
	public void ingreso_a_la_pagina_new_experience() {
		driver.get("http://automationpractice.com/index.php");
	}

	@When("Busco el producto {string}")
	public void busco_el_producto(String query) {
		WebElement txtBusqueda = driver.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys(query);
		WebElement btnLupa = driver.findElement(By.name("submit_search"));
		btnLupa.click();
		
	}

	@Then("Los resultados para {string} se muestran")
	public void los_resultados_para_se_muestran(String tituloResultado) {
		String resultadoActual = driver.findElement(By.cssSelector("h1.page-heading > span.lighter")).getText();
		assertEquals(tituloResultado, resultadoActual);
	}

}
