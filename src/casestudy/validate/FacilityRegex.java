package casestudy.validate;

public class FacilityRegex {
    private static final String VALIDATE_REGEX_ID_VILLA = "^VI-[0-9]{4}$";

    private static final String VALIDATE_REGEX_ID_ROOM = "^RO-[0-9]{4}$";

    private static final String VALIDATE_REGEX_ID_HOUSE = "^HO-[0-9]{4}$";

    private static final String VALIDATE_REGEX_NAME_FACILITY = "^^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}]" +
            "[\\p{Ll}]{1,10})){0,5}$$";

    public static boolean checkIdVillaRegex(String idVilla) {
        return idVilla.matches(VALIDATE_REGEX_ID_VILLA) ? true : false;
    }

    public static boolean checkIdHouseRegex(String idHouse) {
        return idHouse.matches(VALIDATE_REGEX_ID_HOUSE) ? true : false;
    }

    public static boolean checkIdRoomRegex(String idRoom) {
        return idRoom.matches(VALIDATE_REGEX_ID_ROOM) ? true : false;
    }

    public static boolean checkNameFacility(String name) {
        return name.matches(VALIDATE_REGEX_NAME_FACILITY) ? true : false;
    }
}
