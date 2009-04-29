package main;

import logicmodel.controllers.DataHandle;
import viewmodel.controllers.CytoDataHandle;

/**
 *
 * @author misiek (mw219725@gmail.com)
 */
public class PluginDataHandle {

    private static DataHandle dataHandle = null;
    private static CytoDataHandle cytoDataHandle = null;
    private static LoadingDataHandle loadingDataHandle = new LoadingDataHandle();

    public static LoadingDataHandle getLoadingDataHandle() {
        return loadingDataHandle;
    }

    public static void setLoadingDataHandle(LoadingDataHandle loadingDataHandle) {
        PluginDataHandle.loadingDataHandle = loadingDataHandle;
    }

    public static void refreshPluginDataHandle() {
        initPluginDataHandle();
    }

    public static void initPluginDataHandle() {
        dataHandle = new DataHandle();
        cytoDataHandle = new CytoDataHandle();
    }

    public static CytoDataHandle getCytoDataHandle() {
        return cytoDataHandle;
    }

    public static void setCytoDataHandle(CytoDataHandle cytoDataHandle) {
        PluginDataHandle.cytoDataHandle = cytoDataHandle;
    }

    public static DataHandle getDataHandle() {
        return dataHandle;
    }

    public static void setDataHandle(DataHandle dataHandle) {
        PluginDataHandle.dataHandle = dataHandle;
    }
}
