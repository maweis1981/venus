package com.maweis.util;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 处理字符串及字符串与其他的转换
 * @author nick
 * 2013-3-13
 */
public class StringUtils {
    //	static {
    //		BeanUtilsBean.getInstance().getConvertUtils().deregister(Long.class);
    //		BeanUtilsBean.getInstance().getConvertUtils().deregister(Integer.class);
    //		BeanUtilsBean.getInstance().getConvertUtils().register(new IntegerConverter(),Integer.class);
    //		BeanUtilsBean.getInstance().getConvertUtils().register(new LongConverter(),Long.class);
    //	}

	/**
	 * 
	 */
	public static String null2Empty(Object o) {
		return o == null ? "" : o.toString();
	}
	
    /**
     * 切分为字符串数组
     * @param str
     * @param delim
     * @return
     */
    public static String[] split(String str, String delim) {
        return org.apache.commons.lang.StringUtils.split(str, delim);
    }


    public static String getClazzName(String fullClazzName) {
        int li = fullClazzName.lastIndexOf(".");
        if (li == -1 ){
            return fullClazzName;
        }
        return fullClazzName.substring(li + 1);
    }
    /**
     * 切分为任意类型List
     * @param <T>
     * @param str
     * @param clazz List element type
     * @return
     */
    public static <T> List<T> split(String str, Class<T> clazz) {
        return split(str,",", clazz);
    }

    /**
     * 切分为任意类型List
     * @param <T>
     * @param str
     * @param delim 分隔符
     * @param clazz List element type
     * @return
     */
    public static <T> List<T> split(String str, String delim, Class<T> clazz) {
        if(str == null || delim == null) {
            return null;
        }
        String[] sArray = split(str, delim);
        List<T> list = new ArrayList<T>();
        if(clazz == String.class) {
            for(Object s : sArray) {
                list.add((T)s);
            }
        } else {
            //FIXME 取巧方法，后续希望得到更好修改方法这里如果转化失败，会填写默认值，例如Long : 0
            Converter converter = BeanUtilsBean.getInstance().getConvertUtils().lookup(clazz);
            for(Object s : sArray) {
                T o = (T)converter.convert(clazz, s);
                list.add(o);
            }
        }
        return list;
    }

    /**
     * delegate to org.apache.commons.lang.StringUtils.isEmpty
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return org.apache.commons.lang.StringUtils.isEmpty(str);
    }

    /**
     * cut the string with safe length.
     * 
     * @param s
     * @param n
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    public static String cutString(String s, int n) {
        if (s == null) {
            return null;
        }
        if (n <= 0) {
            return "";
        }
        if (s.length() <= n) {
            return s;
        } else {
            return s.substring(0, n);
        }
    }
    
    /**
     * 严格匹配正则表达式
     * @param s
     * @param regex
     * @return
     */
    public static boolean matchers(String s, String regex) {
    	final Pattern pattern = Pattern.compile(regex);
    	final Matcher mat = pattern.matcher(s);
    	return mat.matches();
    }

    public static void main(String args[]) {
        String str = "1,2,2,3,4,,54,56,abc,54,6";
        List<Long> list1 = split(str, ",", Long.class);
        List<Integer> list2 = split(str, ",", Integer.class);
        System.out.println(list1);
        System.out.println(list2);
    }
}
