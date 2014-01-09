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
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author JoseCarlos
 */
public class Renderer1 extends DefaultTableCellRenderer {

    TableCellRenderer tcr;

    public Renderer1(TableCellRenderer tcr) {
        this.tcr = tcr;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //  javax.swing.JComponent wth = (javax.swing.JComponent) tcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // javax.swing.JLabel label = (javax.swing.JLabel) wth;

        value = (javax.swing.JComponent) tcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof JLabel) {
            JLabel label = (JLabel) value;
            label.setOpaque(true);
            label.setHorizontalAlignment(SwingConstants.CENTER);

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
