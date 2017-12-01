package Testing;

import Application.Puzzle;

import java.util.ArrayList;
import java.util.List;
import Solver.OneLeftStrategy;
import Solver.Strategy;



public class OneLeftStrategyTest {

    @org.junit.Test
    public void getDuration() throws Exception {
        List<String> opt = new ArrayList<>();
        opt.add("1");
        Puzzle p = new Puzzle(opt, 1);
        Strategy s = new OneLeftStrategy();
        assert(s.getDuration() == 0);
        p.setValue(0,0, "1");
        s.solve(p);
        assert (s.getDuration() > 0);

    }

    @org.junit.Test
    public void findEasiestPossibility() throws Exception {
        List<String> opt = new ArrayList<>();
        opt.add("1");
        opt.add("2");
        opt.add("3");
        opt.add("4");
        Puzzle p = new Puzzle(opt, 4);
        Strategy s = new OneLeftStrategy();
        p.setValue(0,0, "2");
        p.setValue(0,1, "-");
        p.setValue(0,2, "3");
        p.setValue(0,3, "1");

        p.setValue(1,0, "1");
        p.setValue(1,1, "3");
        p.setValue(1,2, "2");
        p.setValue(1,3, "4");

        p.setValue(2,0, "3");
        p.setValue(2,1, "1");
        p.setValue(2,2, "4");
        p.setValue(2,3, "2");

        p.setValue(3,0, "4");
        p.setValue(3,1, "2");
        p.setValue(3,2, "1");
        p.setValue(3,3, "3");

        assert(p.getValue(0,1).equals("-"));
        s.solve(p);
        assert(p.getValue(0,1).equals("4"));
    }

}