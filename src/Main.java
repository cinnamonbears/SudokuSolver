import Application.Puzzle;
import Solver.OneLeftStrategy;
import Solver.OneMissingRowStrategy;
import Solver.Strategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Puzzle p ;

    public static void main(String[] args) throws IOException {

        int onePossiblityCount = 0;
        int oneLeftCount = 0;
        int guessingCount = 0;

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
        //The slowest possible Strategy
        Strategy onePossibilityStrategy = new OneMissingRowStrategy();
        Strategy oneLeftStrategy = new OneLeftStrategy();
        while(!p.isSolved()){

            System.out.println("-------------");

            if(oneLeftStrategy.solve(p)){
                oneLeftCount++;
                System.out.println("Used One Left Strategy");
            }else if(onePossibilityStrategy.solve(p)){
                onePossiblityCount++;
                System.out.println("Used Slow Strategy");
            }
            System.out.println("Empty Spaces left: " + p.getEmptySpaces());
            p.printPuzzle();
        }

        System.out.println("One Option Left: " + oneLeftStrategy.getDuration() + " nanoseconds, tried " + oneLeftCount + " Times");
        System.out.println("One possibility: " + onePossibilityStrategy.getDuration() + " nanoseconds, tried " + onePossiblityCount + " Times");
    }
}
