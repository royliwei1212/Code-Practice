package tech.saltyegg.code;

import org.junit.Test;

public class PhoneNumberFormat {

    private void reformat(String[] phoneNumbers) {
        if (phoneNumbers == null || phoneNumbers.length == 0) return;
        for (int i = 0; i < phoneNumbers.length; i++) {
            String p = phoneNumbers[i];
            phoneNumbers[i] = format(p);
        }

//        for (int i = 0; i < phoneNumbers.length; i++) {
//            System.out.println(phoneNumbers[i]);
//        }

    }

    private boolean isValid(String s) {
        return s != null && (s.length() == 10 || s.length() == 12);
    }

    private String format(String s) {
        if (!isValid(s)) {
            return null;
        }
        if (s.length() == 10) {
            return s.substring(3, 6) + "-" + s.substring(0, 3) + "-" + s.substring(6);
        }

        return s.substring(4, 7) + "-" + s.substring(0, 3) + "-" + s.substring(8);
    }

    @Test
    public void test(){
        reformat(new String[]{"BBBGGGRRRR", "BBB-GGG-RRRR"});
    }
}
