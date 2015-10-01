package invoiceManagement.comparator;

import invoiceManagement.model.Invoice;

import java.util.Comparator;

public class InvoiceComparator implements Comparator<Invoice> {

	public int compare(Invoice invoice, Invoice otherInvoice) {

		if (invoice == null || otherInvoice == null) {
			return 0;
		}

		return invoice.getPaymentDeadlineDate()
				.compareTo(otherInvoice.getPaymentDeadlineDate());
	}

}
