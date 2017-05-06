package com.zhoulychn.common.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Created by lewis on 2016/12/8.
 * 校验器工具类
 */
public class Validator {

    public static boolean isHasEmpty(final Object... list) {
        for (Object obj : list) {
            if (obj == null) {
                return true;
            }

            if ((obj instanceof String))
                return ((String) obj).trim().equals("");
            if ((obj instanceof Collection)) {
                Collection coll = (Collection) obj;
                return coll.size() == 0;
            }
            if ((obj instanceof Map)) {
                Map map = (Map) obj;
                return map.size() == 0;
            }
            if (obj.getClass().isArray()) {
                return Array.getLength(obj) == 0;
            }
        }
        return false;
    }

    public static boolean isEmpty(final Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof String))
            return ((String) obj).trim().equals("");
        if ((obj instanceof Collection)) {
            Collection coll = (Collection) obj;
            return coll.size() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if ((obj instanceof Map)) {
            Map map = (Map) obj;
            return map.size() == 0;
        }
        return false;
    }

    public static boolean isHasBlank(final CharSequence... list) {
        for (CharSequence cs : list) {
            int strLen;
            if (cs == null || (strLen = cs.length()) == 0) {
                return true;
            }
            boolean value = true;
            for (int i = 0; i < strLen; i++) {
                /*如果存在非空字符，则item是正确的*/
                if (!Character.isWhitespace(cs.charAt(i))) {
                    value = false;
                }
            }
            if (value) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return false;
    }

    public static boolean isInvalidQuantity(final Integer num, final Integer min, final Integer max) {
        if (null == num) {
            return true;
        }
        return min > num || num > max;
    }
}
