import Application.Puzzle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Puzzle p ;

    public static void main(String[] args) throws IOException {
        if(args.length < 0) return;
        File file = new File(args[0]);
        Scanner input = new Scanner(file);
        List<String> values = new ArrayList<>();
        int size = input.nextInt();
        for(int i = 0; i < size; ++i){
            values.add(input.next());
        }
        p = new Puzzle(values, size);
        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                String s = input.next();
                p.setValue(i, j, s);
            }
        }
        System.out.println(p.isSolved());
//        p.printPossibilities();
//        p.printPuzzle();
//        p.setValue(0,2,"2");
//        p.printPossibilities();
//        p.printPuzzle();
    }
}
