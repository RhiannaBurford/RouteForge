import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GridPanel extends JPanel {

    private final int rows;
    private final int cols;
    private final int cellSize;

    public GridPanel(int rows, int cols, int cellSize) {
        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        setPreferredSize(new Dimension(cols * cellSize, rows * cellSize));
        setBackground(new Color(36, 48, 94)); // Background colour of the panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        // draw horizontal lines
        for (int row = 0; row <= rows; row++) {
            int y = row * cellSize;
            g.drawLine(0, y, cols * cellSize, y);
        }

        // draw vertical lines
        for (int col = 0; col <= cols; col++) {
            int x = col * cellSize;
            g.drawLine(x, 0, x, rows * cellSize);
        }
    }
}
