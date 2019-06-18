/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import tela.TelaLogin;

/**
 *
 * @author Diana
 */
public class Splash {

    JFrame frame;
    JLabel image = new JLabel(new ImageIcon(getClass().getResource("/recursos/morpheus.png")));
    JLabel texto = new JLabel("Morpheus Study");
    JProgressBar progressBar = new JProgressBar();
    JLabel message = new JLabel();

    public Splash() {
        criarInterface();
        addMessage();
        addTexto();
        adicionarImage();

        addProgressBar();

        runningPBar();

    }

    public void criarInterface() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(69, 69, 71));
        // frame.setOpacity(0.9f);
        frame.setVisible(true);

    }

    public void adicionarImage() {
        image.setBounds(260, 170, 130, 30);
        frame.add(image);
    }

    public void addTexto() {
        texto.setFont(new java.awt.Font("Candara", 0, 36));
        texto.setForeground(new java.awt.Color(66, 215, 244));
        texto.setBounds(20, 70, 360, 36);
        texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        frame.add(texto);
    }

    public void addMessage() {
        message.setBounds(80, 150, 300, 14);//posição
        message.setForeground(new Color(214, 206, 55));//cor
        message.setFont(new Font("arial", Font.BOLD, 12));//prpriedade
        frame.add(message);//adiconar label ao frame
    }

    public void addProgressBar() {
        progressBar.setBounds(20, 134, 370, 15);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(new Color(66, 215, 244));
        progressBar.setValue(0);
        frame.add(progressBar);
    }

    public void runningPBar() {
        int i = 0;

        // while( i<=100)
        do {
            try {
                progressBar.setValue(i);
                //Thread.sleep(50);
                Thread.sleep(1);

                message.setText("\"Aguarde carregando banco de dados...\" " + Integer.toString(i) + "%");
                i++;

                if (i == 100) {
                    progressBar.setValue(100);
                    message.setText("\"Banco de dados carregado com sucesso\" ");
                    //Thread.sleep(1000)
                    Thread.sleep(1);
                    TelaLogin login = new TelaLogin();
                    login.setVisible(true);
                    frame.dispose();
                    // break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (i <= 100);

    }
}
