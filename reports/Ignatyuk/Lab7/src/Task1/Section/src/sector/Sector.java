package sector;

import java.awt.*;
import javax.swing.*;
import java.lang.Math;

public final class Sector extends JFrame {
    private final Integer m_WindowWidth, m_WindowHeight, m_SectorLength, m_StartX, m_StartY;
    private Integer m_EndX = 0, m_EndY = 0, m_Angle = 0;

    public Sector(final Integer c_WindowWidth, final Integer c_WindowHeight, final Integer c_SectorLength) {
        super("Sector");
        this.m_WindowWidth = c_WindowWidth;
        this.m_WindowHeight = c_WindowHeight;
        this.m_SectorLength = c_SectorLength;

        this.m_StartX = this.m_WindowWidth / 2;
        this.m_StartY = this.m_WindowHeight / 2;

        this.m_EndX = this.m_StartX + this.m_SectorLength;
        this.m_EndY = this.m_StartY;

        this.setVisible(Boolean.TRUE);
        this.setResizable(Boolean.FALSE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(this.m_WindowWidth, this.m_WindowHeight);
    }

    public final void paint(final Graphics c_Graphics) {
        c_Graphics.setColor(Color.WHITE);
        c_Graphics.fillRect(0, 0, this.m_WindowWidth, this.m_WindowHeight);

        if (this.m_Angle < 90) {
            c_Graphics.setColor(Color.RED);
        } else if (this.m_Angle < 180) {
            c_Graphics.setColor(Color.BLUE);
        } else if (this.m_Angle < 270) {
            c_Graphics.setColor(Color.GREEN);
        } else {
            c_Graphics.setColor(Color.YELLOW);
        }

        c_Graphics.drawLine(this.m_StartX, this.m_StartY, this.m_EndX, this.m_EndY);
    }

    public final void f_run() {
        while (Boolean.TRUE) {
            this.repaint();

            m_Angle %= 360;
            ++this.m_Angle;

            final Double c_AngleInRadians = Math.toRadians(m_Angle),
                    c_NewEndX = this.m_StartX + (this.m_SectorLength * Math.cos(c_AngleInRadians)),
                    c_NewEndY = this.m_StartY - (this.m_SectorLength * Math.sin(c_AngleInRadians));

            this.m_EndX = c_NewEndX.intValue();
            this.m_EndY = c_NewEndY.intValue();

            try {
                final Integer c_Sllep = 8;
                Thread.sleep(c_Sllep);
            } catch (final InterruptedException c_Exception) {
                System.err.println(c_Exception.getMessage());
            }
        }
    }
}
