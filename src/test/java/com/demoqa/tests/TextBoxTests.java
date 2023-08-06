package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {

        textBoxPage.openPage()
                .setFullName("John Doe")
                .setEmail("JDemail@testemail.de")
                .setCurrentAddress("331 Kianna Keys, Roymouth, West Virginia, US")
                .setPermanentAddress("31164 Stephon Ways, Scottsdale, Mississippi, US")
                .submit()

                .checkResults(new String[]{
                        "John Doe",
                        "JDemail@testemail.de",
                        "331 Kianna Keys, Roymouth, West Virginia, US",
                        "31164 Stephon Ways, Scottsdale, Mississippi, US"
                });


    }

}
