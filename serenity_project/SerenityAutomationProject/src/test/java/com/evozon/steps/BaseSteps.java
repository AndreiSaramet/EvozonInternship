package com.evozon.steps;

import com.evozon.pages.*;
import net.thucydides.core.steps.ScenarioSteps;

public abstract class BaseSteps extends ScenarioSteps {
    protected HomePage homePage;
    protected HeaderPage headerPage;
    protected ProductsGridPage productsGridPage;
    protected CartPage cartPage;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected RegisterPage registerPage;
}
