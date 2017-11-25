package Application;

import java.util.List;

public class Puzzle {
    private List<String> options;
    private String puzzle[][][];
    private int size;

    public Puzzle(List<String> o, int size){
        this.size = size;
        options = o;
        puzzle = new String[size][size][size + 1];
        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                for(int k = 1; k <= size; ++k){
                    puzzle[i][j][k] = options.get(k -1);
                }
            }
        }
        //Checking if 3rd dimension is getting set correctly;
//        for(int i = 0; i < size; ++i){
//            System.out.println("i: " + i);
//            for(int j = 0; j < size; ++j){
//                System.out.println("j: " + j);
//                for(int k = 1; k <= size; ++k){
//                    System.out.print(puzzle[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//        }
    }

    public void setValue(int i, int j, String v){
        puzzle[i][j][0] = v;
        if(!v.equals("-")){
            removePossibilitiesForInsert(i, j);
        }
        removePossibilitiesForRow(i, v);
        removePossibilitiesForCol(j, v);
        removePossibilitiesForScare(i, j, v);
    }
    public String getValue(int i, int j){
        return puzzle[i][j][0];
    }

    private void removePossibilitiesForInsert(int i, int j){
        for(int k = 0; k < size; ++k){
            puzzle[i][j][k + 1] = " ";
        }
    }

    private void removePossibilitiesForRow(int i, String s){
        for(int j = 0; j < size; ++j){
            for(int k = 0; k < size; ++k){
                if(puzzle[i][j][k+1].equals(s)){
                    puzzle[i][j][k+1] = " ";
                }
            }
        }
    }

    private void removePossibilitiesForCol(int j, String s){
        for(int i = 0; i < size; ++i){
            for(int k = 0; k < size; ++k){
                if(puzzle[i][j][k+1].equals(s)){
                    puzzle[i][j][k+1] = " ";
                }
            }
        }
    }

    private void removePossibilitiesForScare(int i, int j, String s){
        int root = (int) Math.sqrt(size);
        int row = i / root;
        int col = j / root;
        for(int k = 0; k < root; ++k){
            for(int l = 0; l < root; ++l){
                for(int poss = 0; poss < size; poss++)
                if(puzzle[k + row*root][l + col*root][poss+1].equals(s)){
                    puzzle[k + row*root][l + col*root][poss+1] = " ";
                }
            }
        }
    }

    public void printPossibilities(){
        System.out.println("***********Possiblities*****************");
        for(int i = 0; i < size; ++i) {
            System.out.println("i: " + i);
            for (int j = 0; j < size; ++j) {
                System.out.println("    j: " + j);
                for (int k = 1; k <= size; ++k) {
                    System.out.print(puzzle[i][j][k] + "");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void printPuzzle(){
        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                System.out.print(puzzle[i][j][0] + " ");
            }
            System.out.println();
        }
    }

    public boolean isSolved(){
        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                if(puzzle[i][j][0].equals("-")){
                    return false;
                }
            }
        }
        return true;
    }
}
