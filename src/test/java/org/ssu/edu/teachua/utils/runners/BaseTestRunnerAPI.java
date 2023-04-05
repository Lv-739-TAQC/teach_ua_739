package org.ssu.edu.teachua.utils.runners;

import org.ssu.edu.teachua.utils.EntityService;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTestRunnerAPI {

    protected static final TestValueProvider valueProvider = new TestValueProvider();
    protected SoftAssert softAssert;
    protected EntityService entityService = new EntityService();

    @BeforeMethod
    public void initSoftAssert() {
        softAssert = new SoftAssert();
    }

}
