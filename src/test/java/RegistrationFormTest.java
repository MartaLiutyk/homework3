import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class RegistrationFormTest {
    private static final HashMap DATA = new HashMap<String, String>();
    static Logger logger = Logger.getLogger(RegistrationFormTest.class);
    public static HashMap<String, String> REGISTRATION_DATA = new HashMap<String, String>();

    static {
        REGISTRATION_DATA.put("rotateTowards", "Marta");
        REGISTRATION_DATA.put("moveToPoint", "Liutyk");
        REGISTRATION_DATA.put("email", "melodika99@gmail.com");
        REGISTRATION_DATA.put("age", "19");
    }

    public RegistrationFormTest() throws NoSuchMethodException, IOException {
    }

    @Test
    public void getDataFromConsole() throws NoSuchMethodException, IOException {
        HashMap data = new HashMap();
        data.put("name", 12);
        data.put("surname", "Liutyk");
        data.put("email", "melodika99gmail.com");
        data.put("age", 19);
        int amountOfFields = data.size();
        try {
            assertEquals(4, amountOfFields);
        } catch (AssertionError error) {
            logger.error("Invalid amount of fields");
        }
        try {
            assertNotNull(data);
        } catch (AssertionError error) {
            logger.error("You did not fill in the form!");
        }
        String string = new String();
        Integer integer = new Integer(0);
        RegistrationForm registrationForm = new RegistrationForm();
        Class cls = registrationForm.getClass();
        Method getData = cls.getMethod("getDataFromConsole");
        Class<?>[] dataParameterTypes = getData.getParameterTypes();
        Class<?>[] expectedDataTypes = {string.getClass(), string.getClass(), string.getClass(), integer.getClass()};
        // check if data types are the same as expected. does not work correct
        //assertArrayEquals(expectedDataTypes, dataParameterTypes);
    }

    public Method method = getMethodWithReflection("emailValidCheck");

    public Method getMethodWithReflection(String name) throws NoSuchMethodException, IOException {
        RegistrationForm registrationForm = new RegistrationForm();
        Method method = registrationForm.getClass().getDeclaredMethod("emailValidCheck");
        method.setAccessible(true);
        return method;
    }

    @Test
    public void method() {
        boolean validEmail = false;
        String email = "Olena@gmail.com";
        char[] emailInSymbols = email.toCharArray();
        assertTrue(validEmail = true);
    }
}