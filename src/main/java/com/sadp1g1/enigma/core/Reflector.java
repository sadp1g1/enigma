package com.sadp1g1.enigma.core;

public final class Reflector {
    public static final Reflector B = new Reflector ("YRUHQSLDPXNGOKMIEBFZCWVJAT");

    private final int[] map = new int[26]; // input -> reflected output

    public Reflector(String wiring) {
        for (int i = 0; i < 26; i++) {
            char letter = wiring.charAt(i);
            int out = letter -'A';
            map[i] = out;
        }
    }

    public int reflect (int c){
        int out = map[c];// follow the wire
        return out;
    }
}
