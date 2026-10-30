package com.sadp1g1.enigma.core;

public final class Rotor {
    public static final Rotor I = new Rotor ("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q');
    public static final Rotor II = new Rotor ("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E');
    public static final Rotor III = new Rotor ("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V');

    private final int[] forward = new int[26]; //input -> output
    private final int[] backward = new int[26]; //output -> input
    private final int notch; // notch position, 0..25

    public Rotor(String wiring, char notch) {
       this.notch = notch - 'A';

       for (int i = 0; i < 26; i++) {
           char letter = wiring.charAt(i);
           int out = letter -'A';
           forward[i] = out;
           backward[out] = i;
       }
    }
    // Returns true if the given position is this rotor's notch
    public boolean isNotch(int position){
        return position == notch;
    }

    public int forward(int c, int position){
        int entry = Math.floorMod(c + position, 26);// shift the input by the rotor position
        int out = forward[entry];// follow the wire
        return Math.floorMod(out - position, 26);// remove the shift on the way out
    }

    public int backward(int c, int position){
        int entry = Math.floorMod(c + position, 26);
        int out = backward[entry];
        return Math.floorMod(out - position, 26);
    }
}
