package Solver;

import Application.Puzzle;
import Application.Value;

import java.util.ArrayList;
import java.util.List;

public class OneMissingRowStrategy extends Strategy {

    @Override
    Value findEasiestPossibility(Puzzle p) {
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
                        return new Value(i, j, possibleVals.get(0));

                    }
                }
            }
        }
        return null;
    }
}
