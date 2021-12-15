package ua.edu.shtoiko.atmsimulator;


/**
 * the lowest denomination available
 */
public class MultiplicityCheck {
    /**
     * to get the lowest denomination available
     *
     * @return lowest denomination
     */
    protected static int multiplicity() {
        int multiplicity;
        if (ATMresource.getFifty() != 0) {
            return multiplicity = 50;
        }
        if (ATMresource.getHundred() != 0) {
            return multiplicity = 100;
        }
        if (ATMresource.getTwoHundred() != 0) {
            return multiplicity = 200;
        }
        if (ATMresource.getFiveHundred() != 0) {
            return multiplicity = 500;
        }
        if (ATMresource.getThousand() != 0) {
            return multiplicity = 1000;
        }
        return multiplicity = 0;
    }
}
