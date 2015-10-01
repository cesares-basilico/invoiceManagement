package invoiceManagement.model;

public enum PaymentMode {

	DF("DF"), DFFM("DFFM"), DF60("DF60");

	private String sigla;

	PaymentMode(String sigla) {
		this.sigla = sigla;
	}

	String getSigla() {
		return sigla;
	}

	public static PaymentMode modalita(String s) {
		if (s == null) {
			return null;
		}

		for (PaymentMode m : PaymentMode.values()) {
			if (m.getSigla().toUpperCase().equals(s.toUpperCase())) {
				return m;
			}
		}
		return null;
	}
}
