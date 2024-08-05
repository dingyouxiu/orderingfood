package com.dyx.ordering.common.utils;

public class SerialNumberUtil {

    public static String getNextSerial(Long currentNumber,Integer length) {
        currentNumber++;
        return formatNextSerial(currentNumber, length);
    }

    public static String formatNextSerial(Long currentNumber,Integer length) {
        return String.format("%0" + length + "d", currentNumber);
    }

}
