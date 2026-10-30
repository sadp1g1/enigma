package com.sadp1g1.enigma.ui;

import javax.swing.*;
import java.awt.*;

public class AboutEnigma extends JFrame {

    public AboutEnigma() {
        super("About Enigma");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(new EnigmaCanvas());
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    static class EnigmaCanvas extends Canvas {

        EnigmaCanvas(){
            setBackground(new Color(250, 243, 230));
        }

        Image img = new ImageIcon(getClass().getResource("/image/enigmaImg.jpg")).getImage();
        String[] lines = {
                "ENIGMA",
                "",
                "Enigma is a cipher machine invented by",
                "German engineer Arthur Scherbius after",
                "World War I. It was widely used by the",
                "German military during World War II.",
                "",
                "It looks like a typewriter, but inside it",
                "has rotating wheels called rotors and a",
                "plugboard. Each key press turns the rotors,",
                "so the same letter is encrypted differently",
                "every time.",
                "",
                "The Germans believed the code could not be",
                "broken. However, Polish mathematician",
                "Marian Rejewski cracked it in 1932, and later",
                "Alan Turing and his team at Bletchley Park",
                "built machines to decode messages daily.",
                "",
                "Breaking Enigma helped the Allies win the",
                "war and shortened it by an estimated two",
                "years.",
        };

        public void paint(Graphics g) {
            g.setFont(new Font("Serif",Font.PLAIN, 18));
            for (int i = 0; i < lines.length; i++)
                g.drawString(lines[i], 400, 60 + i * 20);

            int x = 70, y = 110, w = 250, h = 350;
            g.setColor(new Color(88, 60, 6));
            g.fillRect(x - 10, y - 10, w + 20, h + 20); //ramka
            g.drawImage(img, x, y, w, h, this);
        }
    }
}