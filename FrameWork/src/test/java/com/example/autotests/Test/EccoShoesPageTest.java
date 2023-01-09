package com.example.autotests.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.autotests.pages.EccoShoesPage;
import dev.failsafe.internal.util.Assert;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EccoShoesPageTest {
    private final EccoShoesPage eccoShoesPage = new EccoShoesPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());


    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        eccoShoesPage.openPage();
    }

    @Test
    public void Search() throws InterruptedException {
        sleep(10000);
        eccoShoesPage.SearchText(eccoShoesPage.SearchArea,"Обувь");
        sleep(8000);
        Assert.isTrue(eccoShoesPage.span.getText().equals("1008"),"Not found");
    }

    @Test
    public void AddItemInBasket() {
        eccoShoesPage.addShoesInBasket();
        Assert.isTrue(eccoShoesPage.resultBasket.getText().equals("Продолжить покупки"), "Header text is not equal to 'Вы добавили товар в корзину'");
    }
    @Test
    public void RemoveShoesFromBusket() {

        eccoShoesPage.removeShoesFromBasket();

        Assert.isTrue(eccoShoesPage.busketResult.getText().equals("Ваша корзина пуста"), "Header text is not equal to 'Вы добавили товар в корзину'");
    }

    @Test
    public void Favorite() {

        eccoShoesPage.addToFavorite();

        Assert.isTrue(!eccoShoesPage.favResult.getText().equals("Добавить в избранное"), "Header text is not equal to 'Вы добавили товар в корзину'");
    }
    @Test
    public void New() {

        eccoShoesPage.clickOnElement(eccoShoesPage.btnNew);

        Assert.isTrue(!eccoShoesPage.favResult.getText().equals("Добавить в избранное"), "Header text is not equal to 'Вы добавили товар в корзину'");
    }



}