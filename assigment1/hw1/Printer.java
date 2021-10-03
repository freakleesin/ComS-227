package hw1;

/**
 * two kind of printers
 * one side printer and two side printer
 * @author liurundi
 *
 */
public class Printer{
	/**
	 * how much paper can a printer hold
	 */
	private int Capacity;
	/**
	 * the number if sheets
	 */
	private int Numberofsheets;
	
	/**
	 * the amount of sheets left 
	 */
	private double ink;
	/**
	 * the number of sheets have been printed
	 */
	private int PaperUsed;

	/**
	* Capacity, in ounces, of a new ink cartridge. 
	* 
	*/
	public static final double INK_CAPACITY=2.0;
	
	
	/**
	 * Amount of ink, in ounces, used per printed page. 
	 */
	public static final double INK_USAGE=0.0023;
	

	/**
	 * /**
	 * Constructs a printer that has given capacity
	 *
	 * @param givenCapacity
	 */
	public Printer(int givenCapacity) {
			Capacity=givenCapacity;
			PaperUsed = 0;
			
	
	
			
	}
	
	/**
	 * Constructs a printer that has the given capacity
	 * @param givenCapacity
	 * @param givenNumberofsheets
	 */
	public Printer(int givenCapacity, int givenNumberofsheets) {
		Capacity = givenCapacity;
		PaperUsed = 0;
		Numberofsheets=Math.min(givenCapacity, givenNumberofsheets);
		ink = INK_CAPACITY;
	
	
	}
	
	/**
	 * Adds the given number of sheets of paper to this printer, not exceeding the printer's capacity.
	 * @param additionalSheets
	 */
	public void addPaper(int additionalSheets) {
		Numberofsheets=Math.min(Capacity, Numberofsheets+ additionalSheets);
	}
	
	/**
	 * Returns the number of sheets of paper currently in this printer. This value is never negative.
	 * @return
	 */
	public int getCurrentPaper() {
		return Math.max(Numberofsheets,0);
	}
	
	/**
	 * Returns the total number of sheets
	 * @return
	 */
	public int getTotalPaperUse() {
		return PaperUsed;
		}
	
	/**
	 * Determines whether the ink has run out
	 * @return
	 */
	public boolean isInkOut() {
		return ink < INK_USAGE;
	}
	/**
	 * full the ink in printer	
	 */
	public void replaceInk() {
		ink = INK_CAPACITY;
		
	}
	
	/**
	 * Simulates printing pages in one-sided mode, using the appropriate 
	 * number of sheets and a corresponding quantity of ink. If there is
	 * not enough paper, the printer will use up all remaining 
	 * paper and will only use the quantity of ink needed for the sheets actually 
	 * printed. If there is not enough ink, the printer will use up all the ink, 
	 * and will still use up the specified number of sheets of paper 
	 * @param numberOfPages
	 */
	public void print (int numberOfPages) {
		int PaperPrinted = Math.min(numberOfPages, Numberofsheets);
		Numberofsheets = Numberofsheets - PaperPrinted;
	    ink = ink - Math.min(PaperPrinted * INK_USAGE,ink);
		PaperUsed=PaperUsed+PaperPrinted;
		
		
	}
	/**
	 * Simulates printing pages in two-sided mode, 
	 * using the appropriate number of sheets and a corresponding quantity of ink. 
	 * If there is not enough paper, the printer will use up all remaining paper 
	 * and will only use the quantity of ink needed for the sheets actually printed. 
	 * If there is not enough ink, the printer will use up all the ink, 
	 * and will still use up the specified number of sheets of paper
	 * @param numberOfPages
	 */
	public void printTwoSided (int numberOfPages) { 
		int PaperPrinted = Math.min(Numberofsheets,(numberOfPages+1)/2);
		Numberofsheets = Numberofsheets - PaperPrinted;
		double InkNeed = Math.min(PaperPrinted * 2, numberOfPages) * INK_USAGE;
		ink = ink - Math.min(InkNeed, ink);
		PaperUsed=PaperUsed+PaperPrinted;
	
	}
	
	
	
}
