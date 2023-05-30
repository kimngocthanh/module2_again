package casestudy.validate;


import java.time.LocalDate;
import java.time.Period;

public class CustomerRegex {
    private static final String VALIDATE_REGEX_ID_CUSTOMER = "^KH-[0-9]{4}$";

    private static final String VALIDATE_REGEX_NAME_CUSTOMER = "^^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$$";

    private static final String VALIDATE_REGEX_DATE_CUSTOMER = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";

    private static final String VALIDATE_REGEX_CODE_CUSTOMER = "^([0-9]{12}|[0-9]{9})$";

    private static final String VALIDATE_REGEX_TELEPHONE_CUSTOMER = "^0[0-9]{9}$";

    private static final String VALIDATE_REGEX_EMAIL_CUSTOMER = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static boolean checkRegexIdCustomer(String idCustomer) {
        return idCustomer.matches(VALIDATE_REGEX_ID_CUSTOMER) ? true : false;
    }

    public static boolean checkRegexNameCustomer(String nameCustomer) {
        return nameCustomer.matches(VALIDATE_REGEX_NAME_CUSTOMER) ? true : false;
    }

    public static boolean checkOld(String dateCustomer){
        return dateCustomer.matches(VALIDATE_REGEX_DATE_CUSTOMER) ? true : false;
    }

    public static boolean checkRegexOldCustomer(String dateCustomer) {
        if (checkOld(dateCustomer)) {
            LocalDate localDate = LocalDate.parse(dateCustomer);
            LocalDate localDateNow = LocalDate.now();
            return Period.between(localDate, localDateNow).getYears() >= 18;
        }
        return false;
    }

    public static boolean checkRegexCodeCusTomer(String codeCustomer) {
        return codeCustomer.matches(VALIDATE_REGEX_CODE_CUSTOMER) ? true : false;
    }

    public static boolean checkRegexTelephoneCustomer(String telephoneCustomer) {
        return telephoneCustomer.matches(VALIDATE_REGEX_TELEPHONE_CUSTOMER) ? true : false;
    }

    public static boolean checkRegexEmailCustomer(String emailCustomer) {
        return emailCustomer.matches(VALIDATE_REGEX_EMAIL_CUSTOMER) ? true : false;
    }
}
