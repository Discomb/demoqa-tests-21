package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DropDownComponent {

    SelenideElement dropdown = $("#stateCity-wrapper");

    public void setValue(String selector, String value) {

        dropdown.$(selector).click();
        dropdown.$(selector).$(byText(value)).click();

    }

}
