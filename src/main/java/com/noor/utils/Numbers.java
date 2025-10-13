package com.noor.utils;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Majid
 */
public final class Numbers {

    public static String round(double number, int decimalLen) {
        return new BigDecimal(number).setScale(decimalLen, BigDecimal.ROUND_CEILING).toString();
    }


    public static String getTextPersian(String text) {
        if (text == null || text.trim().length() == 0) {
            return text;
        }
        StringBuilder s = new StringBuilder();
        char[] cs = text.toCharArray();
        for (char c : cs) {
            if (Character.isDigit(c)) {
                s.append((char) (Character.getNumericValue(c) + 1776));
            } else if (c == '٫') {
                s.append(".");
            } else {
                s.append(c);
            }
        }
        return s.toString();
    }

    public static String getTextEnglish(String text) {
        if (text == null || text.trim().length() == 0) {
            return text;
        }
        StringBuilder s = new StringBuilder();
        char[] cs = text.toCharArray();
        for (char c : cs) {
            if (Character.isDigit(c)) {
                s.append(Character.getNumericValue(c));
            } else {
                s.append(c);
            }
        }
        return s.toString();
    }

    public static String normalizeUUID(String uuid) {
        return uuid.replaceAll("-", "");
    }

    public static String split(String s) {
        boolean b = isDecimal(s);
        String decimal = "";
        StringBuilder result = new StringBuilder();
        if (b && s.indexOf('.') != -1) {
            decimal = s.substring(s.lastIndexOf('.'), s.length());
            s = s.substring(0, s.lastIndexOf('.'));
        }
        String[] strings = new StringBuilder(s).reverse().toString().split("(?<=\\G...)");
        result.append(new StringBuilder(strings[strings.length - 1]).reverse().toString());
        for (int i = strings.length - 2; i >= 0; i--) {
            result.append(",").append(new StringBuilder(strings[i]).reverse().toString());
        }
        if (b && !decimal.matches("\\.[0]*")) {
            result.append(decimal);
        }
        return result.toString();
    }

    private static boolean isDecimal(String string) {
        try {
            @SuppressWarnings("unused")
            Double d = Double.valueOf(getTextEnglish(string));
            return true;
        } catch (Throwable e) {
            return false;
        }
    }

    public static String convert(Double value) {
        try {
            NumberFormat numberFormat = NumberFormat.getInstance();
            return numberFormat.format(value);
        } catch (Exception ex) {
            return String.valueOf(value);
        }
    }

    public static String convert(String value) {
        try {
            Double dValue = Double.parseDouble(value);
            NumberFormat numberFormat = NumberFormat.getInstance();
            return numberFormat.format(dValue);
        } catch (Exception ex) {
            return value;
        }
    }

    public static String convertWithOutSplit(String value) {
        try {
            Double dValue = Double.parseDouble(value);
            NumberFormat numberFormat = NumberFormat.getInstance();
            return numberFormat.format(dValue).replaceAll(",","");
        } catch (Exception ex) {
            return value;
        }
    }

    public static String convertWithOutSplit(Double dValue) {
        try {
            NumberFormat numberFormat = NumberFormat.getInstance();
            return numberFormat.format(dValue).replaceAll(",","");
        } catch (Exception ex) {
            return null;
        }
    }

    public static String EnToPnAlignment(String text) {
        StringBuilder b1 = new StringBuilder();
        String[] stringList = text.split("/");
        if (stringList.length == 1) {
            stringList = text.split("-");
        }
        Collections.reverse(Arrays.asList(stringList));
        for (String s : stringList) {
            b1.append(s);
            b1.append("/");
        }
        b1.deleteCharAt(b1.length() - 1);
        return b1.toString();
    }

    public static String negativeNumberConverter(Double number) {
        if (number != null)
            if (number >= 0d)
                return String.valueOf(convert(number));
            else
                return "(" +convert(Math.abs(number))+ ")";
        else
            return "";
    }

    public static String convertFormatted(Double number, boolean isDecimal) {
        if (isDecimal) {
            if (number != null) {
                return new DecimalFormat("#.0#").format(number);
            }
        } else {
            return convert(number);
        }
        return "";
    }

    public static String convertWithPrunedZeroPoints(Double number) {
        if (number % 1 == 0) {
            return String.format("%,.0f", number);
        } else {
            String format = String.format("%.4f", number);
            return Double.toString(Double.parseDouble(format));
        }
    }

    public static double roundDouble(double number, int pointsٔNumber) {
        return Math.round(number * Math.pow(10, pointsٔNumber)) / Math.pow(10, pointsٔNumber);
    }

    public static String convertToPersianNumber(String number) {
        if (number != null) {
            char[] persianChars = {'٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩'};
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < number.length(); i++) {
                try {
                    if (Character.isDigit(number.charAt(i))) {
                        builder.append(persianChars[(int) (number.charAt(i) - 48)]);
                    } else {
                        builder.append(number.charAt(i));
                    }
                } catch (Exception e) {
                    builder.append(number.charAt(i));
                }
            }
            return builder.toString();
        }
        return "";
    }



}
