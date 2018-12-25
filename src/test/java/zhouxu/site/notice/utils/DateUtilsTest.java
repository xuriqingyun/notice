package zhouxu.site.notice.utils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-12-25 9:41
 */
public class DateUtilsTest {

    @Test
    public void getYesterday() throws ParseException {
        String dateStr="2019-1-1 9:30:0";
        Date yesterday = DateUtils.getYesterday(dateStr);
        System.out.println(DateUtils.format(yesterday));
    }

    @Test
    public void getDate() throws ParseException {
        String dateStr="Dec 25, 2018 12:56:00 PM";
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MMM d, yyyy h:m:s aa", Locale.ENGLISH);
        Date parse = simpleDateFormat.parse(dateStr);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat2.format(parse);
        System.out.println(format);
    }
}