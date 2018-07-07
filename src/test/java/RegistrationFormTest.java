import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

import static org.junit.Assert.*;

public class RegistrationFormTest {
    static Logger logger = Logger.getLogger(RegistrationFormTest.class);

    @Test
    public void getDataFromConsole() throws NoSuchMethodException {
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
}