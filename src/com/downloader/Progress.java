package com.downloader;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class Progress  extends JProgressBar implements TableCellRenderer {
    public Progress(int min, int max) {
        super(min, max);
    }
    /* Returns this JProgressBar as the renderer
    for the given table cell. */
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column)
    {
// Set JProgressBar's percent complete value.
        setValue((int) ((Float) value).floatValue());
        return this;
    }
}
