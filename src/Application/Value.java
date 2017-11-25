package Application;

public class Value {
    private int row;
    private int col;
    private String val;

    public Value(int r, int c, String s){
         row = r;
         col = c;
         val = s;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getVal() {
        return val;
    }
}
