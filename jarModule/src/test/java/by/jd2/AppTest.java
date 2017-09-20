package by.jd2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static by.jd2.App.getTypeString;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void getTypeStringTest() {
        assertAll("patternTest",
                () -> assertEquals(getTypeString("alexey.work@tut.by"), StringType.EMAIL),
                () -> assertEquals(getTypeString("624-75-17"), StringType.PHONE),
                () -> assertEquals(getTypeString("6247516"), StringType.NONE),
                () -> assertEquals(getTypeString("Смирнов"), StringType.FAMILY),
                () -> assertEquals(getTypeString("Третьякова-Сотникова"), StringType.FAMILY),
                () -> assertEquals(getTypeString("3270377A043PB8"), StringType.INSURANCE),
                () -> assertEquals(getTypeString("Я помню чужное мгновенье"), StringType.NONE)
                );
    }
}
