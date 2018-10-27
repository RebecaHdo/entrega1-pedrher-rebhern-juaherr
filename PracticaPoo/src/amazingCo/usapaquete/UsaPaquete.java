package amazingCo.usapaquete;

import amazingCo.paquete.Package;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UsaPaquete {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		GregorianCalendar c = new GregorianCalendar(2000,Calendar.JANUARY,1);
		Package p = new Package("0000000000",c);
		c = p.getFecha();
		String a = c.getTime().toString();
		System.out.println(a);
		GregorianCalendar c2 = new GregorianCalendar(2000,Calendar.FEBRUARY,1);
		System.out.println(p.fechaPasada(c2));
	}

}
