package model.entities;

import java.util.Arrays;

public class LetterSelection {

    private int[] letters;

    public LetterSelection() {
        letters = new int[27];
        Arrays.fill(letters, 0);
    }

    // Returns either a 1 if the letter was already selected or 0 if not
    public int getState(int index) {
        return letters[index];
    }

    public void setSelection(int index, int state) {
        letters[index] = state;
    }

    public void reset(){
        Arrays.fill(letters, 0);
    }
}
