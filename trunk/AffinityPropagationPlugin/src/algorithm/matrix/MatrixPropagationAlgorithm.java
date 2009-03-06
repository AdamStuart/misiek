package algorithm.matrix;

import algorithm.abs.*;
import algorithm.smart.Cluster;
import java.util.HashMap;
import java.util.Map;
import matrix.DoubleMatrix1D;
import matrix.DoubleMatrix2D;
import matrix.IntegerMatrix1D;

public class MatrixPropagationAlgorithm extends AffinityPropagationAlgorithm {

    private int N;
    private IntegerMatrix1D idx;
    private IntegerMatrix1D C;
    private DoubleMatrix2D A;
    private DoubleMatrix2D E;
    private DoubleMatrix1D dA;
    private IntegerMatrix1D I;
    private DoubleMatrix2D AS;
    private DoubleMatrix2D R;
    private DoubleMatrix2D Rp;
    private DoubleMatrix2D Aold;
    private DoubleMatrix2D Rold;
    private DoubleMatrix2D YI;
    private DoubleMatrix2D YI2;
    private DoubleMatrix2D S;
    private double inf = 1100000.0;

    @Override
    public void init() {
        A = new DoubleMatrix2D(N, N, 0);
        R = new DoubleMatrix2D(N, N, 0);
    }

    @Override
    public void halt() {
        // TODO
    }

    @Override
    public Map<String, String> doCluster() {
        int iterations = getIterations();
        double[] pom = new double[N];
        Map<String, String> res = new HashMap<String, String>();

        for (int iter = 0; iter < iterations; iter++) {
            Rold = R.copy();

            AS = A.plus(S);
            //    System.out.println("AS" + AS);
            YI = AS.maxr();
            //     System.out.println("YI" + YI);

            for (int i = 0; i < N; i++) {
                int y = (int) YI.get(i, 0);
                AS.set(i, y, -inf);
            }
            YI2 = AS.maxr();
            //       System.out.println("YI2" + YI2);

            for (int i = 0; i < N; i++) {
                pom[i] = YI.get(i, 1);
            }
            DoubleMatrix2D Rep = new DoubleMatrix2D(N, pom);
            //         System.out.println("Rep" + Rep);
            R = S.minus(Rep);

            //          System.out.println("R" + R);

            for (int i = 0; i < N; i++) {
                R.set(i, (int) YI.getMatrix()[i][0], S.get(i, (int) YI.getMatrix()[i][0]) - YI2.get(i, 1));
            }
            System.out.println("Rnew: " + R.toString());
            R = R.mul(1 - getLambda()).plus(Rold.mul(getLambda()));
            System.out.println("Ravg: " + R.toString());

            //          System.out.println("R" + R);
            System.out.println("Aold: " + A.toString());
            Aold = A.clone();
            Rp = R.max(0);
            for (int i = 0; i < N; i++) {
                Rp.set(i, i, R.get(i, i));
            }
            A = (new DoubleMatrix2D(N, Rp.sum().getMatrix()[0])).transpose().minus(Rp);
            //        System.out.println("Rp" + Rp);
            //        System.out.println("sum" + (new DoubleMatrix2D(N, Rp.sum().getMatrix()[0])).transpose());

            //      System.out.println("A - " + A);

            dA = A.diag();

            //      System.out.println("dA - " + dA);

            A = A.min(0);
            for (int i = 0; i < N; i++) {
                A.getMatrix()[i][i] = dA.get(i);
            }
            System.out.println("Anew: " + A.toString());
            A = A.mul((1 - getLambda())).plus(Aold.mul(getLambda()));
        //       System.out.println("A");
        //          System.out.println(A);
        }

        //    System.out.println("S: " + S);
        E = R.plus(A);
        I = E.diag().findG(0);
        int K = I.size();

        C = S.getColumns(I).maxrIndexes();

        //    System.out.println("C: " + C);
        C = tmp(C, I);
        //    System.out.println("C: " + C);
        idx = idx(C, I);

        //    System.out.println("A: " + A);
        //   System.out.println("E: " + E);
        //   System.out.println("I: " + I);
        //  System.out.println("idx: " + idx);

        //     ArrayList res= new ArrayList<Integer>();
        for (int i = 0; i < idx.getVector().length; i++) {
            res.put(String.valueOf(i), String.valueOf(idx.getVector()[i]));
        }


        return res;
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public IntegerMatrix1D idx(IntegerMatrix1D C, IntegerMatrix1D I) {

        IntegerMatrix1D res = new IntegerMatrix1D(C.size());

        for (int i = 0; i < C.size(); i++) {
            res.set(i, I.get(C.get(i).intValue()));
        }

        return res;
    }

    public IntegerMatrix1D tmp(IntegerMatrix1D C, IntegerMatrix1D I) {
        IntegerMatrix1D res = C.clone();
        for (int i = 0; i < I.size(); i++) {
            res.set(I.get(i), new Integer(i));
        }

        return res;
    }

    public double[][] getSimilarities() {
        return S.getMatrix();
    }

    public void setSimilarities(double[][] similarities) {
        N = similarities.length;
        this.S = new DoubleMatrix2D(N, N, similarities);
    }

    @Override
    public Map<String, Cluster<String>> doClusterAssoc() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSimilarities(String x, String y, Double sim) {

        try {
            int i = Integer.valueOf(x);
            int j = Integer.valueOf(y);
            S.set(i, j, sim);

        } catch (Exception ex) {
            System.out.println("setSimilarities!");
        }
    }
}
