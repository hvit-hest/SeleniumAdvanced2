package org.courses.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    private String adminPageUrl = "http://localhost/litecart/admin/";
    private WebDriver driverHere;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement loginButton;

    @FindBy(css = "[title='Logout'] i")
    private WebElement logoutButton;


    public AdminPage(WebDriver driver) {
        driverHere = driver;
        PageFactory.initElements(driverHere, this);
    }

    public void open() {
        driverHere.navigate().to(adminPageUrl);
        driverHere.manage().window().maximize();
    }

    public boolean isAdminPageOpen() {
        return driverHere.findElements(By.cssSelector("[title='Logout'] i")).size() != 0;
    }

    public boolean isLoginFormOpen() {
        return driverHere.findElements(By.xpath("//input[@name='password']")).size() != 0;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void login(String accountName, String accountPwd) {

        inputName.click();
        inputName.sendKeys(accountName);

        inputPassword.click();
        inputPassword.sendKeys(accountPwd);

        clickLoginButton();
    }

    public void logout() {
        clickLogoutButton();
    }
}

