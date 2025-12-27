import java.time.LocalDate;

public class Bill {

	    private static int billNumber=0;
	    private String billName;
	    String supplier;
	    private LocalDate billDate;
	    private double price;
	    int quantitySold;

		public Bill(){}

		public Bill(String cashierUsername, String supplier, LocalDate billDate, double total, int quantity) {
			this.billName = cashierUsername;
			this.billDate = billDate;
			this.price = total;
			this.supplier = supplier;
			quantitySold = quantity;
			++billNumber;
		}
		
		public static int getBillNo() {
			return billNumber;
		}
		
		public String getCashierUsername() {
			return billName;
		}
		
		public LocalDate getBillDate() {
			return billDate;
		}
		
		public double getTotal() {
			return price;
		}
		
		public String toString() {
			return "Bill \n"+"billName=" + billName + "\n supplier=" + supplier + "\n billDate=" + billDate + "\n price="
					+ price + "\n quantitySold=" + quantitySold+"\n\n";
		}
}
