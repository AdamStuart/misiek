package mcv.io.readers.tasks;

import mcv.io.exceptions.FamiliesTreeFormatException;
import mcv.io.parsers.DataParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import mcv.main.PluginDataHandle;

public class LoadTreesTask extends MCVLoadTask {

    private long current;

    public LoadTreesTask(String treespath) {
        super(treespath);
    }

    public void run() {
        myThread = Thread.currentThread();
        taskMonitor.setStatus("Loading proteins data...");
        taskMonitor.setPercentCompleted(-1);
        try {

            openStreams();
            taskMonitor.setPercentCompleted(0);

            reading();

            PluginDataHandle.getLoadedDataHandle().setProteinsLoaded(true);
            taskMonitor.setPercentCompleted(100);
            doneActionPerformed();
            
        } catch (FamiliesTreeFormatException ex) {
            sendErrorEvent(ex);
        } catch (FileNotFoundException ex) {
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
        return "Loading proteins data...";
    }

    private void reading() throws IOException, FamiliesTreeFormatException {
        while (br.ready()) {
            String line;
            line = br.readLine();
            if (line != null && !line.equals("")) {
                String[] families = line.split(";");
                for (String family : families) {
                    DataParser.getInstance().readFamiliesTreeString(family);
                }
                current = fis.getChannel().position();
                float percent = current * 100 / (float) max;
                taskMonitor.setPercentCompleted(Math.round(percent));
            }
        }
    }
}
