import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MinhaJanela {
    ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("image/icon.png"));
    JFrame janelaCronograma = new JFrame();
    Cronometro cronometro = new Cronometro();
    JLabel contador = new JLabel();
    String segundosTexto = String.format("%02d", cronometro.segundos);
    String minutosTexto = String.format("%02d",cronometro.segundos);
    String horasTexto = String.format("%02d",cronometro.horas);



    public void InterfaceCronograma(){


        contador.setText(horasTexto + ":" + minutosTexto + ":" + segundosTexto);
        contador.setBounds(100,100,200,100);
        contador.setFont(new Font("Verdana", Font.TYPE1_FONT, 35));
        contador.setBorder(BorderFactory.createBevelBorder(1));
        contador.setOpaque(true);
        contador.setHorizontalAlignment(JTextField.HORIZONTAL);
    


        janelaCronograma.add(contador);
        janelaCronograma.setVisible(true);
        janelaCronograma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaCronograma.setSize(500, 500);
        janelaCronograma.setResizable(false);
        janelaCronograma.setLocationRelativeTo(null);
        janelaCronograma.getContentPane().setBackground(new Color(10, 100, 50) );
        janelaCronograma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaCronograma.setTitle("Cronômetro");
        janelaCronograma.setIconImage(logo.getImage());

    

    }

    void add(){

    }

}
