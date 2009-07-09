package ppine.io.readers.tasks;

import ppine.io.exceptions.InteractionsFileFormatException;
import ppine.io.parsers.rootparser.RootInteractionsParser;
import java.io.IOException;
import java.util.Map;
import ppine.io.parsers.InteractionParserStruct;
import ppine.logicmodel.controllers.DataHandle;
import ppine.logicmodel.structs.SpeciesTreeNode;
import ppine.main.PluginDataHandle;
import ppine.utils.IDCreator;

public class LoadAllInteractionsTask extends PPINELoadTask {

    private Map<String, Double> tresholds;
    private long current;
    private int created = 0;
    private int all = 0;

    LoadAllInteractionsTask(String intpath, Map<String, Double> tresholds) {
        super(intpath);
        this.tresholds = tresholds;
    }

    public void run() {
        myThread = Thread.currentThread();
        taskMonitor.setStatus("Interactions loading...");
        taskMonitor.setPercentCompleted(-1);

        try {

            openStreams();
            taskMonitor.setPercentCompleted(0);
            reading();

            //MemoLogger.log("Loaded: " + Math.round((double) created * 100 / (double) all) + "% up than treshold");
            taskMonitor.setPercentCompleted(100);
            doneActionPerformed();
        } catch (InteractionsFileFormatException ex) {
            sendErrorEvent(ex);
        } catch (IOException ex) {
            sendErrorEvent(ex);
        } finally {
            try {
                closeStreams();

            } catch (IOException ex) {
                sendErrorEvent(ex);
            }
        }
    }

    public String getTitle() {
        return "Loading interactions with tresholds...";
    }

    private void reading() throws IOException, InteractionsFileFormatException {
        DataHandle dh = PluginDataHandle.getDataHandle();
        float percent = 0;
        float last_percent = 0;
        while (br.ready()) {
            all++;
            InteractionParserStruct interaction = null;
            String line = br.readLine();

            interaction = RootInteractionsParser.readInteraction(line);
            String SourceID = interaction.getFrom();
            String TargetID = interaction.getTo();
            Double probability = interaction.getSim();

            SpeciesTreeNode netOrNull = dh.tryFindPPINetworkByProteinID(SourceID);

            if (netOrNull != null) {
                if (tresholds.containsKey(netOrNull.getID())) {
                    Double treshold = tresholds.get(netOrNull.getID());

                    if (treshold == null || probability > treshold) {
                        String EdgeID = IDCreator.createInteractionID(SourceID, TargetID);

                        dh.createInteraction(EdgeID, SourceID, TargetID, probability);
                        created++;
                    }
                }
            }
            current = fis.getChannel().position();
            percent = current * 100 / (float) max;
            if (percent > last_percent + 1) {
                last_percent = percent;
                taskMonitor.setPercentCompleted(Math.round(percent));
            }
        }
    }
}
