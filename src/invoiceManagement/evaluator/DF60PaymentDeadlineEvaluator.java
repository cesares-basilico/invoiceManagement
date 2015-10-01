package invoiceManagement.evaluator;

import java.util.Calendar;
import java.util.Date;

public class DF60PaymentDeadlineEvaluator implements PaymentDeadlineEvaluator {

	@Override
	public Date evaluate(Date invoiceDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(invoiceDate);
		calendar.add(Calendar.DATE, 60);
		return calendar.getTime();
	}

}
