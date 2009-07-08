package mcv.io.readers.tasks;

import mcv.io.exceptions.ExperimentsFileFormatException;
import java.io.IOException;
import mcv.io.parsers.ExperimentParserStruct;
import mcv.io.parsers.rootparser.RootExperimentsParser;
import mcv.logicmodel.controllers.DataHandle;
import mcv.logicmodel.structs.PPINetworkExp;
import mcv.main.PluginDataHandle;
import mcv.utils.IDCreator;

public class LoadAllExperimentsTask extends MCVLoadTask {

    private long current;
    private int created = 0;
    private int all = 0;

    LoadAllExperimentsTask(String exppath) {
        super(exppath);
    }

    public void run() {
        myThread = Thread.currentThread();
        taskMonitor.setStatus("Loading experiments...");
        taskMonitor.setPercentCompleted(-1);

        try {

            openStreams();
            taskMonitor.setPercentCompleted(0);
            reading();

            //MemoLogger.log("Loaded: " + Math.round((double) created * 100 / (double) all) + "% up than treshold");
            taskMonitor.setPercentCompleted(100);
            doneActionPerformed();
        } catch (ExperimentsFileFormatException ex) {
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
        return "Loading experiments...";
    }

    private void reading() throws IOException, ExperimentsFileFormatException {
        DataHandle dh = PluginDataHandle.getDataHandle();
        float percent = 0;
        float last_percent = 0;
        while (br.ready()) {
            all++;

            String line = br.readLine();

            ExperimentParserStruct interaction = RootExperimentsParser.readExperiment(line);
            if (interaction.getFrom().compareTo(interaction.getTo()) < 0) {
                continue;
            }

            String speciesName = interaction.getSpeciesName();

            String expNetworkName = IDCreator.createExpNetworkID(speciesName);
            PPINetworkExp netOrNull = dh.tryGetExpPPINetowrk(expNetworkName);

            if (netOrNull == null) {
                netOrNull = dh.createExpPPINetwork(speciesName, expNetworkName);
            }

            String edgeID = IDCreator.createExpInteractionID(interaction);

            dh.createInteractionExp(netOrNull, edgeID, interaction);
            created++;
            current = fis.getChannel().position();
            percent = current * 100 / (float) max;
            if (percent > last_percent + 1) {
                last_percent = percent;
                taskMonitor.setPercentCompleted(Math.round(percent));
            }
        }
    }
}