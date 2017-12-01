package Testing;

import Application.Puzzle;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class PuzzleTest {
    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void setValue() throws Exception {
        List<String> opt = new ArrayList<>();
        opt.add("1");
        opt.add("2");
        opt.add("3");
        opt.add("4");
        Puzzle p = new Puzzle(opt, 4);
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
    }

    @Test
    public void getValue() throws Exception {
        List<String> opt = new ArrayList<>();
        opt.add("1");
        opt.add("2");
        opt.add("3");
        opt.add("4");
        Puzzle p = new Puzzle(opt, 4);

        p.setValue(0,0, "2");
        assert(p.getValue(0,0).equals("2"));
    }

    @Test
    public void getPossibleValue() throws Exception {
        List<String> opt = new ArrayList<>();
        opt.add("1");
        opt.add("2");
        opt.add("3");
        opt.add("4");
        Puzzle p = new Puzzle(opt, 4);

        p.setValue(0,0, "2");
        assert(p.getPossibleValue(0,0, 1).equals(" "));
        assert(p.getPossibleValue(0,0, 3).equals(" "));
        assert(p.getPossibleValue(0,0, 4).equals(" "));
        assert(p.getPossibleValue(0,0, 2).equals(" "));
        assert(p.getPossibleValue(0,1,1).equals("1"));
    }

    @Test
    public void isSolved() throws Exception {
        List<String> opt = new ArrayList<>();
        opt.add("1");
        opt.add("2");
        opt.add("3");
        opt.add("4");
        Puzzle p = new Puzzle(opt, 4);
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
        assert(p.isSolved() == false);
        p.setValue(0,1,"4");
        assert(p.isSolved() == true);
    }

}