package test.java.chap02;

import main.chap02.PasswordStrength;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;

        int metCounts = getMetCriteriCounts(s);

        /*
        *  코드 정리 : 가독성 개선
        *
        if(s.length() >= 8) metCounts++;
        if(meetsContainingNumberCriteria(s)) metCounts++;
        if(meetsContainingUppercaseCriteria(s)) metCounts++;
         */

        /*
        *   코드 정리 : meter() 메서드 리팩토링
        *
        boolean lengthEnough = s.length() >= 8;
        if(lengthEnough) metCounts++;
        boolean containsNum = meetsContainingNumberCriteria(s);
        if(containsNum) metCounts++;
        boolean containsUpp = meetsContainingUppercaseCriteria(s);
        if(containsUpp) metCounts++;
         */

        /*
        *   코드 정리 : meter() 메서드 리팩토링
        *
        if(lengthEnough && !containsNum && !containsUpp)
            return PasswordStrength.WEAK;
        if(!lengthEnough && containsNum && !containsUpp)
            return PasswordStrength.WEAK;
        if(!lengthEnough && !containsNum && containsUpp)
            return PasswordStrength.WEAK;
         */

        if (metCounts <= 1) return PasswordStrength.WEAK;
        if (metCounts == 2) return PasswordStrength.NORMAL;

        /*
        if(!lengthEnough){
            return PasswordStrength.NORMAL;
        }
        if (!containsNum) return PasswordStrength.NORMAL;
        if (!containsUpp) return PasswordStrength.NORMAL;
        */

        return PasswordStrength.STRONG;
    }

    private int getMetCriteriCounts(String s) {
        int metCounts = 0;
        if(s.length() >= 8) metCounts++;
        if(meetsContainingNumberCriteria(s)) metCounts++;
        if(meetsContainingUppercaseCriteria(s)) metCounts++;
        return metCounts;

    }

    private boolean meetsContainingNumberCriteria(String s){
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
}
