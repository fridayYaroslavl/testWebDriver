package testWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainTest {

	public static void main(String[] args) {
	    // открываем браузер и переходим на поиск Гугл
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://google.com/ncr");
        
        // выполняем поиск по слову "selenium"
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("selenium");
        element.submit();
        
        // проверка первого условия (первая ссылка на seleniumhq.org)
        System.out.println("Проверка первого условия");
        String firstTestResult;
        element = driver.findElement(By.className("iUh30"));
        String firstLinkText = element.getText();
        
        System.out.println("Первая найденная ссылка в результатах поиска: " + firstLinkText);
        if (firstLinkText.indexOf("seleniumhq.org") != -1)
        	firstTestResult = "Первое условие (ссылка на страницу сайта seleniumhq.org) - выполнено";
        else 
        	firstTestResult = "Первое условие (ссылка на сайт www.seleniumhq.org) - не выполнено!" +
        		"\nВнимание - первый тест не пройден!!!";
        
        
        // переходим на вкладку "Images"
        element = driver.findElement(By.linkText("Images"));
        Actions builder = new Actions(driver);
        builder.click(element);
        builder.build().perform();
        
        // проверка второго условия (первая картинка с сайта seleniumhq.org)
        String secondTestResult;
        System.out.println("Проверка второго условия");
        element = driver.findElement(By.cssSelector("#rg_s > div:nth-child(1)"));
        String imageText = element.getText();
        System.out.println("Первая картинка на странице содержит текст: " + imageText);
        if (imageText.indexOf("seleniumhq.org") != -1)
        	secondTestResult = "Второе условие (картинка с сайта seleniumhq.org) - выполнено";
        else 
        	secondTestResult = "Второе условие (картинка с сайта seleniumhq.org) - не выполнено!" +
        						"\nВнимание - второй тест не пройден!!!";
        
        
        // возвращаемся на вкладку "All"
        element = driver.findElement(By.linkText("All"));
        builder.click(element);
        builder.build().perform();
        
        // проверка третьего условия (первая ссылка на seleniumhq.org)
        String thirdTestResult;
        System.out.println("Проверка третьего условия");
        element = driver.findElement(By.className("iUh30"));
        firstLinkText = element.getText();
        
        System.out.println("Первая найденная ссылка в результатах поиска: " + firstLinkText);
        if (firstLinkText.indexOf("seleniumhq.org") != -1)
        	thirdTestResult = "Третье условие (ссылка на страницу сайта seleniumhq.org) - выполнено";
        else 
        	thirdTestResult = "Третье условие (ссылка на сайт www.seleniumhq.org) - не выполнено!" +
        				"\nВнимание - третий тест не пройден!!!";
        
        
        // закрываем браузер
        driver.quit();
        
        // Выводим результаты тестирования 
        System.out.println("Тестирование завершено");
        System.out.println("Результаты тестирования");
        System.out.println("Тест №1:");
        System.out.println(firstTestResult);
        System.out.println("Тест №2:");
        System.out.println(secondTestResult);
        System.out.println("Тест №3:");
        System.out.println(thirdTestResult);
        
	}

}
