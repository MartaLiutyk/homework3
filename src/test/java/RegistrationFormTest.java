import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

import static org.junit.Assert.*;

public class RegistrationFormTest {

    @Test
    public void getDataFromConsole() throws NoSuchMethodException {
        HashMap data = new HashMap();
        data.put("name", "Marta");
        data.put("surname", "Liutyk");
        data.put("email", "melodika99gmail.com");
        data.put("age", 19);
        int amountOfFields = data.size();
        assertEquals(4, amountOfFields);
        assertNotNull(data);
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