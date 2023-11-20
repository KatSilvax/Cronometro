import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cronometro implements ActionListener {
    ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("Image/icon.png"));
    JFrame janelaCronometro = new JFrame();
    JLabel contador = new JLabel();
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");
    JButton resetButton = new JButton("Reset");

    int milissegundos = 0;
    int segundos = 0;
    int minutos = 0;
    int horas = 0;
    boolean cronometroIniciado = false;

    String segundosTexto = String.format("%02d", segundos);
    String minutosTexto = String.format("%02d", minutos);
    String horasTexto = String.format("%02d", horas);

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            milissegundos = milissegundos + 1000;
            horas = (milissegundos / 3600000);
            minutos = (milissegundos / 60000) % 60;
            segundos = (milissegundos / 1000) % 60;
            segundosTexto = String.format("%02d", segundos);
            minutosTexto = String.format("%02d", minutos);
            horasTexto = String.format("%02d", horas);
            contador.setText(horasTexto + ":" + minutosTexto + ":" + segundosTexto);

        }

    });

    Cronometro() {
        contador.setText(horasTexto + ":" + minutosTexto + ":" + segundosTexto);
        contador.setBounds(100, 100, 200, 100);
        contador.setFont(new Font("Verdana", Font.PLAIN, 35));
        contador.setBorder(BorderFactory.createBevelBorder(1));
        contador.setOpaque(true);
        contador.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Ink free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Ink free", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        janelaCronometro.add(resetButton);
        janelaCronometro.add(startButton);
        janelaCronometro.add(contador);

        janelaCronometro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaCronometro.setSize(420,420);
        janelaCronometro.setResizable(false);
        janelaCronometro.setLayout(null);
        janelaCronometro.setTitle("CronÃ´metro");
        janelaCronometro.setIconImage(logo.getImage());
        janelaCronometro.setVisible(true);
      
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            
            if (cronometroIniciado == false){
                cronometroIniciado = true;
                startButton.setText("Stop");
                Start();
            }
            else{
                cronometroIniciado = false;
                startButton.setText("Start");
                Stop();

            }
        }
        if (e.getSource() == resetButton){
            cronometroIniciado = false;
            startButton.setText("Start");
            Reset();
        }

    }

    void Start() {
        timer.start();
    }

    void Stop() {
        timer.stop();

    }

    void Reset() {
        timer.stop();
        milissegundos = 0;
        segundos = 0;
        minutos = 0;
        horas = 0;
        segundosTexto = String.format("%02d", segundos);
        minutosTexto = String.format("%02d", minutos);
        horasTexto = String.format("%02d", horas);
        contador.setText(horasTexto + ":" + minutosTexto + ":" + segundosTexto);
    }
}