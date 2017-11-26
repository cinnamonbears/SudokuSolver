package Solver;

import Application.Puzzle;
import Application.Value;

public class OneLeftStrategy  extends Strategy {
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
        if(p.getEmptySpaces() < 2){
            for(int i = 0; i < p.getSize(); ++ i){
                for(int j = 0; j < p.getSize(); ++ j){
                    if(p.getValue(i, j).equals("-")) {
                        for (int k = 0; k < p.getSize(); ++k) {
                            if(!p.getPossibleValue(i, j, k+1).equals(" ")){
                                endTime = System.nanoTime();
                                duration += (endTime - startTime);
                                return new Value(i, j, p.getPossibleValue(i, j, k+1));
                            }
                        }
                    }
                }
            }
        }
        endTime = System.nanoTime();
        duration += (endTime - startTime);
        return null;
    }
}
