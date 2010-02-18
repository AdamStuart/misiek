/* ===========================================================
 * APGraphClusteringPlugin : Java implementation of Affinity Propagation
 * algorithm as Cytoscape plugin.
 * ===========================================================
 *
 *
 * Project Info:  http://bioputer.mimuw.edu.pl/veppin/
 * Sources: http://code.google.com/p/misiek/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * APGraphClusteringPlugin  Copyright (C) 2008-2009
 * Authors:  Michal Wozniak (code) (m.wozniak@mimuw.edu.pl)
 *           Janusz Dutkowski (idea) (j.dutkowski@mimuw.edu.pl)
 *           Jerzy Tiuryn (supervisor) (tiuryn@mimuw.edu.pl)
 */
package algorithm.abs;

import algorithm.smart.IterationData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;
import prime.PrimeAlgorithm;
import prime.PrimeGraph;

public abstract class AffinityPropagationAlgorithm extends AbstractClusterAlgorithm<String> {

    protected abstract void showInfo();

    public enum AffinityConnectingMethod {

        PRIME_ALG, FLOYD_ALG, ORIGINAL
    }

    public enum AffinityGraphMode {

        DIRECTED, UNDIRECTED
    }
    private Random noiseGenerator = new Random();
    private final double epsilon = 0.0000001;
    private double lambda;
    private int iterations;
    private boolean refine = true;
    private boolean noise = true;
    private Integer steps = null;
    private int iteration = 0;
    protected AffinityConnectingMethod connectingMode = AffinityConnectingMethod.ORIGINAL;
    //   protected AffinityGraphMode graphMode = AffinityGraphMode.DIRECTED;
    protected boolean notConverged = true;
    protected Integer convits = null;
    protected ActionListener iteractionListenerOrNull = null;
    protected Map<Integer, Cluster<Integer>> assigments;
    protected Map<Integer, ConvitsVector> convitsVectors = new HashMap<Integer, ConvitsVector>();
    private Collection<Integer> refined = null;
    private int currentID = 0;
    protected Map<String, Integer> idMapper = new TreeMap<String, Integer>();
    protected Map<Integer, String> idRevMapper = new TreeMap<Integer, String>();

    public int getCurrentIteration() {
        return iteration;
    }

    public boolean didConvergence() {
        return (notConverged == false);
    }

