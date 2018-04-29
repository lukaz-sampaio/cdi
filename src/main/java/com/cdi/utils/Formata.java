package com.cdi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author lucas
 */
public class Formata {

    private static final Logger LOG = Logger.getLogger(Formata.class.getName());

    private Formata(){}

    public static int parseInt(String number) {
        if (StringUtils.isNotBlank(number)) {
            return Integer.valueOf(number.replaceAll("[\\D]", "").trim());
        } else {
            return 0;
        }
    }

    public static long parseLong(String number) {
        if (StringUtils.isNotBlank(number)) {
            return Long.valueOf(number.replaceAll("[\\D]", "").trim());
        } else {
            return 0;
        }
    }

    public static double parseDouble(String number) {
        if (StringUtils.isNotBlank(number)) {
            return Double.valueOf(number.replaceAll("[\\D]", "").trim());
        } else {
            return 0.0;
        }
    }

    public static Integer getInteger(String number) {
        if (StringUtils.isNotBlank(number)) {
            return Integer.valueOf(number.replaceAll("[\\D]", "").trim());
        } else {
            return null;
        }
    }

    public static Long getLong(String number) {
        if (StringUtils.isNotBlank(number)) {
            return Long.valueOf(number.replaceAll("[\\D]", "").trim());
        } else {
            return null;
        }
    }

    public static Double getDouble(String number) {
        if (StringUtils.isNotBlank(number)) {
            return Double.valueOf(number.replaceAll("[\\D]", "").trim());
        } else {
            return null;
        }
    }

    public static java.util.Date parseDate(String date, String pattern) {
        try {
            if (StringUtils.isNotBlank(date)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                java.util.Date d = dateFormat.parse(date);
                return d;
            }
        } catch (ParseException e) {
            LOG.log(Level.SEVERE, null, e);
        }
        return null;
    }
}
