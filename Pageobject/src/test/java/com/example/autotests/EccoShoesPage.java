package com.example.autotests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class EccoShoesPage {

    public final String URL = "https://www.ecco-shoes.by/";

    public final SelenideElement span = $x("//*[@class='red']");
    public final SelenideElement SearchArea = $x("//*[@id='search']");
    public final SelenideElement size = $x("//li[@data-size='36']");
    public final SelenideElement ShoesLink = $x("//a[@title='Полусапоги ECCO SOLICE']");
    public final SelenideElement resultBasket = $x("//a[@class='btn-wrap-item green close']");

    public final SelenideElement MainPage  = $x("//img[@class='logo']");
    public final SelenideElement addInBasketBtn = $x("//div[@class='buybtn main show-ipopap']");

    public void clickOnElement(SelenideElement element){
        element.click();
    }

    public void setValueOnInput(SelenideElement inputElement,String Value){
        inputElement.setValue(Value);
    }

    public void PressSearchButton(SelenideElement element){
        element.sendKeys(Keys.ENTER);
    }

    public void hoverOnElement(SelenideElement element) {
        element.hover();
    }

    public void SearchText(SelenideElement inputElement,String Value) throws InterruptedException {
        setValueOnInput(SearchArea,Value);
        PressSearchButton(SearchArea);

    }

    public void addShoesInBasket(){
        goToMainPage();
        sleep(2000);
        clickOnElement(ShoesLink);
        sleep(2000);
        clickOnElement(size);
        sleep(1000);
        clickOnElement(addInBasketBtn);
        sleep(8000);
    }

    public void goToMainPage() {
        clickOnElement(MainPage);
    }

    public void openPage() {
        open(URL);
    }
}
