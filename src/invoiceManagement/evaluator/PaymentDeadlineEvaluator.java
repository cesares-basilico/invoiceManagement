package invoiceManagement.evaluator;

import java.util.Date;

public interface PaymentDeadlineEvaluator {

	public Date evaluate(Date invoiceDate);

}
