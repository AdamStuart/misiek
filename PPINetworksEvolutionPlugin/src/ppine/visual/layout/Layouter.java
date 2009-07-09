package ppine.visual.layout;

import ppine.viewmodel.structs.CytoPPINetworkProjectionToDown;
import ppine.viewmodel.structs.CytoPPINetworkProjectionToUp;

public abstract class Layouter {

    private static Layouter layouter = new DefaultLayouter();

    public static Layouter getInstance() {
        return layouter;
    }

    public abstract void projectionToDownLayout(CytoPPINetworkProjectionToDown projection);

    public abstract void projectionToUpLayout(CytoPPINetworkProjectionToUp projection);
}
