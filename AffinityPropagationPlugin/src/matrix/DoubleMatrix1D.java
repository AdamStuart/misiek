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


package matrix;

public class DoubleMatrix1D extends Matrix1D<Double> implements DoubleMatrix1DInterface {

    public DoubleMatrix1D(final Double[] vector) {
        super(vector.length);
        this.setVector(new Double[this.size()]);
        for (int i = 0; i < this.size(); i++) {
            this.setValue(i, vector[i]);
        }
    }

    public DoubleMatrix1D(final int N) {
        super(N);
    }

    public DoubleMatrix1D(final int N, final double t) {
        super(N);
        this.setVector(new Double[N]);
        for (int i = 0; i < N; i++) {
            this.setValue(i, Double.valueOf(t));
        }
    }

    public void set(final int i, final double t) {
        super.set(i, Double.valueOf(t));
    }

    public IntegerMatrix1D findG(final double x) {
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.getValue(i).doubleValue() > x) {
                count++;
            }
        }
        IntegerMatrix1D res = new IntegerMatrix1D(count);
        count = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.getValue(i).doubleValue() > x) {
                res.set(count, Integer.valueOf(i));
                count++;
            }
        }
        return res;
    }

    @Override
    public DoubleMatrix1D copy() {
        DoubleMatrix1D res = new DoubleMatrix1D(this.size());
        for (int i = 0; i < this.size(); i++) {
            res.set(i, this.get(i));
        }

        return res;
    }
}
