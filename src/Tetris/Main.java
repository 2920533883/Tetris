package Tetris;

import javax.swing.JFrame;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * A -- 左移
 * S -- 下降
 * D -- 右移
 * G -- 旋转
 */
public class Main{
    public static void main(String[] args){
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("俄罗斯方块");
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setBounds(600, 0, 600, 800);
        GameBoard gameBoard = new GameBoard();
        mainFrame.add(gameBoard, BorderLayout.CENTER);
        mainFrame.addKeyListener(new KeyContral(gameBoard));
        Timer timer1 = new Timer(); // 自动移动
        Timer timer2 = new Timer(); // 用户行为
        timer1.schedule(new TimerTask() {
        @Override
        synchronized public void run() {
            gameBoard.autoDown();
            mainFrame.repaint();
        }
    }, 0, 1000);
        timer2.schedule(new TimerTask() {
        @Override
        synchronized public void run() {
            mainFrame.repaint();
        }
    }, 0, 100);
        mainFrame.setVisible(true);
    }
}
