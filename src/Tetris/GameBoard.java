package Tetris;

import javax.swing.*;
import java.awt.*;
public class GameBoard extends JPanel {
    private int score = 0;
    public static final int ROW = 20;
    public static final int COL = 12;
    Cell[][] background = new Cell[ROW][COL];
    Square currentSquare = new Square().getSquare();
    // 重写paint方法
    @Override
    public void paint(Graphics g) {
        drawBackground(g);
        drawSquare(g);
        drawOtherMsg(g);
    }
    // 画其他信息
    private void drawOtherMsg(Graphics g){
        g.drawRect(450, 100, 100, 100);
        String scoreMsg = "得分：" + score;
        g.drawString("计科1804张瑞丰", 460, 400);
        Font font = new Font("黑体", Font.PLAIN, 20);
        g.setFont(font);
        g.drawString(scoreMsg, 460, 160);
    }
    // 画方块
    private void drawSquare(Graphics g){
        Cell[] cells = currentSquare.cells;
        for (Cell cell : cells) {
            g.drawImage(cell.getImage(), cell.getCol() * Cell.SIZE, cell.getRow() * Cell.SIZE, null);
        }
    }
    // 画背景
    private void drawBackground(Graphics g){
        for (int row = 0; row < ROW; ++row){
            for (int col = 0; col < COL; ++col){
                if (background[row][col] == null) g.drawRect(col*Cell.SIZE, row*Cell.SIZE, Cell.SIZE, Cell.SIZE);
                else g.drawImage(background[row][col].getImage(), col*Cell.SIZE, row*Cell.SIZE, null);
            }
        }
    }
    // 判断是否可以移动
    public boolean canMove(int drow, int dcol){
        Cell[] cells = currentSquare.cells;
        for (Cell cell: cells) {
            int nextCol = dcol+cell.getCol();
            int nextRow = drow+cell.getRow();
            if (nextCol >= COL || nextCol < 0) return false;
            else if (nextRow >= ROW) return false;
            else if (background[nextRow][nextCol] != null) return false;
        }
        return true;
    }
    // 自动下落
    public void autoDown(){
        Cell[] cells = currentSquare.cells;
        if (canMove(1, 0)) {
            for (Cell cell : cells) {
                cell.goDown();
            }
        }
        else {
            turnToBackground();
            if (isGameOver()) {
                if (JOptionPane.showConfirmDialog(null, "游戏结束！得分"+score+"\n是否继续？", "GameOver", JOptionPane.YES_NO_OPTION) == 0){
                    background = new Cell[ROW][COL];
                    score = 0;
                } else {
                    System.exit(0);
                }
            }
            getScore();
        }
    }
    // 放好后方块变为背景的一部分
    public void turnToBackground(){
        Cell[] cells = currentSquare.cells;
        for (Cell cell : cells) {
            background[cell.getRow()][cell.getCol()] = cell;
        }
        currentSquare = new Square().getSquare();
    }
    // 检查是否得分
    public void getScore(){
        int start;
        boolean flag = true;
        for (int row = 0; row < ROW; row++){
            for (int col = 0; col < COL; col++) {
                if (background[row][col] == null) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int col = 0; col < COL; ++col) {
                    background[row][col] = null;
                }
                start = row;
                System.out.println(start);
                score++;
                for (int roww = start; roww > 0; roww--){
                    System.arraycopy(background[roww - 1], 0, background[roww], 0, COL);
                }
            }
            else {
                flag = true;
            }
        }
    }
    // 判断游戏是否结束
    public boolean isGameOver(){
        for (int col = 0; col < COL; ++col){
            if (background[0][col] != null) return true;
        }
        return false;
    }
}
