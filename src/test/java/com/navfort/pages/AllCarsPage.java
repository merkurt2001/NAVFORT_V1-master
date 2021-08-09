package com.navfort.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

    public class AllCarsPage extends BasePage {

        @FindBy(xpath ="//a[@title='Create Car']" )
        public WebElement createCarButton;

//        @FindBy(linkText = "//a[@title=\"Car - Entities - System - Car - Entities - System\"]")
//        public WebElement favPageTitle;

    }
