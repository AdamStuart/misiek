package mcv.ui;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author misiek (mw219725@gmail.com)
 */
class JTableButtonRenderer implements TableCellRenderer {

    private TableCellRenderer __defaultRenderer;

    public JTableButtonRenderer(TableCellRenderer renderer) {
        __defaultRenderer = renderer;
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected,
            boolean hasFocus,
            int row, int column) {
        if (value instanceof Component) {
            return (Component) value;
        }
        return __defaultRenderer.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
    }
}
