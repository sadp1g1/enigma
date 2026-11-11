package com.sadp1g1.enigma.core;

public final class Enigma {
    private final Rotor left;
    private final Rotor middle;
    private final Rotor right;
    private final Reflector reflector;
    private int leftPos;
    private int middlePos;
    private int rightPos;



    public Enigma(Rotor left, Rotor middle, Rotor right, Reflector reflector, char leftStart,
                  char middleStart, char rightStart){

        this.left = left;
        this.middle = middle;
        this.right = right;
        this.reflector = reflector;
        this.leftPos = leftStart - 'A';
        this.middlePos = middleStart - 'A';
        this.rightPos = rightStart - 'A';

    }

    private void step(){
        boolean middleAtNotch = middle.isNotch(middlePos);
        boolean rightAtNotch = right.isNotch(rightPos);
        if (middleAtNotch) {
            leftPos = Math.floorMod(leftPos + 1, 26);
            middlePos = Math.floorMod(middlePos + 1, 26);
        }
        else if (rightAtNotch){
            middlePos = Math.floorMod(middlePos + 1, 26);
        }
        rightPos = Math.floorMod(rightPos +1, 26);
    }

    public char press(char key){
        step ();
        int c = key - 'A';
        c = right.forward(c, rightPos);
        c = middle.forward(c, middlePos);
        c = left.forward(c, leftPos);
        c = reflector.reflect(c);
        c = left.backward(c, leftPos);
        c = middle.backward(c, middlePos);
        c = right.backward(c, rightPos);
        return (char) ('A' + c);
    }

}
