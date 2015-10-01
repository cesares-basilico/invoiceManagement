package invoiceManagement.model;

import java.io.Serializable;
import java.util.Date;

public class Invoice implements Serializable {

	private static final long serialVersionUID = -8680441855737594783L;

	private Date invoiceDate;
	private String invoiceNumber;
	private PaymentMode paymentMode;
	private Date paymentDeadlineDate;

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Date getPaymentDeadlineDate() {
		return paymentDeadlineDate;
	}

	public void setPaymentDeadlineDate(Date paymentDeadlineDate) {
		this.paymentDeadlineDate = paymentDeadlineDate;
	}

}
