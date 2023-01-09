package com.example.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import static com.codeborne.selenide.Selenide.*;

public class EccoShoesPage {


    public final String URL = "https://www.ecco-shoes.by/";

    public final SelenideElement span = $x("//*[@class='red']");
    public final SelenideElement SearchArea = $x("//*[@id='search']");
    public final SelenideElement size = $x("//li[@data-size='36']");
    public final SelenideElement ShoesLink = $x("//a[@title='Полусапоги ECCO SOLICE']");
    public final SelenideElement resultBasket = $x("//a[@class='btn-wrap-item green close']");

    public final SelenideElement busketBtn =$x("//a[@href='/cart/']");
    public final SelenideElement removeButton = $x("//div[@class='delete']");
    public final SelenideElement busketResult = $x("//div[@class='checkout-basket-empty']");

    public final SelenideElement MainPage  = $x("//img[@class='logo']");
    public final SelenideElement addInBasketBtn = $x("//div[@class='buybtn main show-ipopap']");
    public final SelenideElement favBtn = $x("//span[@class='favourite']");
    public final SelenideElement favResult = $x("//span[@class='favourite selected']");
    public final SelenideElement btnNew = $x("//a[@href=' https://www.ecco-shoes.by/promo/aw22/newcollection/']");



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
       // goToMainPage();

        sleep(5000);
        clickOnElement(ShoesLink);
        sleep(4000);
        clickOnElement(size);
        sleep(5000);
        clickOnElement(addInBasketBtn);
        sleep(8000);

    }

    public void goToMainPage() {
        clickOnElement(MainPage);
    }

    public void removeShoesFromBasket(){
        goToMainPage();

        sleep(2000);
        clickOnElement(busketBtn);
        sleep(2000);
        clickOnElement(removeButton);
        sleep(8000);
        clickOnElement(busketBtn);
        sleep(8000);

    }
    public void addToFavorite(){

        goToMainPage();
        sleep(5000);
        clickOnElement(ShoesLink);

        sleep(3000);
        clickOnElement(favBtn);
        sleep(8000);
    }

    public void openPage() {
        open(URL);
    }


}