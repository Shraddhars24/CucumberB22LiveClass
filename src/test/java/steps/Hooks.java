package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    @Before
    public void start()  {
       openBrowserAndLaunchApplication();
        //OR
        /*driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");*/




    }
    @After
    public void end() {
        closeBrowser();
        //OR
           // driver.quit();
    }

    }

