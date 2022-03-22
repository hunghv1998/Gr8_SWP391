/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chinh
 */
public class ValidatingInput {

    public boolean isName(String name) {
        // Regex to check valid name
        String regex = "^[\\p{L} .'-]+$";

        // Compile the regex
        Pattern p = Pattern.compile(regex);

        // If name null
        // Return false
        if (name == null) {
            return false;
        }
        // Using matcher() method to tfind matching between
        // given name and regular expression
        Matcher m = p.matcher(name);

        // Return if the name matched the regex rule
        return m.matches();
    }

    public boolean isUsername(String username) {
        // Regex to check valid username
        String regex = "^[A-Za-z]\\w{5,29}$";

        // Compile the regex
        Pattern p = Pattern.compile(regex);

        // If username null
        // Return false
        if (username == null) {
            return false;
        }

        // Using matcher() method to find matching between
        // given username and regular expression
        Matcher m = p.matcher(username);

        // Return if the username matched the regex rule
        return m.matches();
    }

    public boolean isPhoneNumber(String phone) {
        //(0/91): number start with (0/91)
        // [7-9]: starting of the number may contain a digit between 0 and 9
        // [0-9]: then contains digits 0 to 9
        Pattern pattern = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");

        // If username null
        // Return false
        if (phone == null) {
            return false;
        }

        // The matcher*( method creates a matcher that 
        // will match the given input against this pattern
        Matcher match = pattern.matcher(phone);

        return (match.find() && match.group().equals(phone));
    }

    public boolean isEmail(String email) {
        // Regex to check valid username
        String regex = "^(.+)@(\\S+)$";

        // Compile the regex
        Pattern p = Pattern.compile(regex);

        // Using matcher() method to find matching between
        // given username and regular expression
        Matcher m = p.matcher(email);

        // Return if the username matched the regex rule
        return m.matches();
    }

    public int CalculateBirthday(Date date) {
        // Compare birthday to current date
        if (ChronoUnit.MONTHS.between(date.toLocalDate(), LocalDate.now()) <= 3) {
            return 1;
        } else {
            if (ChronoUnit.YEARS.between(date.toLocalDate(), LocalDate.now()) < 50) {
                return 2;
            } else {
                if (ChronoUnit.YEARS.between(date.toLocalDate(), LocalDate.now()) < 64) {
                    return 3;
                }
            }
        }
        return 4;
    }

    public boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
