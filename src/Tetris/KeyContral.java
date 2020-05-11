package Tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyContral implements KeyListener {
    GameBoard gameBoard = null;
    public KeyContral(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Cell[] cells = gameBoard.currentSquare.cells;
        // A -- 左移
        if (e.getKeyCode() == KeyEvent.VK_A && gameBoard.canMove(0, -1)) {
            for (Cell cell : cells) {
                cell.goLeft();
            }
        }
        // D -- 右移
        if (e.getKeyCode() == KeyEvent.VK_D && gameBoard.canMove(0, 1)) {
            for (Cell cell : cells) {
                cell.goRight();
            }
        }
        // S -- 下降
        if (e.getKeyCode() == KeyEvent.VK_S && gameBoard.canMove(1, 0)) {
            for (Cell cell : cells) {
                cell.goDown();
            }
        }
        // G -- 旋转
        if (e.getKeyCode() == KeyEvent.VK_G){
            gameBoard.currentSquare.rotate();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
