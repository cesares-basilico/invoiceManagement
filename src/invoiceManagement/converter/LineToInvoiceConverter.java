package invoiceManagement.converter;

import invoiceManagement.Constants;
import invoiceManagement.evaluator.PaymentDeadlineEvaluator;
import invoiceManagement.evaluator.PaymentDeadlineEvaluatorFactory;
import invoiceManagement.exception.InvalidPaymentModeException;
import invoiceManagement.exception.NotEnoughElementInLine;
import invoiceManagement.model.Invoice;
import invoiceManagement.model.PaymentMode;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

public class LineToInvoiceConverter {

	public Invoice convert(String line) throws ParseException,
			NotEnoughElementInLine, InvalidPaymentModeException {

		Invoice invoice = new Invoice();
		SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
		String[] elements = StringUtils.split(line, Constants.DEFAULT_ELEMENT_SEPARATOR);

		if (elements.length < Constants.MINIMUM_ELEMENT_SIZE) {
			throw new NotEnoughElementInLine();
		}

		invoice.setInvoiceNumber(elements[0].trim());
		invoice.setInvoiceDate(format.parse(elements[1].trim()));
		PaymentMode paymentMode = PaymentMode.modalita(elements[2].trim());
		invoice.setPaymentMode(paymentMode);

		PaymentDeadlineEvaluator paymentDeadlineEvaluator = PaymentDeadlineEvaluatorFactory
				.getEvaluator(paymentMode);

		invoice.setPaymentDeadlineDate(paymentDeadlineEvaluator
				.evaluate(invoice.getInvoiceDate()));

		return invoice;
	}

}
