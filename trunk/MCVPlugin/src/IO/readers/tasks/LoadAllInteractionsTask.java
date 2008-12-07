package IO.readers.tasks;

import IO.parsers.defaultparser.DefaultInteractionsParser;
import cytoscape.task.Task;
import cytoscape.task.TaskMonitor;
import cytoscape.task.ui.JTask;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import main.DataHandle;
import utils.IDCreator;

public class LoadAllInteractionsTask implements Task {

    private TaskMonitor taskMonitor;
    private Thread myThread = null;
    private double treshold;
    private File file;
    private boolean interrupted = false;
    private long max;
    private long current;
    private FileInputStream fis;
    private BufferedInputStream bis;
    private DataInputStream dis;
    private BufferedReader br;

    LoadAllInteractionsTask(String intpath, double treshold) {
        this.treshold = treshold;
        this.file = new File(intpath);
        this.max = file.length();
    }

    public void run() {
        myThread = Thread.currentThread();

        taskMonitor.setStatus("Ładowanie interakcji");
        taskMonitor.setPercentCompleted(-1);
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            br = new BufferedReader(new InputStreamReader(dis));

            taskMonitor.setPercentCompleted(0);

            while (br.ready()) {
                try {

                    String SourceID = DefaultInteractionsParser.readWord(br);
                    String TargetID = DefaultInteractionsParser.readWord(br);
                    String EdgeID = IDCreator.createInteractionID(SourceID, TargetID);

                    Double Probability = Double.parseDouble(DefaultInteractionsParser.readWord(br));

                    if (Probability.doubleValue() >= treshold) {
                        DataHandle.createInteraction(EdgeID, SourceID, TargetID, Probability);
                    }

                    current = fis.getChannel().position();
                    float percent = current * 100 / max;
                    taskMonitor.setPercentCompleted(Math.round(percent));

                } catch (Exception ex) {
                    taskMonitor.setException(ex, "Problem podczas ładowania interakcji");
                }
            }


            br.close();
            dis.close();
            bis.close();
            fis.close();

            taskMonitor.setPercentCompleted(100);
        } catch (Exception e) {
            taskMonitor.setException(e, "Problem podczas tworzenia lub zamykania strumieni");

            return;
        }
    }

    public void halt() {

        System.out.println("zatrzymywanie działania");

        try {
            if (myThread != null) {
                myThread.interrupt();
                br.close();
                dis.close();
                bis.close();
                fis.close();
                //TODO
                this.interrupted = true;
                ((JTask) taskMonitor).setDone();
            }
        } catch (Exception ex) {
            System.out.println("Problem podczas przerywania wczytywania danych");
        }
    }

    public void setTaskMonitor(TaskMonitor taskMonitor) throws IllegalThreadStateException {
        this.taskMonitor = taskMonitor;
    }

    public String getTitle() {
        return new String("Czytanie interakcji z odcięciem: " + treshold + " dla wszystkich sieci...");
    }
}
