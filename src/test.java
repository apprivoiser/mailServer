
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(date);
		System.out.println(now);
 		String time = df.format(date);
 		System.out.println("*********"+time);
 		System.out.println("*********"+System.currentTimeMillis());
 		
// 		Timestamp now = time.;
 		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
 		Timestamp ts = new Timestamp(format.parse(time).getTime());
 		System.out.println("*********"+ts);
 		
 		long t = System.currentTimeMillis();
 		t = t/(1000*3600*24)*(1000*3600*24);
 		System.out.println(df.format(new Timestamp(t)));
 		t = System.currentTimeMillis();
 		t = t/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();
 		System.out.println(df.format(new Timestamp(t)));
	}

}
