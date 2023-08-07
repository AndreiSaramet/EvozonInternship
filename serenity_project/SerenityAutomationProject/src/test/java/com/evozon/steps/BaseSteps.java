package com.evozon.steps;

import com.evozon.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public abstract class BaseSteps extends ScenarioSteps {
    protected HomePage homePage;

    @Step
    public void navigateToHomepage() {
        this.homePage.open();
    }
}
