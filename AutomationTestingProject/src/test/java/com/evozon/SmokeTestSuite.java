package com.evozon;

import com.evozon.test.CartTest;
import com.evozon.test.CheckoutTest;
import com.evozon.test.LoginTest;
import com.evozon.test.RegisterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({RegisterTest.class, LoginTest.class, CartTest.class, CheckoutTest.class})
public class SmokeTestSuite {
}
