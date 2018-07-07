import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RegistrationForm {

    private static HashMap getDataFromConsole() throws IOException {
        HashMap usersData = new HashMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
        usersData.put("name", br.readLine());
        System.out.print("Enter your surname: ");
        usersData.put("surname", br.readLine());
        System.out.print("Enter your email: ");
        usersData.put("email", br.readLine());
        System.out.print("Enter your age: ");
        try {
            int age = Integer.parseInt(br.readLine());
            usersData.put("age", age);
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        return usersData;
    }

    private static String nameValidCheck(HashMap info, String key) {
        String name = info.get(key).toString();
        String[] nameInLetters = name.split("\\a");
        nameInLetters[0].toUpperCase();
        for (int i = 1; i < nameInLetters.length; i++) {
            nameInLetters[i].toLowerCase();
        }
        return nameInLetters.toString();
    }

    private static void emailValidCheck(HashMap info) {
        String email = info.get("email").toString();
        char[] emailInSymbols = email.toCharArray();
        int dogCheck = 0;
        for (int i = 0; i < emailInSymbols.length; i++) {
            if (emailInSymbols[i] == '@') {
                dogCheck++;
            }
        }
        if (dogCheck != 1){
            System.err.println("Invalid email!");
        }
    }

    private static void ageValidCheck(HashMap info) {
        int age = (Integer)info.get("age");
        if (age < 18 ){
            System.err.println("Come back in  a few years :) ");
        }
        else if (age > 99){
            System.err.println("Are you sure that you want to spend last minutes of life in InteliJ ?");
        }
    }

    public static void main(String[] args) throws IOException {
        HashMap usersInformation = getDataFromConsole();
        nameValidCheck(usersInformation, "name");
        nameValidCheck(usersInformation, "surname");
        emailValidCheck(usersInformation);
        ageValidCheck(usersInformation);
        System.out.println(usersInformation);
    }

}
