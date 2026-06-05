package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;

public class PlaceholderTextField extends JTextField {
    private static final long serialVersionUID = 1L;
    private String placeholder;

    public PlaceholderTextField(int columns, String placeholder) {
        super(columns);
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Se houver texto digitado ou não houver placeholder, não desenha nada
        if (getText().length() > 0 || placeholder == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;
        
        // Deixa o texto do placeholder mais nítido
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Cor cinza suave para o placeholder
        g2.setColor(Color.LIGHT_GRAY); 
        
        // Calcula a posição correta considerando as bordas do campo
        int x = getInsets().left;
        int y = g.getFontMetrics().getMaxAscent() + getInsets().top;
        
        g2.drawString(placeholder, x, y);
    }
}
