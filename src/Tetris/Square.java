package Tetris;

public class Square {
    int type = 1;
    Cell[] cells = new Cell[4];
    public Square getSquare() {
        int startCol = (int) (Math.random()*7)+1;
        int square = (int) (Math.random()*7);
        return switch (square) {
            case 0 -> new A(startCol);
            case 1 -> new B(startCol);
            case 2 -> new C(startCol);
            case 3 -> new D(startCol);
            case 4 -> new E(startCol);
            case 5 -> new F(startCol);
            case 6 -> new G(startCol);
            default -> null;
        };
    }
    public void rotate(){
        
    }
    public void goDown(){
        for (Cell cell : cells) {
            cell.goDown();
        }
    }
    public void goLeft(){
        for (Cell cell : cells) {
            cell.goLeft();
        }
    }
    public void goRight(){
        for (Cell cell : cells) {
            cell.goRight();
        }
    }
}

/**
 * [][]
 * [][]
 */
class A extends Square{
    public A(int startCol){
        cells[0] = new Cell(0, startCol);
        cells[1] = new Cell(0, startCol+1);
        cells[2] = new Cell(1, startCol);
        cells[3] = new Cell(1, startCol+1);
    }
}

/**
 * [][][]
 *   []
 */
class B extends Square{
    int[][][] next = {{{0, 0}, {0, -1}, {1, 0}, {0, 1}},
                      {{0, 0}, {-1, 0}, {0, -1}, {1, 0}},
                      {{0, 0}, {0, 1}, {-1, 0}, {0, -1}},
                      {{0, 0}, {1, 0}, {0, 1}, {-1, 0}}};
    public B(int startCol){
        cells[0] = new Cell(0, startCol);
        cells[1] = new Cell(0, startCol-1);
        cells[2] = new Cell(1, startCol);
        cells[3] = new Cell(0, startCol+1);
    }

    @Override
    public void rotate() {
        boolean canRotate = true;
        int row = cells[0].getRow();
        int col = cells[0].getCol();
        for (int i = 0; i < cells.length; ++i){
            if (!(row+next[type%4][i][0] < GameBoard.ROW && row+next[type%4][i][0] >= 0 
                    && col+next[type%4][i][1] < GameBoard.COL && col+next[type%4][i][1] >=0)) {
                canRotate = false;
                break;
            }
        }
        if (canRotate) {
            for (int i = 0; i < cells.length; ++i) {
                cells[i].setRow(row + next[type % 4][i][0]);
                cells[i].setCol(col + next[type % 4][i][1]);
            }
            type++;
        }
    }
}

/**
 * [][][]
 * []
 */
class C extends Square{
    int[][][] next = {{{0, 0}, {0, 1}, {0, -1}, {1, -1}},
                      {{0, 0}, {-1, 0}, {1, 0}, {1, 1}},
                      {{0, 0}, {0, -1}, {0, 1}, {-1, 1}},
                      {{0, 0}, {1, 0}, {-1, 0}, {-1, -1}}};
    public C(int startCol){
        cells[0] = new Cell(0, startCol);
        cells[1] = new Cell(0, startCol+1);
        cells[2] = new Cell(0, startCol-1);
        cells[3] = new Cell(1, startCol-1);
    }

    @Override
    public void rotate() {
        boolean canRotate = true;
        int row = cells[0].getRow();
        int col = cells[0].getCol();
        for (int i = 0; i < cells.length; ++i){
            if (!(row+next[type%4][i][0] < GameBoard.ROW && row+next[type%4][i][0] >= 0
                    && col+next[type%4][i][1] < GameBoard.COL && col+next[type%4][i][1] >=0)) {
                canRotate = false;
                break;
            }
        }
        if (canRotate) {
            for (int i = 0; i < cells.length; ++i) {
                cells[i].setRow(row + next[type % 4][i][0]);
                cells[i].setCol(col + next[type % 4][i][1]);
            }
            type++;
        }
    }
}

/**
 * [][][]
 *     []
 */
class D extends Square{
    int[][][] next = {{{0, 0}, {0, -1}, {0, 1}, {1, 1}},
            {{0, 0}, {1, 0}, {-1, 0}, {-1, 1}},
            {{0, 0}, {0, 1}, {0, -1}, {-1, -1}},
            {{0, 0}, {-1, 0}, {1, 0}, {1, -1}}};
    public D(int startCol){
        cells[0] = new Cell(0, startCol);
        cells[1] = new Cell(0, startCol-1);
        cells[2] = new Cell(0, startCol+1);
        cells[3] = new Cell(1, startCol+1);
    }

