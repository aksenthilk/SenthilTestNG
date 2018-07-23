package ExecutePOM;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class POMExecutionTest {
	//To Execute the testng.xml file,we need to add "maven-compiler-plugin" and "maven-surefire-plugin"
	//Add the "maven-surefire-plugin" in the pom.xml under <build>--><plugins>--><plugin> tag
	//After version tag include the "testng.xml" in <configuration>--><suiteXmlFiles>--><SuiteXmlFile>
	//All these should be included before <dependencies> and after <properties> tag
	@Test
	public void test1(){
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.justanswer.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
