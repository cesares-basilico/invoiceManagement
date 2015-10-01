package invoiceManagement.evaluator;

import java.util.Calendar;
import java.util.Date;

public class DFFMPaymentDeadlineEvaluator implements PaymentDeadlineEvaluator {

	@Override
	public Date evaluate(Date invoiceDate) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(invoiceDate);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, 0);

		return calendar.getTime();
	}

}