    @Override
    public void rotate() {
        boolean canRotate = true;
        int row = cells[0].getRow();
        int col = cells[0].getCol();
        for (int i = 0; i < cells.length; ++i){
            if (!(row+next[type%4][i][0] < GameBoard.ROW && row+next[type%4][i][0] >= 0
                    && col+next[type%4][i][1] < GameBoard.COL && col+next[type%4][i][1] >=0)) {
                canRotate = false;
                break;
            }
        }
        if (canRotate) {
            for (int i = 0; i < cells.length; ++i) {
                cells[i].setRow(row + next[type % 4][i][0]);
                cells[i].setCol(col + next[type % 4][i][1]);
            }
            type++;
        }
    }
}

/**
 * [][][][]
 */
class E extends Square{
    int[][][] next = {{{0, 0}, {0, -1}, {0, 1}, {0, 2}},
            {{0, 0}, {1, 0}, {-1, 0}, {-2, 0}}};
    public E(int startCol){
        cells[0] = new Cell(0, startCol);
        cells[1] = new Cell(0, startCol-1);
        cells[2] = new Cell(0, startCol+1);
        cells[3] = new Cell(0, startCol+2);
    }

    @Override
    public void rotate() {
        boolean canRotate = true;
        int row = cells[0].getRow();
        int col = cells[0].getCol();
        for (int i = 0; i < cells.length; ++i){
            if (!(row+next[type%2][i][0] < GameBoard.ROW && row+next[type%2][i][0] >= 0
                    && col+next[type%2][i][1] < GameBoard.COL && col+next[type%2][i][1] >= 0)) {
                canRotate = false;
                break;
            }
        }
        if (canRotate) {
            for (int i = 0; i < cells.length; ++i) {
                cells[i].setRow(row + next[type % 2][i][0]);
                cells[i].setCol(col + next[type % 2][i][1]);
            }
            type++;
        }
    }
}

/**
 * [][]
 *   [][]
 */
class F extends Square{
    int[][][] next = {{{0, 0}, {-1, -1}, {-1, 0}, {0, 1}},
            {{0, 0}, {-1, 1}, {0, 1}, {1, 0}}};
    public F(int startCol){
        cells[0] = new Cell(1, startCol);
        cells[1] = new Cell(0, startCol-1);
        cells[2] = new Cell(0, startCol);
        cells[3] = new Cell(1, startCol+1);
    }

    @Override
    public void rotate() {
        boolean canRotate = true;
        int row = cells[0].getRow();
        int col = cells[0].getCol();
        for (int i = 0; i < cells.length; ++i){
            if (!(row+next[type%2][i][0] < GameBoard.ROW && row+next[type%2][i][0] >= 0
                    && col+next[type%2][i][1] < GameBoard.COL && col+next[type%2][i][1] >=0)) {
                canRotate = false;
                break;
            }
        }
        if (canRotate) {
            for (int i = 0; i < cells.length; ++i) {
                cells[i].setRow(row + next[type % 2][i][0]);
                cells[i].setCol(col + next[type % 2][i][1]);
            }
            type++;
        }
    }
}

/**
 *   [][]
 * [][]
 */
class G extends Square{
    int[][][] next = {{{0, 0}, {-1, 1}, {-1, 0}, {0, -1}},
            {{0, 0}, {-1, -1}, {0, -1}, {1, 0}}};
    public G(int startCol){
        cells[0] = new Cell(1, startCol);
        cells[1] = new Cell(0, startCol+1);
        cells[2] = new Cell(0, startCol);
        cells[3] = new Cell(1, startCol-1);
    }

    @Override
    public void rotate() {
        boolean canRotate = true;
        int row = cells[0].getRow();
        int col = cells[0].getCol();
        for (int i = 0; i < cells.length; ++i){
            if (!(row+next[type%2][i][0] < GameBoard.ROW && row+next[type%2][i][0] >= 0
                    && col+next[type%2][i][1] < GameBoard.COL && col+next[type%2][i][1] >=0)) {
                canRotate = false;
                break;
            }
        }
        if (canRotate) {
            for (int i = 0; i < cells.length; ++i) {
                cells[i].setRow(row + next[type % 2][i][0]);
                cells[i].setCol(col + next[type % 2][i][1]);
            }
            type++;
        }
    }
}

