package mcv.io.exceptions;

import java.text.ParseException;

/**
 *
 * @author misiek (mw219725@gmail.com)
 */
public class InteractionsFileFormatException extends ParseException {

    public InteractionsFileFormatException(String s, int errorOffset) {
        super(s, errorOffset);
    }
}
