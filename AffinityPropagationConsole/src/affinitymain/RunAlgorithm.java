package affinitymain;

import algorithm.abs.AffinityPropagationAlgorithm;
import algorithm.abs.Cluster;
import algorithm.smart.SmartPropagationAlgorithm;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import listeners.ConsoleIterationListener;

/**
 *
 * @author misiek (mw219725@gmail.com)
 */
public class RunAlgorithm {

    private String inputpath;
    private String outpath;
    private AffinityPropagationAlgorithm af = new SmartPropagationAlgorithm();
    private double lambda;
    private int iterations;
    private double preferences;
    private Integer convits;
    private Collection<String> nodeNames = new HashSet<String>();
    private String kind;

    public RunAlgorithm(String inputpath, String outpath, double lambda, int iterations, Integer convits, double preferences, String kind) {
        this.inputpath = inputpath;
        this.outpath = outpath;
        this.lambda = lambda;
        this.iterations = iterations;
        this.preferences = preferences;
        this.kind = kind;
        this.convits = convits;
    }

    public void setParemeters() {
        af.setLambda(lambda);
        af.setIterations(iterations);
        af.setConvits(convits);
        af.setConnectingMode(AffinityPropagationAlgorithm.AffinityConnectingMethod.ORIGINAL);
        af.addIterationListener(new ConsoleIterationListener(iterations));

        Collection<InteractionData> ints = new HashSet<InteractionData>();

        Scanner scanner = null;

        try {
            File inputSim = new File(inputpath);
            scanner = new Scanner(inputSim);

            while (scanner.hasNextInt()) {

                String line = scanner.nextLine();
                String[] tokens = line.split("\\s+");
                String from = tokens[0];
                String to = tokens[1];
                Double sim = Double.parseDouble(tokens[2]);
                ints.add(new InteractionData(from, to, sim));
            }
        } catch (IOException ex) {
            Logger.getLogger(RunAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        //    af.setN(ints.size());
        af.setN(nodeNames.size());
        af.init();
        for (InteractionData intData : ints) {
            //     System.out.println(intData.getFrom() + " " + intData.getTo() + " " + intData.getSim());
            af.setSimilarityInt(Integer.valueOf(intData.getFrom()), Integer.valueOf(intData.getTo()), intData.getSim());
        }
        af.setConstPreferences(preferences);
    }

    public void run() {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        BufferedWriter bw = null;
        try {
            File outputCenters = new File(outpath);
            fos = new FileOutputStream(outputCenters);
            bos = new BufferedOutputStream(fos);
            bw = new BufferedWriter(new OutputStreamWriter(bos));
            if (kind.equals("centers")) {
                Map<Integer, Cluster<Integer>> clusters = af.doClusterAssocInt();
                if (clusters != null) {
                    for (Integer clustName : clusters.keySet()) {
                        bw.append(clustName + "\n");
                    }
                }
            } else {
                Map<Integer, Integer> clusters = af.doClusterInt();
                if (clusters != null) {
                    for (Entry<Integer, Integer> entry : clusters.entrySet()) {
                        bw.append(entry.getKey() + " " + entry.getValue() + "\n");
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(RunAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                bos.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(RunAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
