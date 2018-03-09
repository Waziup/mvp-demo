package com.apps.waziup.helper.observer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeZoneUtil {

    private static final int TZ_OFFSET = TimeZone.getDefault().getRawOffset();
    private static final SimpleDateFormat DATE_FORMAT;

    static {
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /**
     * Returns timestamp in local timezone
     */
    public static long getLocaleTs(String value) {
        return getUtcTs(value) + TZ_OFFSET;
    }

    /**
     * Returns timestamp in local timezone
     */
    public static long getUtcTs(String value) {
        try {
            Date parsedDate = DATE_FORMAT.parse(value);
            return parsedDate.getTime();
        } catch (Exception e) {
            Logger.getLogger("TimeZoneUtil").log(Level.WARNING, "Failed to parse timestamp");
            return 0;
        }
    }

    public static String getDate(long time) {
        return DATE_FORMAT.format(new Date(time));
    }

}
