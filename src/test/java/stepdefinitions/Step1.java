package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;


public class Step1 {
    HomePage homePage = new HomePage();


    @Given("user navigates to web page")
    public void user_navigates_to_web_page() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

    }

    @Given("verify the web page is opened")
    public void verify_the_web_page_is_opened() {
        String expectedTitle = "Protein Tech";
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println(actualTitle);
        Assert.assertTrue(expectedTitle.equals(actualTitle));
    }

    @Given("user should see {int} main tab section on the homepage")
    public void user_should_see_main_tab_section_on_the_homepage(Integer int1) {
        System.out.println("There are " + homePage.mainTabs.size() + " tab sections on home page");

        Assert.assertTrue(homePage.mainTabs.get(0).getText().equals("Our Technologies"));
        Assert.assertTrue(homePage.mainTabs.get(1).getText().equals("Who we Are?"));
        Assert.assertTrue(homePage.mainTabs.get(2).getText().equals("pॱ talks"));
        Assert.assertTrue(homePage.mainTabs.get(3).getText().equals("Say Hey"));


    }

    @Given("user clicks {string} tab")
    public void user_clicks_tab(String string) {
        Driver.waitAndClick(homePage.ourTechnologiesTab);
    }

    @Then("verify the relevant section is opened")
    public void verify_the_relevant_section_is_opened() {
        Assert.assertTrue(homePage.cloudBasedText.isDisplayed());
        Assert.assertTrue(homePage.OmnichannelText.isDisplayed());
        Assert.assertTrue(homePage.managementSystemText.isDisplayed());
        System.out.println(homePage.cloudBasedText.getText());

    }

    @When("user scroll down")
    public void user_scroll_down() {

        Driver.scrollDownByJS();
    }

    @Then("verify Open Roles section is present")
    public void verify_open_roles_section_is_present() {
        Assert.assertTrue(homePage.openRolesText.isDisplayed());
    }

    @Then("User verify that {string} position is under the Software Development section.")
    public void user_verify_that_position_is_under_the_software_development_section(String string) {
        WebElement element = Driver.getDriver().findElement(By.xpath("(//div[@class='OpenRules_RuleItem__ByGMz'])[1]//*[contains(text(), 'iOS Developer')]"));
        System.out.println(element.getText());
        if (element != null)
            System.out.println("PASS+ iOS Developer inside the Software Development section");
        else
            System.out.println("FAIL + iOS Developer isn't inside the Software Development section");
        Actions actions=new Actions(Driver.getDriver());

        actions.sendKeys(Keys.PAGE_UP).build().perform();

    }

    @Then("User clicks to {string} position")
    public void user_clicks_to_position(String string) throws InterruptedException {

        Thread.sleep(3);

        Driver.scrollToElement(Driver.getDriver().findElement(By.xpath("(//h2)[3]")));
        Driver.waitAndClick(homePage.iosLink);
        System.out.println(homePage.iosLink.getText());

    }

    @Then("verify the new tab is opened.")
    public void verify_the_new_tab_is_opened() {

        Driver.switchToWindow("Protel Bilgisayar A.Ş. iOS Developer (Remote) İş İlanı - Kariyer.net");
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Protel Bilgisayar A.Ş. iOS Developer (Remote) İş İlanı - Kariyer.net"));
        System.out.println(Driver.getDriver().getTitle());
    }


}