    /*    public void setGraphMode(AffinityGraphMode mode) {
    this.graphMode = mode;
    }*/
    public void setNoise(boolean noise) {
        this.noise = noise;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public void setRefine(boolean refine) {
        this.refine = refine;
    }

    protected Integer getExamplarID(String name) {
        if (idMapper.containsKey(name)) {
            return idMapper.get(name);
        } else {
            Integer id = Integer.valueOf(currentID);
            idMapper.put(name, id);
            idRevMapper.put(id, name);
            currentID++;
            return id;
        }
    }

    private void refineCenters() {
        //  boolean debug = false;
        Collection<Integer> refinedCenters = new TreeSet<Integer>();

        for (Cluster<Integer> cluster : assigments.values()) {

            int maxid = cluster.getName().intValue();
            Integer maxlevel = Integer.valueOf(0);
            Double maxsum = null;
            for (Integer curr : cluster.getElements()) {
                int curr_int = curr.intValue();
                Double sum = Double.valueOf(0);
                Integer level = Integer.valueOf(0);
                for (Integer other : cluster.getElements()) {
                    Double simOrNull = tryGetSimilarityInt(other, curr_int);
                    if (simOrNull != null) {
                        sum += simOrNull;
                        level++;
                    }
                }
                /*        if (debug == true) {
                System.out.println("level: " + level + " sum: " + sum + " curr: " + curr);
                }*/
                if (maxsum == null || level > maxlevel) {
                    maxsum = sum;
                    maxid = curr_int;
                    maxlevel = level;
                } else if (level.equals(maxlevel) && sum >= maxsum) {
                    if (sum.equals(maxsum)) {
                        maxid = Math.min(maxid, curr_int);
                    } else {
                        maxid = curr_int;
                    }
                    maxlevel = level;
                    maxsum = sum;
                }
            }
            refinedCenters.add(Integer.valueOf(maxid));
        }
        refined = refinedCenters;
    }

    protected abstract Double tryGetSimilarityInt(Integer other, Integer curr);

    public abstract void setSimilarityInt(Integer other, Integer curr, Double sim);

    private Map<Integer, Cluster<Integer>> computeFloydAssigments(Collection<Integer> examplars, Collection<Integer> centers) {
        return null;
    }

    public void addIterationListener(final ActionListener listener) {
        this.iteractionListenerOrNull = listener;
    }

    @Override
    public java.lang.String getShortName() {
        return "AP";
    }

    @Override
    public java.lang.String getName() {
        return "Affinity Propagation";
    }

    public double getLambda() {
        return lambda;
    }

    public void setConnectingMode(AffinityConnectingMethod connectingMode) {
        this.connectingMode = connectingMode;
    }

    public void setLambda(final double lambda) {
        this.lambda = lambda;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(final int iterations) {
        this.iterations = iterations;
    }

    public Integer getConvits() {
        return convits;
    }

    public void setConvits(final Integer convits) {
        this.convits = convits;
    }

    public Map<Integer, Integer> doClusterInt() {
        final Map<Integer, Cluster<Integer>> help = doClusterAssocInt();
        if (help != null) {
            final Map<Integer, Integer> res = new TreeMap<Integer, Integer>();

            for (Entry<Integer, Cluster<Integer>> entry : help.entrySet()) {
                for (Integer obj : entry.getValue().getElements()) {
                    res.put(obj, entry.getKey());
                }
            }

            return res;
        } else {
            return null;
        }
    }

    public Map<Integer, Cluster<Integer>> doClusterAssocInt() {
        int iters = getIterations();
        if (iteractionListenerOrNull != null) {
            iteractionListenerOrNull.actionPerformed(new ActionEvent(new IterationData(1, 0), 0, "ITERATION"));
        }
        initConvergence();
        if (noise) {
            generateNoise();
        }

        //   showInfo();

        for (iteration = 1; iteration <= iters; iteration++) {

            copyResponsibilies();
            computeResponsibilities();
            avgResponsibilies();

            copyAvailabilities();
            computeAvailabilities();
            avgAvailabilities();
            //   showInfo();

            computeCenters();
            calculateCovergence();
            notConverged = checkConvergence();

            if (iteractionListenerOrNull != null) {
                iteractionListenerOrNull.actionPerformed(new ActionEvent(new IterationData(iteration, getClustersNumber()), 0, "ITERATION")); //TODO
            }

            if (notConverged == false) {
                break;
            }
        }

        computeCenters();
        if (getClustersNumber() != 0) {
            computeAssigments();
            if (refine) {
                //     System.out.println("REFINE...");
                refineCenters();
                computeAssigments();
            }
            return assigments;
        } else {
            return null;
        }
    }

    protected void computeAssigments() {
        Collection<Integer> examplars = getAllExamplars();
        Collection<Integer> centers;
        if (refined == null) {
            centers = getCenters();
        } else {
            centers = refined;
        }
        if (centers.size() == 0) {
            assigments = null;
            return;
        }

        if (connectingMode == AffinityConnectingMethod.PRIME_ALG) {

            assigments = computePrimeAssigments(examplars, centers);
        } else if (connectingMode == AffinityConnectingMethod.ORIGINAL) {
            assigments = computeOriginalAssigments(examplars, centers);
        } else if (connectingMode == AffinityConnectingMethod.FLOYD_ALG) {
            assigments = computeFloydAssigments(examplars, centers);
        } else {
            assigments = null;
        }
    }

    protected Double generateNoiseHelp(Double sim) {

        return sim - Math.abs(sim) * epsilon * noiseGenerator.nextDouble();
    }

    protected abstract void generateNoise();
//    protected abstract Double getSimilarity(String from, String to);

    public abstract void setConstPreferences(Double preferences);

    public abstract void setSimilarities(double[][] sim);

    protected abstract void copyResponsibilies();

    protected abstract void computeResponsibilities();

    protected abstract void avgResponsibilies();

    protected abstract void copyAvailabilities();

    protected abstract void computeAvailabilities();

    protected abstract void avgAvailabilities();

    protected abstract void computeCenters();

    protected abstract void calculateCovergence();

    protected abstract void initConvergence();

    protected boolean checkConvergence() {
        if (getClustersNumber() == 0) {
            return true;
        }

        if (convits == null) {
            return true;
        } else {

            for (ConvitsVector vec : convitsVectors.values()) {
                if (vec.checkConvits() == false) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract int getClustersNumber();
    //   protected abstract void initObjectsNames();

    protected Double computeWeight(double sim) {

        return -sim;

    }

    public abstract Collection<Integer> getCentersAlg();

    public Collection<Integer> getCenters() {
        if (refined == null) {
            return getCentersAlg();
        } else {
            return refined;
        }
    }

    protected abstract Collection<Integer> getAllExamplars();

    private Map<Integer, Cluster<Integer>> computeOriginalAssigments(Collection<Integer> examplars, Collection<Integer> centers) {
        Map<Integer, Cluster<Integer>> ret = new HashMap<Integer, Cluster<Integer>>();
        Map<Integer, Integer> clustered = new TreeMap<Integer, Integer>();
        Collection<Integer> unclustered = new TreeSet<Integer>(examplars);
        Collection<Integer> unclusteredHelp = new TreeSet<Integer>(examplars);

        for (Integer center : centers) {
            //   System.out.println("CENTER: " + center);
            Cluster<Integer> clust = new Cluster<Integer>(center);
            clust.add(center);
            ret.put(center, clust);
            clustered.put(center, center);
            unclustered.remove(center);
        }

        int step = 0;

        while (unclustered.size() != unclusteredHelp.size()) {
            // System.out.println("obrot...");
            if (steps != null && step >= steps) {
                return ret;
            }
            step++;
            unclusteredHelp = new TreeSet<Integer>(unclustered);
            Map<Integer, Integer> clusteredHelp = new TreeMap<Integer, Integer>(clustered);
            //  System.out.println("CLUSTERED: " + clustered.size());
            for (Integer examplar : unclusteredHelp) {

                Integer maxidOrNull = null;
                Double maxOrNull = null;

                for (final Entry<Integer, Integer> clusteredEx : clusteredHelp.entrySet()) {

                    Double simOrNull = tryGetSimilarityInt(examplar, clusteredEx.getKey());
                    if (simOrNull != null) {
                        if (maxOrNull != null) {
                            if (simOrNull > maxOrNull) {
                                maxOrNull = simOrNull;
                                maxidOrNull = clusteredEx.getValue();
                            }
                        } else {
                            maxOrNull = simOrNull;
                            maxidOrNull = clusteredEx.getValue();
                        }
                    }
                }
                if (maxidOrNull != null) {
                    Cluster<Integer> cluster = ret.get(maxidOrNull);
                    cluster.add(examplar);
                    clustered.put(examplar, maxidOrNull);
                    unclustered.remove(examplar);
                }
            }
        }

        return ret;
    }

    private Map<Integer, Cluster<Integer>> computePrimeAssigments(Collection<Integer> examplars, Collection<Integer> centers) {
        PrimeGraph graph = new PrimeGraph();

        for (Integer examplar : examplars) {
            graph.addNode(examplar);
        }

        for (Integer exFrom : examplars) {
            for (Integer exTo : examplars) {
                if (!exFrom.equals(exTo)) {
                    Double simOrNull = tryGetSimilarityInt(exFrom, exTo);
                    if (simOrNull != null) {
                        Double weight = computeWeight(simOrNull);
                        graph.addEdge(exFrom, exTo, weight);
                    }
                }
            }
        }

        PrimeAlgorithm prime = new PrimeAlgorithm(graph, centers);

        return prime.run();

    }

    public Collection<String> getCentersStr() {
        Collection<Integer> centersInt = getCenters();
        Collection<String> centers = new TreeSet<String>();
        for (Integer centerInt : centersInt) {
            String str = idRevMapper.get(centerInt);
            if (str != null) {
                centers.add(str);
            } else {
                //System.out.println("NULL: " + centerInt);
            }
            //TODO
        }
        return centers;
    }

    @Override
    public Map<String, String> doCluster() {
        Map<Integer, Integer> resInt = doClusterInt();
        Map<String, String> res = new TreeMap<String, String>();
        if (resInt == null) {
            return null;
        }
        for (Entry<Integer, Integer> entry : resInt.entrySet()) {
            res.put(idRevMapper.get(entry.getKey()), idRevMapper.get(entry.getValue()));
        }

        return res;
    }

    @Override
    public Map<String, Cluster<String>> doClusterAssoc() {
        Map<String, Cluster<String>> res = new HashMap<String, Cluster<String>>();
        Map<Integer, Cluster<Integer>> resInt = doClusterAssocInt();
        if (resInt == null) {
            return null;
        }

        for (Entry<Integer, Cluster<Integer>> entry : resInt.entrySet()) {
            Cluster<Integer> clusterInt = entry.getValue();
            Cluster<String> cluster = new Cluster<String>(idRevMapper.get(clusterInt.getName()));
            for (Integer ex : clusterInt.getElements()) {
                cluster.add(idRevMapper.get(ex));
            }

            res.put(idRevMapper.get(entry.getKey()), cluster);
        }

        return res;
    }
}
