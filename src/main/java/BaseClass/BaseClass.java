package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static ChromeDriver driver;
	public static Properties prop;

	public void launchWebTours() throws IOException {

		// Read URL
		prop = new Properties();
		String Path = System.getProperty("user.dir");
		FileInputStream input = new FileInputStream(Path + "\\src\\main\\java\\Properties\\config.properties");
		prop.load(input);

		// Launch Application
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

	}

}
