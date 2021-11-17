package tree;

import javax.swing.*;
import java.awt.*;

class Tree extends JFrame {
    private final Integer m_WindowWidth, m_WindowHeight, m_RootLength, m_Depth;
    private final Double m_LengthK, m_RightFall, m_LeftFall;

    public Tree(final Integer c_WindowWidth, final Integer c_WindowHeight, final Integer c_RootLength,
            final Integer c_Depth, final Double c_LengthK, final Double c_RightFall, final Double c_LeftFall) {
        this.m_WindowWidth = c_WindowWidth;
        this.m_WindowHeight = c_WindowHeight;
        this.m_RootLength = c_RootLength;
        this.m_Depth = c_Depth;

        this.m_LengthK = c_LengthK;
        this.m_RightFall = c_RightFall;
        this.m_LeftFall = c_LeftFall;

        this.setVisible(Boolean.TRUE);
        this.setResizable(Boolean.FALSE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(this.m_WindowWidth, this.m_WindowHeight);
        this.setBackground(Color.WHITE);
    }

    public final void f_run() {
        while (Boolean.TRUE) {
            this.repaint();

            try {
                final Integer c_Sllep = 8;
                Thread.sleep(c_Sllep);
            } catch (final InterruptedException c_Exception) {
                System.err.println(c_Exception.getMessage());
            }
        }
    }

    public final void paint(final Graphics c_Graphics) {
        this.f_draw(m_WindowWidth / 2, m_WindowHeight, this.m_RootLength, Math.PI / 2.0, c_Graphics);
    }

    private final void f_draw(final Integer c_StartX, final Integer c_StartY, final Integer c_Length,
            final Double c_Alpha, final Graphics c_Graphics) {
        int v_Lenght = c_Length;

        if (v_Lenght > this.m_Depth) {
            v_Lenght = (int) (v_Lenght * this.m_LengthK);

            final Double c_EndX = c_StartX + v_Lenght * Math.cos(c_Alpha),
                    c_EndY = c_StartY - v_Lenght * Math.sin(c_Alpha);

            c_Graphics.drawLine(c_StartX, c_StartY, c_EndX.intValue(), c_EndY.intValue());

            this.f_draw(c_EndX.intValue(), c_EndY.intValue(), v_Lenght, c_Alpha + Math.PI / this.m_RightFall,
                    c_Graphics);
            this.f_draw(c_EndX.intValue(), c_EndY.intValue(), v_Lenght, c_Alpha - Math.PI / this.m_LeftFall,
                    c_Graphics);
        }
    }
}
