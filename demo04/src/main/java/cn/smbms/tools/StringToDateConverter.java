package cn.smbms.tools;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期转换器
 * 目的是将浏览器端传回来的日期格式的字符串转换服务器端所需要的日期类型 Date
 */
public class StringToDateConverter implements Converter<String, Date> {
    //定义日期格式的默认类型为：yyyy-MM-dd
    private String format="yyyy-MM-dd";

    //允许使用ioc的方式注入其他的格式，比如：yyyy/MM/dd
    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public Date convert(String source) {
        try {
            System.out.println("自定义日期转换器！！");
            return new SimpleDateFormat(format).parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
