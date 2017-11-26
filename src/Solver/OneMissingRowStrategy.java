package Solver;

import Application.Puzzle;
import Application.Value;

import java.util.ArrayList;
import java.util.List;

public class OneMissingRowStrategy extends Strategy {
    private static long duration = 0;
    private long startTime;
    private long endTime;

    @Override
    public Long getDuration() {
        return duration;
    }

    @Override
    Value findEasiestPossibility(Puzzle p) {
        startTime = System.nanoTime();
        for(int i = 0; i < p.getSize(); ++i){
            for(int j = 0; j < p.getSize(); ++j){
                if(p.getValue(i,j).equals("-")) {
                    List<String> possibleVals = new ArrayList<>();
                    for (int k = 0; k < p.getSize(); ++k) {
                        if(!p.getPossibleValue(i, j, k+1 ).equals(" ")) {
                            possibleVals.add(p.getPossibleValue(i, j, k + 1));
                        }
                    }
                    if(possibleVals.size() == 1){

                        endTime = System.nanoTime();
                        duration += (endTime - startTime);
                        return new Value(i, j, possibleVals.get(0));

                    }
                }
            }
        }
        endTime = System.nanoTime();
        duration += (endTime - startTime);
        return null;
    }
}
