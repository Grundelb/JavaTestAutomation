package com.epam.tc.hw4.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuPage extends AbstractPage {

    @FindBy(partialLinkText = "Home")
    private WebElement homeLeftMenu;
    @FindBy(partialLinkText = "Contact form")
    private WebElement contactFormLeftMenu;
    @FindBy(partialLinkText = "Service")
    private WebElement serviceLeftMenu;
    @FindBy(partialLinkText = "Metals & Colors")
    private WebElement metalAndColorsLeftMenu;
    @FindBy(partialLinkText = "Elements packs")
    private WebElement elementsPacksLeftMenu;

    public LeftMenuPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> verifyLeftMenu() {
        List<WebElement> webElementList = new ArrayList<>();
        webElementList.add(homeLeftMenu);
        webElementList.add(serviceLeftMenu);
        webElementList.add(metalAndColorsLeftMenu);
        webElementList.add(contactFormLeftMenu);
        webElementList.add(elementsPacksLeftMenu);
        return webElementList;
    }

}
