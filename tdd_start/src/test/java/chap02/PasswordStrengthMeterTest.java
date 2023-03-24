package test.java.chap02;

import main.chap02.PasswordStrength;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

    @Test
    @DisplayName("첫 번째 테스트 : 모든 규칙을 충족하는 경우")
    void meetsAllCriteria_Then_Strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12@AB");
        Assertions.assertEquals(PasswordStrength.STRONG, result);
        PasswordStrength result2 = meter.meter("abc!Add");
        Assertions.assertEquals(PasswordStrength.STRONG, result2);
    }

    @Test
    @DisplayName("첫 번째 테스트 : 모든 규칙을 충족하는 경우")
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12@A");
        Assertions.assertEquals(PasswordStrength.NORMAL, result);
        PasswordStrength result2 = meter.meter("Ab12!c");
        Assertions.assertEquals(PasswordStrength.NORMAL, result2);
    }
}
