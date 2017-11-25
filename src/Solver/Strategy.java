package Solver;

import Application.Puzzle;
import Application.Value;

public abstract class Strategy {

    public final Puzzle solve(Puzzle p){
        Value val = findEasiestPossibility(p);
        if(val != null){
            addValueToPuzzle(p, val);
        }
        p.setCompleted(checkForComplete(p));
        return p;
    }

    private void addValueToPuzzle(Puzzle p, Value val) {
        p.setValue(val.getRow(), val.getCol(), val.getVal());
    }

    abstract Value findEasiestPossibility(Puzzle p);

    private boolean checkForComplete(Puzzle p){
        for(int i = 0; i < p.getSize(); ++i){
            for(int j = 0; j < p.getSize(); ++j){
                if(p.getValue(i,j).equals("-")){
                    return false;
                }
            }
        }
        return true;
    }
}
