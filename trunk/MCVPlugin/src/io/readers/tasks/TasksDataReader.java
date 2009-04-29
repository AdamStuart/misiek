package io.readers.tasks;

import io.AbstractDataReader;
import cytoscape.Cytoscape;
import cytoscape.task.Task;
import cytoscape.task.ui.JTaskConfig;
import cytoscape.task.util.TaskManager;
import java.util.Map;
import java.util.TreeMap;
import logicmodel.controllers.DataHandle;
import main.PluginDataHandle;
import viewmodel.structs.CytoAbstractPPINetwork;

public class TasksDataReader extends AbstractDataReader {

    @Override
    public void readInteractions(CytoAbstractPPINetwork cytoNetwork, double treshold) {
        String intpath = getFilepath().concat("int");

        Task task = new LoadInteractionsTask(intpath, cytoNetwork, treshold);
        JTaskConfig jTaskConfig = new JTaskConfig();

        jTaskConfig.displayCancelButton(true);
        jTaskConfig.setOwner(Cytoscape.getDesktop());
        jTaskConfig.displayCloseButton(false);
        jTaskConfig.displayStatus(true);
        jTaskConfig.setAutoDispose(true);

        TaskManager.executeTask(task, jTaskConfig);

    }

    @Override
    public void readTrees() {
        //     String treespath = getFilepath().concat("trees");

        Task task = new LoadTreesTask(getFilepath());
        JTaskConfig jTaskConfig = new JTaskConfig();

        jTaskConfig.displayCancelButton(false);
        jTaskConfig.setOwner(Cytoscape.getDesktop());
        jTaskConfig.displayCloseButton(false);
        jTaskConfig.displayStatus(true);
        jTaskConfig.setAutoDispose(true);

        TaskManager.executeTask(task, jTaskConfig);
    }

    @Override
    public void readSpecies() {
        //    String spspath = getFilepath().concat("spy");

        Task task = new LoadSpaciesTask(getFilepath());
        JTaskConfig jTaskConfig = new JTaskConfig();

        jTaskConfig.displayCancelButton(false);
        jTaskConfig.setOwner(Cytoscape.getDesktop());
        jTaskConfig.displayCloseButton(false);
        jTaskConfig.displayStatus(true);
        jTaskConfig.setAutoDispose(true);

        TaskManager.executeTask(task, jTaskConfig);
    }

    @Override
    public void readAllInteractions(double treshold) {
        String intpath = getFilepath().concat("int");

        DataHandle dh = PluginDataHandle.getDataHandle();
        Map<String, Double> tresholds = new TreeMap<String, Double>();
        for (String name : dh.getNetworks().keySet()) {
            tresholds.put(name, Double.valueOf(treshold));
        }

        Task task = new LoadAllInteractionsTask(intpath, tresholds);
        JTaskConfig jTaskConfig = new JTaskConfig();

        jTaskConfig.displayCancelButton(true);
        jTaskConfig.setOwner(Cytoscape.getDesktop());
        jTaskConfig.displayCloseButton(false);
        jTaskConfig.displayStatus(true);
        jTaskConfig.setAutoDispose(true);

        TaskManager.executeTask(task, jTaskConfig);

    }

    @Override
    public void readAllInteractions(Map<String, Double> tresholds) {
        String intpath = getFilepath().concat("int");

        Task task = new LoadAllInteractionsTask(intpath, tresholds);
        JTaskConfig jTaskConfig = new JTaskConfig();

        jTaskConfig.displayCancelButton(true);
        jTaskConfig.setOwner(Cytoscape.getDesktop());
        jTaskConfig.displayCloseButton(false);
        jTaskConfig.displayStatus(true);
        jTaskConfig.setAutoDispose(true);

        TaskManager.executeTask(task, jTaskConfig);

    }
}
