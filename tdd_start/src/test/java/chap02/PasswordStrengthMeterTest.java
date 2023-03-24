package test.java.chap02;

import main.chap02.PasswordStrength;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }


    @Test
    @DisplayName("첫 번째 테스트 : 모든 규칙을 충족하는 경우")
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    @DisplayName("두 번째 테스트 : 길이만 8글자 미만이고 나머지 조건은 충족하는 경우")
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12@A", PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("세 번째 테스트 : 숫자를 포함하지 않고 나머지 조건은 충족하는 경우")
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("네 번째 테스트 : 값이 없는 경우 (null)")
    void nullInput_Then_Invalid() {
        assertStrength(null , PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("네 번째 테스트 : 값이 없는 경우 (empty)")
    void empthInput_Then_Invalid() {
        assertStrength("" , PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("네 번째 테스트 : 대문자를 포함하지 않고 나머지 조건을 충족하는 경우")
    void meetsOtherCriteria_except_for_Uppercase_Then_NOrmal(){
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }
}
