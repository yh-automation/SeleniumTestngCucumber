/**
 * @author rahul.rathore
 * <p>
 * 14-Aug-2016
 */
package com.cucumber.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:featurefile/Search.feature"},
        glue = {"classpath:com.cucumber.framework.stepdefinition",
                "classpath:com.cucumber.framework.helper"},
        plugin = {"pretty",
                "json:target/SearchFeatureRunner.json"})
public class SearchFeatureRunner extends AbstractTestNGCucumberTests {
}
