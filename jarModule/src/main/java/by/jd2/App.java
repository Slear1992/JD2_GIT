package by.jd2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.jd2.StringType.*;

enum StringType {
    NONE, PHONE, EMAIL, FAMILY, INSURANCE
}
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    private static final String PHONE_PATTERN =
            "\\d{3}-\\d{2}-\\d{2}";
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String FAMILY_PATTERN =
            "[А-Я][а-яА-Я]*(-[А-Я][а-яА-Я]*)?";
    private static final String INSURANCE_PATTERN =
            "\\d{7}[A-Z]\\d{3}[A-Z]{2}\\d";

    public static StringType getTypeString(String inputString) {
        Pattern patternPhone = Pattern.compile(PHONE_PATTERN);
        Pattern patternEmail = Pattern.compile(EMAIL_PATTERN);
        Pattern patternFamily = Pattern.compile(FAMILY_PATTERN);
        Pattern patternInsurance = Pattern.compile(INSURANCE_PATTERN);
        Matcher matcher = patternPhone.matcher(inputString);
        if (matcher.matches()) return PHONE;
        else {
            matcher = patternEmail.matcher(inputString);
            if (matcher.matches()) return EMAIL;
            else {
                matcher = patternFamily.matcher(inputString);
                if (matcher.matches()) return FAMILY;
                else {
                    matcher = patternInsurance.matcher(inputString);
                    if (matcher.matches()) return INSURANCE;
                }
            }
        }
        return NONE;
    }

}
