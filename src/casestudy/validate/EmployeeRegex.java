package casestudy.validate;

import java.time.LocalDate;
import java.time.Period;

public class EmployeeRegex {
    private static final String VALIDATE_REGEX_ID_EMPLOYEE = "^NV-[0-9]{4}$";

    private static final String VALIDATE_REGEX_NAME_EMPLOYEE = "^^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$$";

    private static final String VALIDATE_REGEX_DATE_EMPLOYEE = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";

    private static final String VALIDATE_REGEX_CODE_EMPLOYEE = "^([0-9]{12}|[0-9]{9})$";

    private static final String VALIDATE_REGEX_TELEPHONE_EMPLOYEE = "^0[0-9]{9}$";

    private static final String VALIDATE_REGEX_EMAIL_EMPLOYEE = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static boolean checkRegexIdEmployee(String idEmployee) {
        return idEmployee.matches(VALIDATE_REGEX_ID_EMPLOYEE) ? true : false;
    }

    public static boolean checkRegexNameEmployee(String nameEmployee) {
        return nameEmployee.matches(VALIDATE_REGEX_NAME_EMPLOYEE) ? true : false;
    }

    public static boolean checkOld(String dateEmployee){
        return dateEmployee.matches(VALIDATE_REGEX_DATE_EMPLOYEE) ? true : false;
    }

    public static boolean checkRegexOldEmployee(String dateEmployee) {
        if (checkOld(dateEmployee)) {
            LocalDate localDate = LocalDate.parse(dateEmployee);
            LocalDate localDateNow = LocalDate.now();
            return Period.between(localDate, localDateNow).getYears() >= 18;
        }
        return false;
    }

    public static boolean checkRegexCodeEmployee(String codeEmployee) {
        return codeEmployee.matches(VALIDATE_REGEX_CODE_EMPLOYEE) ? true : false;
    }

    public static boolean checkRegexTelephoneEmployee(String telephoneEmployee) {
        return telephoneEmployee.matches(VALIDATE_REGEX_TELEPHONE_EMPLOYEE) ? true : false;
    }

    public static boolean checkRegexEmailEmployee(String emailEmployee) {
        return emailEmployee.matches(VALIDATE_REGEX_EMAIL_EMPLOYEE) ? true : false;
    }
}

