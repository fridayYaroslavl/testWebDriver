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
	    // ��������� ������� � ��������� �� ����� ����
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://google.com/ncr");
        
        // ��������� ����� �� ����� "selenium"
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("selenium");
        element.submit();
        
        // �������� ������� ������� (������ ������ �� seleniumhq.org)
        System.out.println("�������� ������� �������");
        String firstTestResult;
        element = driver.findElement(By.className("iUh30"));
        String firstLinkText = element.getText();
        
        System.out.println("������ ��������� ������ � ����������� ������: " + firstLinkText);
        if (firstLinkText.indexOf("seleniumhq.org") != -1)
        	firstTestResult = "������ ������� (������ �� �������� ����� seleniumhq.org) - ���������";
        else 
        	firstTestResult = "������ ������� (������ �� ���� www.seleniumhq.org) - �� ���������!" +
        		"\n�������� - ������ ���� �� �������!!!";
        
        
        // ��������� �� ������� "Images"
        element = driver.findElement(By.linkText("Images"));
        Actions builder = new Actions(driver);
        builder.click(element);
        builder.build().perform();
        
        // �������� ������� ������� (������ �������� � ����� seleniumhq.org)
        String secondTestResult;
        System.out.println("�������� ������� �������");
        element = driver.findElement(By.cssSelector("#rg_s > div:nth-child(1)"));
        String imageText = element.getText();
        System.out.println("������ �������� �� �������� �������� �����: " + imageText);
        if (imageText.indexOf("seleniumhq.org") != -1)
        	secondTestResult = "������ ������� (�������� � ����� seleniumhq.org) - ���������";
        else 
        	secondTestResult = "������ ������� (�������� � ����� seleniumhq.org) - �� ���������!" +
        						"\n�������� - ������ ���� �� �������!!!";
        
        
        // ������������ �� ������� "All"
        element = driver.findElement(By.linkText("All"));
        builder.click(element);
        builder.build().perform();
        
        // �������� �������� ������� (������ ������ �� seleniumhq.org)
        String thirdTestResult;
        System.out.println("�������� �������� �������");
        element = driver.findElement(By.className("iUh30"));
        firstLinkText = element.getText();
        
        System.out.println("������ ��������� ������ � ����������� ������: " + firstLinkText);
        if (firstLinkText.indexOf("seleniumhq.org") != -1)
        	thirdTestResult = "������ ������� (������ �� �������� ����� seleniumhq.org) - ���������";
        else 
        	thirdTestResult = "������ ������� (������ �� ���� www.seleniumhq.org) - �� ���������!" +
        				"\n�������� - ������ ���� �� �������!!!";
        
        
        // ��������� �������
        driver.quit();
        
        // ������� ���������� ������������ 
        System.out.println("������������ ���������");
        System.out.println("���������� ������������");
        System.out.println("���� �1:");
        System.out.println(firstTestResult);
        System.out.println("���� �2:");
        System.out.println(secondTestResult);
        System.out.println("���� �3:");
        System.out.println(thirdTestResult);
        
	}

}
