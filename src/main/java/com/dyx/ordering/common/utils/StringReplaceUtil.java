package com.dyx.ordering.common.utils;

import org.apache.commons.text.StringSubstitutor;

import java.util.Map;

public class StringReplaceUtil {

    /**
     * 根据字符串中占位符名称进行替换
     * @param sourceStr
     * @param stationData
     * @return
     */
    public static String  placeholderSubstitution(String sourceStr, Map<String,Object> stationData){
        StringSubstitutor sub = new StringSubstitutor(stationData);
        return sub.replace(sourceStr);
    }

}
