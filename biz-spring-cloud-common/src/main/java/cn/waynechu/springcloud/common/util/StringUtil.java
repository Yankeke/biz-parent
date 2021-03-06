package cn.waynechu.springcloud.common.util;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;

/**
 * @author zhuwei
 * @since 2018/11/6 16:21
 */
@UtilityClass
public class StringUtil {

    /**
     * 判断字符序列是否为 "" 或 null
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param cs 待检查的字符序列
     * @return {@code true} 字符序列是 "" 或 null
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * See isEmpty(final CharSequence cs)
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 判断字符序列是否为 "" 或 null 或 空格
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs 待检查的字符序列
     * @return {@code true} 字符序列是 "" 或 null 或 空格
     */
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
        return true;
    }

    /**
     * See isBlank(final CharSequence cs)
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 首字母转大写
     *
     * @param str 原字符串
     * @return 首字母大写的字符串
     */
    public static String toUpperCaseFirstOne(String str) {
        if (Character.isUpperCase(str.charAt(0))) {
            return str;
        } else {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
    }

    /**
     * 首字母转小写
     *
     * @param str 原字符串
     * @return 首字母小写的字符串
     */
    public static String toLowerCaseFirstOne(String str) {
        if (Character.isLowerCase(str.charAt(0))) {
            return str;
        } else {
            return Character.toLowerCase(str.charAt(0)) + str.substring(1);
        }
    }

    /**
     * 判断字符串中是否包含汉字
     *
     * @param str 字符串
     * @return true if 包含汉字
     */
    public static boolean checkContainChinese(String str) {
        Matcher matcher = RegexUtil.ZH_PATTERN.matcher(str);
        return matcher.find();
    }

    /**
     * 指定格式转化为驼峰命名格式
     *
     * @param originStr 原始字符串
     * @param split     分隔符
     * @return 驼峰命名的的字符串
     */
    public static String toCamel(String originStr, String split) {
        StringBuilder result = new StringBuilder();
        if (originStr == null || originStr.isEmpty()) {
            return "";
        } else if (!originStr.contains(split)) {
            return originStr.substring(0, 1).toLowerCase() + originStr.substring(1);
        }

        String[] splitStr = originStr.split(split);
        for (String str : splitStr) {
            if (str.isEmpty()) {
                continue;
            }

            if (result.length() == 0) {
                result.append(str.toLowerCase());
            } else {
                result.append(str.substring(0, 1).toUpperCase());
                result.append(str.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "trace-app-ids";
        String camelStr = toCamel(str, "-");
        System.out.println(camelStr);
    }
}
