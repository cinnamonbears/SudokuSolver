import Application.Puzzle;
import Solver.OneMissingRowStrategy;
import Solver.Strategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Puzzle p ;

    public static void main(String[] args) throws IOException {
        if(args[0] == null) return;
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

        p.printPuzzle();
        Strategy s = new OneMissingRowStrategy();
        while(!p.isSolved()){
            System.out.println("-------------");
            p = s.solve(p);
            p.printPuzzle();
        }
//        p.printPossibilities();
//        p.printPuzzle();
//        p.setValue(0,2,"2");
//        p.printPossibilities();
//        p.printPuzzle();
    }
}
