package api.runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/api")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "api.stepdefinitions"
)
public class ApiRunner {
}