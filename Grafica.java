import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

public class Grafica extends JFrame {

    public Integer[][] puntos;
    public int ancho = 1024;
    public int alto = 1024;
    public int margen = 30;

    public Grafica(Integer[][] puntos) {
        super("Gráfica");
        setSize(ancho, alto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.puntos = puntos;
    }

    public void paint(Graphics g) {
        super.paint(g);
        iniciarPlano(g);
    }

    public void iniciarPlano(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int[][] centro = { { margen, alto - margen } };

        //Eje X
        g2d.drawLine(centro[0][0], centro[0][1], ancho - margen, centro[0][1]);

        //Eje Y
        g2d.drawLine(centro[0][0], centro[0][1], centro[0][0], margen);

        int ejeX = ancho - (margen * 2);
        int ejeY = alto - (margen * 2);

        int undX = ejeX / puntos.length;
        int undY = puntos[puntos.length -1][1] > ejeY ? 1 : (ejeY / puntos[puntos.length -1 ][1]);

        Integer[][] puntosGrafica = new Integer[puntos.length][2];

        //Puntos 
        for (int i = 0; i < puntos.length; i++) {
            g2d.setColor(Color.RED);

            int puntoX = centro[0][0] + (undX * i);
            int puntoY = centro[0][1] - (puntos[i][1] * undY);

            //Marcador unidad X 
            g2d.drawLine(
                puntoX, centro[0][1], 
                puntoX, centro[0][1] + 10
            );

            g2d.drawString(puntos[i][0].toString(), puntoX, centro[0][1] + 12);

            g2d.fillOval(
                puntoX - 3, puntoY - 3,
                6, 6
            );
            
            g2d.drawString(puntos[i][1].toString(), puntoX, puntoY + 15);

            puntosGrafica[i][0] = puntoX;
            puntosGrafica[i][1] = puntoY;
        }

        //Trazar entre puntos 
        for (int i = 0; i < puntosGrafica.length - 1; i++) {
            g2d.drawLine(
                puntosGrafica[i][0], puntosGrafica[i][1], 
                puntosGrafica[i + 1][0], puntosGrafica[i + 1][1]
            );
        }
    }
}