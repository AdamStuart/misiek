package mcv.io.parsers.defaultparser;

import java.io.BufferedReader;
import java.io.IOException;
import mcv.main.PluginDataHandle;
import mcv.viewmodel.controllers.CytoDataHandle;
import mcv.viewmodel.structs.CytoAbstractPPINetwork;
import mcv.utils.IDCreator;

/**
 *
 * @author misiek
 */
public class DefaultInteractionsParser {

    public static void eatWhiteSpace(BufferedReader br) {
        int ch;

        try {
            for (;;) {
                br.mark(1);          // set mark in buffer
                ch = br.read();      // read a char
                if (ch < 1) // if EOF, quit
                {
                    break;
                }
                if (!java.lang.Character.isWhitespace((char) ch)) {
                    br.reset();        // if non-WS, move back to mark & quit
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static String readWord(BufferedReader br) {
        int ch;                        // input variable
        StringBuffer myValue = new StringBuffer("");           // myValue is initially empty

        eatWhiteSpace(br);               // eat leading white space

        try {
            for (;;) {
                ch = br.read();      // read a char
                if (ch < 1 || java.lang.Character.isWhitespace((char) ch)) {
                    break;                   // break for eof or white space
                }
                myValue.append((char) ch);      // append it to myValue
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return myValue.toString();
    }

    public static void readInteractions(BufferedReader br, CytoAbstractPPINetwork cytoNetwork, double treshold) throws IOException {
        CytoDataHandle cdh = PluginDataHandle.getCytoDataHandle();

        while (br.ready()) {

            String SourceID = readWord(br);
            String TargetID = readWord(br);
            String EdgeID = IDCreator.createInteractionID(SourceID, TargetID);

            Double Probability = Double.parseDouble(readWord(br));

            if (Probability.doubleValue() >= treshold && cytoNetwork.containsCytoProtein(SourceID) && cytoNetwork.containsCytoProtein(TargetID)) {
                cdh.createCytoInteraction(EdgeID, SourceID, TargetID, Probability, cytoNetwork);
            }

        }
    }
}
