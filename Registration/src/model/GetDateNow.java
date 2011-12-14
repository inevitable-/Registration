package model;

	import java.util.Calendar;
	import java.text.SimpleDateFormat;

	public class GetDateNow {
	  public static String date () {
	  Calendar currentDate = Calendar.getInstance();
	  SimpleDateFormat formatter= 
		  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateNow = formatter.format(currentDate.getTime());
	  return dateNow;
	  }
	
}
