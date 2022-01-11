package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindAll({
            @FindBy(xpath = "//a[@class='Link Link-medium']")
    })
    public List<WebElement> mainTabs;

    @FindBy(xpath = "//a[text()='Our Technologies']")
    public WebElement ourTechnologiesTab;

    @FindBy(xpath = "//h2[text()='Cloud-based restaurant management system']")
    public WebElement cloudBasedText;

    @FindBy(xpath = "//h2[text()='Omnichannel sales and loyalty platform']")
    public WebElement OmnichannelText;

    @FindBy(xpath = "//h2[text()='GUEST WELCOMING & TABLE MANAGEMENT SYSTEM']")
    public WebElement managementSystemText;
    @FindBy(xpath = "//b[text()='Open roles']")
    public WebElement openRolesText;

    @FindBy(xpath = "//b[text()='Software Development']")
    public WebElement softwareDevelopment;

    @FindBy(linkText = "iOS Developer")
    public WebElement iosLink;

    @FindBy(className = "OpenRules_ContentTitle__37eLL")
    public WebElement openRoles;

}
