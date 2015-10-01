package invoiceManagement.evaluator;

import invoiceManagement.exception.InvalidPaymentModeException;
import invoiceManagement.model.PaymentMode;

public class PaymentDeadlineEvaluatorFactory {

	public static PaymentDeadlineEvaluator getEvaluator(PaymentMode paymentMode)
			throws InvalidPaymentModeException {
		if (paymentMode == null) {
			throw new InvalidPaymentModeException();
		}

		switch (paymentMode) {
		case DF:
			return new DFPaymentDeadlineEvaluator();
		case DF60:
			return new DF60PaymentDeadlineEvaluator();
		case DFFM:
			return new DFFMPaymentDeadlineEvaluator();
		default:
			throw new InvalidPaymentModeException();
		}
	}
}
