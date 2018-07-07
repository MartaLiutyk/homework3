import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RegistrationForm {

    public RegistrationForm() {
    }

    public static HashMap getDataFromConsole() throws IOException {
        HashMap usersData = new HashMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
        String name = br.readLine();
        usersData.put("name", name);
        System.out.print("Enter your surname: ");
        String surname = br.readLine();
        usersData.put("surname", surname);
        System.out.print("Enter your email: ");
        String email = br.readLine();
        usersData.put("email", email);
        System.out.print("Enter your age: ");
        try {
            Integer age = Integer.parseInt(br.readLine());
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

    private static boolean emailValidCheck(HashMap info) {
        String email = info.get("email").toString();
        char[] emailInSymbols = email.toCharArray();
        int dogCheck = 0;
        boolean validEmail = true;
        for (int i = 0; i < emailInSymbols.length; i++) {
            if (emailInSymbols[i] == '@') {
                dogCheck++;
            }
        }
        if (dogCheck != 1) {
            validEmail = false;
            System.err.println("Invalid email!");
        }
        return validEmail;
    }

    private static boolean ageValidCheck(HashMap info) {
        Integer age = (Integer) info.get("age");
        boolean validAge = true;
        if (age < 18) {
            System.err.println("Come back in  a few years :) ");
            validAge = false;
        } else if (age > 99) {
            System.err.println("Are you sure that you want to spend last minutes of life in InteliJ ?");
            validAge = false;
        }
        return validAge;
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
