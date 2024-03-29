package com.epam.tc.hw3.test;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HeaderMenuPage;
import com.epam.tc.hw3.pages.MainPage;
import java.util.Iterator;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestDifferentElementsPage extends AbstractTest {

    MainPage mainPage;
    HeaderMenuPage headerMenuPage;
    DifferentElementsPage differentElementsPage;

    @Test(priority = 1, dataProviderClass = DataProviderTest.class, dataProvider = "browserTitleCorrectData")
    public void verifyBrowserTitle(String result) {
        mainPage = new MainPage(driver);
        mainPage.openPage();
        String actualTitle = mainPage.getBrowserTitle();
        Assertions.assertThat(actualTitle).isEqualTo(result);
    }

    @Test(priority = 2, description = "Assert Username is loggined", dataProviderClass = DataProviderTest.class,
            dataProvider = "userNameCorrectData")
    public void verifyUserName(String result) {
        headerMenuPage = new HeaderMenuPage(driver);
        headerMenuPage.login();
        String actualUserName = headerMenuPage.getUserNameHeaderView();
        Assertions.assertThat(actualUserName).isEqualTo(result);
    }

    @Test(priority = 3, description = "Assert that"
            + "• for each checkbox there is an individual log row and value is corresponded to the status of checkbox"
            + "• for radio button there is a log row and value is corresponded to the status of radio button"
            + "• for dropdown there is a log row and value is corresponded to the selected value.")
    public void verifyDifferentElementsPage() {
        headerMenuPage = new HeaderMenuPage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        softly = new SoftAssertions();
        headerMenuPage.openDifferentElementsPage();
        differentElementsPage.setupDifferentElementPage();
        Iterator<WebElement> webElementIterator = differentElementsPage.verifyLogs().iterator();
        while (webElementIterator.hasNext()) {
            softly.assertThat(webElementIterator.next().isDisplayed());
        }
        softly.assertAll();
    }

}
