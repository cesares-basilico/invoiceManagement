package invoiceManagement;

import invoiceManagement.comparator.InvoiceComparator;
import invoiceManagement.converter.LineToInvoiceConverter;
import invoiceManagement.exception.InvalidPaymentModeException;
import invoiceManagement.exception.NotEnoughElementInLine;
import invoiceManagement.model.Invoice;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

public class InvoiceManagement {

	public static void main(String[] args) throws Exception {

		File inputFile = new File(args[0]);
		File errorFile = new File(Constants.ERROR_FILE_NAME);

		if (!inputFile.exists()) {
			throw new Exception("Source file not found");
		}

		TreeSet<Invoice> invoiceSet = new TreeSet<Invoice>(
				new InvoiceComparator());
		LineToInvoiceConverter converter = new LineToInvoiceConverter();

		try {
			List<String> lines = FileUtils.readLines(inputFile, "UTF-8");

			for (String line : lines) {
				try {
					invoiceSet.add(converter.convert(line));
				} catch (ParseException | NotEnoughElementInLine
						| InvalidPaymentModeException e) {
					FileUtils.writeStringToFile(errorFile,
							line + System.getProperty("line.separator"), true);
				}
			}

		} catch (IOException e) {
			throw new Exception("Error while reading file");
		}

		writeResultToFile(invoiceSet);

	}

	private static void writeResultToFile(TreeSet<Invoice> invoiceSet)
			throws IOException {

		File outputFile = new File(Constants.RESULT_FILE_NAME);
		StringBuffer buffer = new StringBuffer();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				Constants.DATE_FORMAT);

		for (Invoice invoice : invoiceSet) {
			buffer.setLength(0);
			buffer.append(invoice.getInvoiceNumber());
			buffer.append(Constants.DEFAULT_ELEMENT_SEPARATOR);
			buffer.append(dateFormat.format(invoice.getInvoiceDate()));
			buffer.append(Constants.DEFAULT_ELEMENT_SEPARATOR);
			buffer.append(dateFormat.format(invoice.getPaymentDeadlineDate()));
			buffer.append(System.getProperty("line.separator"));
			FileUtils.writeStringToFile(outputFile, buffer.toString(), true);
		}
	}

}
