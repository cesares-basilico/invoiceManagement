package invoiceManagement.evaluator;

import java.util.Date;

public class DFPaymentDeadlineEvaluator implements PaymentDeadlineEvaluator {

	@Override
	public Date evaluate(Date invoiceDate) {
		return invoiceDate;
	}

}
