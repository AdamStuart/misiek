/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mcv.ui;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author misiek (mw219725@gmail.com)
 */
public class PluginResources {

    public static Icon getIcon(String localpath) {
        URL url = ClassLoader.getSystemResource("resources/" + localpath);
        return new ImageIcon(url);
    }
}
