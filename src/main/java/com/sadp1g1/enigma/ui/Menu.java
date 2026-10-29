package com.sadp1g1.enigma.ui;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame{

    Menu(){
        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(250, 243, 230));
        setLayout(new BorderLayout());

        JLabel text = new JLabel("<html><table>"
                + "<tr><td align='center' style='font-family:Serif; font-size:51pt; font-weight:bold'>ENIGMA</td></tr>"
                + "<tr><td align='center' style='font-family:Serif; font-size:28pt; font-style:italic'>The Cipher Machine That Shaped History</td></tr>"
                + "<tr><td align='center' style='font-size:16pt'><br>"
                + "Step into the world of secret codes. This program recreates the legendary<br>"
                + "Enigma machine used during World War II. Set the rotors, type your message,<br>"
                + "and watch it turn into an unbreakable cipher, or so the Germans thought."
                + "</td></tr>"
                + "</table></html>", SwingConstants.CENTER);
        text.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
        add(text, BorderLayout.NORTH);


        ImageIcon rotorsIcon = new ImageIcon(getClass().getResource("/image/enigma_rotors.png"));
        JLabel rotors = new JLabel(rotorsIcon);
        rotors.setVerticalAlignment(SwingConstants.TOP);
        add(rotors, BorderLayout.CENTER);


        JButton button = new JButton("pick me");
        button.addActionListener(e -> new AboutEnigma().setVisible(true));

        JPanel bottom = new JPanel();
        bottom.setOpaque(false);
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        bottom.add(button);

        add(bottom, BorderLayout.SOUTH);
    }
}

