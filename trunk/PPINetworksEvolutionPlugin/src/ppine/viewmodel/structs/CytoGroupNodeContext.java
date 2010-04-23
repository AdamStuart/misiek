/* ===========================================================
 * NetworkEvolutionPlugin : Cytoscape plugin for visualizing stages of
 * protein networks evolution.
 * ===========================================================
 *
 *
 * Project Info:  http://bioputer.mimuw.edu.pl/modevo/
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
 * NetworkEvolutionPlugin  Copyright (C) 2008-2009
 * Authors:  Michal Wozniak (code) (m.wozniak@mimuw.edu.pl)
 *           Janusz Dutkowski (idea, data) (j.dutkowski@mimuw.edu.pl)
 *           Jerzy Tiuryn (supervisor) (tiuryn@mimuw.edu.pl)
 */

package ppine.viewmodel.structs;

import java.util.Collection;
import java.util.HashSet;

public class CytoGroupNodeContext {

    private CytoProtein motherProtein;
    private Collection<CytoProtein> insideProteins;

    public CytoGroupNodeContext(CytoProtein motherProtein) {
        this.motherProtein = motherProtein;
        this.insideProteins = new HashSet<CytoProtein>();
    }

    public void addProteinInside(CytoProtein proteinProjection) {
        insideProteins.add(proteinProjection);
    }

    public Collection<CytoProtein> getInsideProteins() {
        return insideProteins;
    }

    public void setInsideProteins(Collection<CytoProtein> insideProteins) {
        this.insideProteins = insideProteins;
    }

    public CytoProtein getMotherProtein() {
        return motherProtein;
    }

    public void setMotherProtein(CytoProtein motherProtein) {
        this.motherProtein = motherProtein;
    }
}
