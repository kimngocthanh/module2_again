package test;

public class Test1 {
    public static void main(String[] args) {
        String s = "CodegymDaNang";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringBuilder.length(); i++) {
            Character c = stringBuilder.charAt(i);
            if(Character.isUpperCase(c)){
                stringBuilder.append(" ");
            }
        }
        System.out.println(stringBuilder);
    }
}
