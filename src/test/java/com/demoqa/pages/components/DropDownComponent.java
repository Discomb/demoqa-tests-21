package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class DropDownComponent {

    public void setValue(SelenideElement element, String value){

        element.click();
        element.$(byText(value)).click();

    }

}
