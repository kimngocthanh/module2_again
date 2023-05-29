package casestudy.validate;


public class CustomerRegex {
    private static final String VALIDATE_REGEX_ID_CUSTOMER = "^KH-[0-9]{4}$";
    

    public static boolean checkRegexIdCustomer(String idCustomer) {
        return idCustomer.matches(VALIDATE_REGEX_ID_CUSTOMER) ? true : false;
    }


}
