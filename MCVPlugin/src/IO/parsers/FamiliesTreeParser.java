package IO.parsers;

import java.awt.Color;
import java.util.Collection;
import java.util.HashSet;
import main.DataHandle;
import utils.ColorGenerator;

public class FamiliesTreeParser {

    public static void parseTree(String tree) {
        tree = tree.trim();
        int last = tree.lastIndexOf(")");

        String subTree = tree.substring(1, last);
        String RootNetworkID = tree.substring(last + 1, tree.length());

        DataHandle.createRootPPINetwork(RootNetworkID);
        parseSubTree(subTree, RootNetworkID);
    }

    private static void parseSubTree(String tree, String parent) {
        tree = tree.trim();
        if (tree.charAt(0) == '(') {
            int last = tree.lastIndexOf(")");
            String subTree = tree.substring(1, last);
            String NetworkID = tree.substring(last + 1, tree.length());

            DataHandle.createPPINetwork(NetworkID, parent);
            parseSubTree(subTree, NetworkID);
        } else {
            DataHandle.createPPINetwork(tree, parent);
        }
    }

    public static void readAllTreeString(String treeString) {
        int lastIndex = treeString.lastIndexOf(")");
        String FamilyName = treeString.substring(lastIndex + 1).trim();
        String tree = treeString.substring(1, lastIndex).trim();

        Color color = ColorGenerator.generateColor(FamilyName);

        DataHandle.createFamily(FamilyName, color);
        readTreeSpaciesString(tree, FamilyName, null);

    }

    private static ParserStruct extractSpaciesName(String treeString) {
        ParserStruct struct = new ParserStruct();

        int lastBracket = treeString.lastIndexOf("]");
        if (lastBracket == -1) {
            struct.setNodeName(treeString);
            struct.setSubNodes(null);
        } else {
            struct.setNodeName(treeString.substring(lastBracket + 1));
            struct.setSubNodes(extractSubNodes(treeString.substring(1, lastBracket)));
        }

        return struct;
    }

    private static Collection<String> extractSubNodes(String substring) {
        Collection<String> ret = new HashSet<String>();

        int count = 0;
        int lastIndex = 0;

        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '(') {
                count++;
            } else if (substring.charAt(i) == ')') {
                count--;
            } else if ((substring.charAt(i) == ',') && (count == 0)) {
                ret.add(substring.substring(lastIndex, i));
                lastIndex = i + 1;
            }
        }

        ret.add(substring.substring(lastIndex, substring.length()));

        return ret;
    }

    private static Collection<String> readTreeSpaciesCollection(String substring) {

        Collection<String> ret = new HashSet<String>();
        int count = 0;
        int lastIndex = 0;

        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '[') {
                count++;
            } else if (substring.charAt(i) == ']') {
                count--;
            } else if ((substring.charAt(i) == ',') && (count == 0)) {
                ret.add(substring.substring(lastIndex, i));
                lastIndex = i + 1;
            }
        }

        ret.add(substring.substring(lastIndex, substring.length()));

        return ret;
    }

    private static void readTreeSpaciesString(String tree, String FamilyName, String parent) {
        Collection<String> spaciesInfo = readTreeSpaciesCollection(tree);
        for (String sp : spaciesInfo) {
            ParserStruct struct = extractSpaciesName(sp);

            if (struct.getSubNodes() == null) {
            } else {
                for (String subNode : struct.getSubNodes()) {
                    int lastBracket = subNode.lastIndexOf(")");
                    if (lastBracket != -1) {
                        String proteinName = subNode.substring(lastBracket + 1);
                        String spaciesCollection = subNode.substring(1, lastBracket);

                        DataHandle.createProtein(proteinName, parent, struct.getNodeName(), FamilyName);
                        readTreeSpaciesString(spaciesCollection, FamilyName, proteinName);
                    } else {
                        String proteinName = subNode;
                        DataHandle.createProtein(proteinName, parent, struct.getNodeName(), FamilyName);
                    }
                }
            }
        }
    }
}

