package day2.classs;

import java.time.*;

public class DateTime {
    public static void main(String[] args) {
        // 获取当前本地时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local DateTime: " + localDateTime);

        // 将本地时间转换为 UTC 时间
        ZonedDateTime localZonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        ZonedDateTime utcZonedDateTime = localZonedDateTime.withZoneSameInstant(ZoneOffset.UTC);
        System.out.println("UTC DateTime: " + utcZonedDateTime);


        System.out.println("将 UTC 时间转换为本地时间=====================================");
        // 获取当前 UTC 时间
        Instant now = Instant.now();
        System.out.println("Current UTC time: " + now);

        // 将 UTC 时间转换为本地时间
        ZonedDateTime localDateTimes = now.atZone(ZoneId.systemDefault());
        System.out.println("Local DateTime: " + localDateTimes);

        long l = System.currentTimeMillis();
        System.out.println(l);

        Instant end = Instant.now();
        System.out.println(end);

        System.out.println(LocalDate.now());

    }
}
