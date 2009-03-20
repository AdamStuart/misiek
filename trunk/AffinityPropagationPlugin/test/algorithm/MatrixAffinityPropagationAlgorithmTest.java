package algorithm;

import algorithm.abs.AffinityPropagationAlgorithm;
import algorithm.matrix.MatrixPropagationAlgorithm;
import algorithm.smart.SmartPropagationAlgorithm;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MatrixAffinityPropagationAlgorithmTest {

    public MatrixAffinityPropagationAlgorithmTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDoCluster() {
        double p = Math.log(0.2);
        double inf = -100;

        double[][] sim = {{p, inf, inf, 0}, {inf, p, 0, inf}, {inf, 0, p, 0}, {0, inf, 0, p}};
        AffinityPropagationAlgorithm instance = new MatrixPropagationAlgorithm();
        instance.setLambda(0.5);
        instance.setN(4);
        instance.setIterations(4);
        instance.setConvits(null);
        instance.init();

        instance.setSimilarities(sim);
        instance.doCluster();
    }
}