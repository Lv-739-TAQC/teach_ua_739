package org.ssu.edu.teachua.utils.runners;

import org.ssu.edu.teachua.utils.EntityService;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class BaseTestRunnerAPI {
    protected static final TestValueProvider valueProvider = new TestValueProvider();

    protected SoftAssert softAssert = new SoftAssert();

    protected EntityService entityService = new EntityService();

    protected Random random = new Random();
}
