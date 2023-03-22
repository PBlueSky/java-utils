package utils;

/*
 ** @Author:         blue_sky
 ** @CreateDate:     2023-03-21  15:47
 ** @ProjectName:    java-utils
 ** @Package:        utils
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

public class DateTimeUtilsTest {
    @Test
    public void testGetCurrentDateTime(){
        LocalDateTime now = DateTimeUtils.getNowDateTime();
        System.out.println(now);
    }

    @Test
    public void testGetTimeStamp(){
        System.out.println(DateTimeUtils.getTimeStampWithSecond());
    }

    /**
     * 将一个时区时间转换为另一个时区时间
     * 地区：加拿大 温哥华 Vancouver
     * 时区：UTC/GMT -8.00 (西八区)
     * 当前世界时间(GMT):2023-03-21 08:34:06
     * 当前北京时间:2023-03-21 16:34:06
     */
    @Test
    public void testZoneTimeStrToOtherZoneTimeStr(){
        String dateTimeStr = "2023-03-21 08:34:06";
        Long timeStamp = DateTimeUtils.strToTimeStamp(dateTimeStr, DateTimeUtils.FORMATTER_FULL, ZoneId.of("-8"), TimeUnit.MILLISECONDS);
        LocalDateTime localDateTime = DateTimeUtils.timeStampToZoneTime(timeStamp, ZoneId.of("+8"),TimeUnit.MILLISECONDS);
        Assertions.assertEquals("2023-03-21T16:34:06",localDateTime.toString());
    }


    @Test
    public void testZoneTimeToOtherZoneTime(){
        // UTC to Local time
        LocalDateTime UTC = DateTimeUtils.getNowDateTime(ZoneId.of("Z"));
        LocalDateTime localDateTime = DateTimeUtils.ZoneTimeToOtherZoneTime(UTC, ZoneId.of("+8"));
        System.out.println(localDateTime);
    }
}
