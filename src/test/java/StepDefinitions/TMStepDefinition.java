package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TMPage;
import Utilities.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;


public class TMStepDefinition extends CommonDriver
{

    LoginPage loginPageobj= new LoginPage();
    HomePage homePaheobj =new HomePage();
    TMPage tmPageobj =new TMPage();
    @Before
    public void LoginActions() {

        // Launch Chrome browser
        driver = new ChromeDriver();

    }

    @After
    public void CloseTestRun() {
        driver.quit();

    }

    @Given("User  should be logged in to turnup portal")
    public void userShouldBeLoggedInToTurnupPortal()
    {
        loginPageobj.LoginActions(driver);

    }

    @And("User Should navigate to time and material page")
    public void userShouldNavigateToTimeAndMaterialPage()
    {
         homePaheobj.GoToTMPage(driver);
    }

    @When("Create a new time and material record {string} {string} {string}")
    public void createANewTimeAndMaterialRecord(String Code, String Description, String Price)
    {
        tmPageobj.CreateTimeRecord(driver, Code, Description, Price);
    }

    @Then("The record should be created successfully {string}")
    public void theRecordShouldBeCreatedSuccessfully(String Code)
    {
        tmPageobj.verifyCreatedRecord(driver, Code);
    }

    @When("Edit an existing time and material record {string} {string} {string}")
    public void editAnExistingTimeAndMaterialRecord(String UpdatedCode, String UpdatedDescription, String UpdatedPrice)
    {
        tmPageobj.EditTimeRecord(driver,UpdatedCode, UpdatedDescription, UpdatedPrice);
    }

    @Then("The record should be updated successfully {string}")
    public void theRecordShouldBeUpdatedSuccessfully(String UpdatedCode)
    {
        tmPageobj.verifyUpdatedRecord(driver, UpdatedCode);
    }

    @When("Delete an existing time and material record")
    public void deleteAnExistingTimeAndMaterialRecord()
    {
        tmPageobj.DeleteTimeRecord(driver);
    }

    @Then("The record should be deleted successfully {string}")
    public void theRecordShouldBeDeletedSuccessfully(String UpdatedCode)
    {
        tmPageobj.verifyDeletedRecord(driver, UpdatedCode);
    }
}
