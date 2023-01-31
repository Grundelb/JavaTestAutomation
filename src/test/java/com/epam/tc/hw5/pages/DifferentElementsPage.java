package com.epam.tc.hw5.pages;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
public class DifferentElementsPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(.,'Water')]/input")
    private WebElement waterCheckbox;
    @FindBy(xpath = "//*[contains(.,'Wind')]/input")
    private WebElement windCheckbox;
    @FindBy(xpath = "//*[contains(.,'Selen')]/input")
    private WebElement selenRadioButton;
    @FindBy(className = "colors")
    private WebElement colorsDropDownMenu;
    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowOptionColors;
    @FindBy(xpath = "//li[contains(.,'Water: condition changed to true')]")
    private WebElement containWaterLog;
    @FindBy(xpath = "//li[contains(.,'Wind: condition changed to true')]")
    private WebElement containWindLog;
    @FindBy(xpath = "//li[contains(.,'metal: value changed to  Selen')]")
    private WebElement containSelenLog;
    @FindBy(xpath = "//li[contains(.,'Colors: value changed to Yellow')]")
    private WebElement containYellowLog;
    @FindBy(xpath = "//ul[@class='panel-body-list logs']")
    private WebElement logsPanelList;

    public DifferentElementsPage() {
    }

    public void clickOnCheckbox(String string) {
        if (string.equals("Water")) {
            waterCheckbox.click();
        }
        if (string.equals("Wind")) {
            windCheckbox.click();
        }
    }

    public WebElement getCheckbox(String string) {
        WebElement checkbox = null;
        if (string.equals("Water")) {
            checkbox = getWaterCheckbox();
        } else if (string.equals("Wind")) {
            checkbox = getWindCheckbox();
        }
        return checkbox;
    }

    public void clickOnRadioButton(String string) {
        if (string.equals("Selen")) {
            selenRadioButton.click();
        }
    }

    public void clickOnColorsDropDownMenu() {
        colorsDropDownMenu.click();
    }

    public void clickOnOptionColors(String string) {
        if (string.equals("Yellow")) {
            yellowOptionColors.click();
        }
    }

    public List<WebElement> verifyLogs() {
        List<WebElement> list = new ArrayList<>();
        list.add(containSelenLog);
        list.add(containWaterLog);
        list.add(containWindLog);
        list.add(containYellowLog);
        return list;
    }
}