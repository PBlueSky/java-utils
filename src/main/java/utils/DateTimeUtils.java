package utils;

/*
 ** @Author:         blue_sky
 ** @CreateDate:     2023-03-21  15:41
 ** @ProjectName:    java-utils
 ** @Package:        utils
 */

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DateTimeUtils {
    public static final String FORMATTER_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_STR = "yyyy-MM-dd";


    /**
     * 获取中国当前标准日期时间
     * @return 当前日期时间
     */
    public static LocalDateTime  getCurrentDateTime(){
        return getCurrentDateTime(ZoneId.of("Asia/Shanghai"));
    }

    /**根据时区获取当前日期时间
     * @param zoneId 时区
     * @return 当前日期时间
     */
    public static LocalDateTime  getCurrentDateTime(ZoneId zoneId){
        return LocalDateTime.now(zoneId);
    }

    /**获取当前UTC时间戳 从1970:01:01 00:00:00（1970-01-01T00:00:00Z） 到当前时刻的毫秒数
     * @return 时间戳
     */
    public static Long  getTimeStamp(){
        return Instant.now().toEpochMilli();
    }

    /**
     * 将字符串转成 当前时间
     * @param dateTimeStr 时间
     * @param dataFormatterStr 时间字符串格式
     * @return LocalDateTime
     */
    public static LocalDateTime strToLocalDateTime(String dateTimeStr,String dataFormatterStr) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(dataFormatterStr);
        return LocalDateTime.parse(dateTimeStr, df);
    }

    /**
     * 将字符串转成当前时区时间
     * @param dateTimeStr 时间
     * @param dataFormatterStr 时间字符串格式
     * @param zoneId 时区
     * @return LocalDateTime
     */
    public static LocalDateTime strToLocalZoneDateTime(String dateTimeStr,String dataFormatterStr,ZoneId zoneId) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(dataFormatterStr).withZone(zoneId);
        return LocalDateTime.parse(dateTimeStr, df);
    }

    /**
     * 将指定时区的日期时间字符串转换成UTC时间戳
     * @param dateTimeStr  满足dataFormatterStr格式的日期时间字符串
     * @param dataFormatterStr 日期时间格式
     * @param zoneId 时区
     * @return UTC时间戳
     */
    public static Long zoneStrToTimeStamp(String dateTimeStr,String dataFormatterStr,ZoneId zoneId) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(dataFormatterStr).withZone(zoneId);
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, df);
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    /**
     * 将UTC时间戳转换为指定的时区时间
     * @param timeStamp 时间戳
     * @param zoneId 时区
     * @return 时区时间
     */
    public static LocalDateTime timeStampToZoneTime(Long timeStamp,ZoneId zoneId) {
        Instant instant = Instant.ofEpochMilli(timeStamp);
        return LocalDateTime.ofInstant(instant,zoneId);
    }

    /**
     * 将一个时区的时间转换为另一个时区的时间
     * @param from 源时区时间
     * @param otherZoneId  另一个时区
     * @return 一个时区的时间
     */
    public static LocalDateTime ZoneTimeToOtherZoneTime(LocalDateTime from,ZoneId otherZoneId){
        long timeStamp = from.toInstant(ZoneOffset.UTC).toEpochMilli();
        return timeStampToZoneTime(timeStamp,otherZoneId);
    }

    /**
     * date 转成 LocalDateTime
     * @param date 日期
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * date 转成 LocalDate
     * @param date 日期
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /**
     * date 转成 LocalTime
     * @param date 日期
     */
    public static LocalTime dateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalTime();
    }

    /**
     * LocalDateTime 转成 Date
     * @param localDateTime 时间
     * @return 结果集
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * localDate 转成 Date
     * @param localDate 结果集
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * LocalTime 转成 Date
     * @param localTime 本地时间
     * @param localDate 时间
     */
    public static Date localTimeToDate(LocalTime localTime, LocalDate localDate) {
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }



}
