package org.ssu.edu.teachua.cucumber;

import io.cucumber.testng.*;
import org.ssu.edu.teachua.utils.Retry;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;


@CucumberOptions(features = "src/test/resources/features", glue = "org.ssu.edu.teachua.cucumber.steps")
public class TestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzerClass(Retry.class);
        }
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("setUpClass");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(description = "Example of BDD suite", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}
