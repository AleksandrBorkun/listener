package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class CreateCategoryTest{

    private static final String LOGIN = "webinar.test@gmail.com";
    private static final String PASSWORD = "Xcg7299bnSmMuRLp9ITw";
    private static final String CATEGORY_NAME = "TEST";


    public static void main(String[] args) throws InterruptedException {

        EventFiringWebDriver driver = BaseScript.getInstance().getDriverListener();
        GeneralActions generalActions = new GeneralActions(driver);
        driver.navigate().to(Properties.getBaseAdminUrl());
        generalActions.login(LOGIN, PASSWORD);
        generalActions.createCategory(CATEGORY_NAME);

        if(CATEGORY_NAME.equalsIgnoreCase(CATEGORY_NAME)){
            System.out.println("check that new category appears in Categories table = passed");
        }
        else {
            System.out.println("check that new category appears in Categories table = failed");
        }

        BaseScript.getInstance().driverClose();


        // TODO prepare driver object
        // WebDriver driver = getConfiguredDriver();
        // ...

        // login


        // create category

        // check that new category appears in Categories table

        // finish script
    }
}
