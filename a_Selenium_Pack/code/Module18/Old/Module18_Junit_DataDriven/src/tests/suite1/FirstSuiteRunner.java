package tests.suite1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;




@RunWith(Suite.class)
@SuiteClasses({
RegistrationTest.class,
LoginTest.class,
QuikrLinkTest.class,
PasswordChangeTest.class,
PostAddTest.class
})
public class FirstSuiteRunner {

}
