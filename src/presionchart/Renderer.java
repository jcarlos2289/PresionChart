/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presionchart;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author JoseCarlos
 */
public class Renderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (value instanceof JLabel) {
            JLabel label = (JLabel) value;
            label.setOpaque(true);
            //label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setHorizontalAlignment(CENTER);
            fillColor(table, label, isSelected);
            return label;
        } else {
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    public void fillColor(JTable t, JLabel l, boolean isSelected) {
        //setting the background and foreground when JLabel is selected
        if (isSelected) {
            l.setBackground(t.getSelectionBackground());
            //l.setForeground(t.getSelectionForeground());
        } else {
            l.setBackground(t.getBackground());
            //l.setForeground(t.getForeground());
        }

    }
}
