package Tetris;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Cell {
    // 单元格所在行，列，图片，尺寸
    private int row, col;
    public static final int SIZE = 35;
    private static BufferedImage image;
    // 加载图片资源
    static
    {
        try {
            image = ImageIO.read(Cell.class.getResource("/Tetris/tetris.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 构造函数
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
    // get,set方法
    public BufferedImage getImage() {
        return image;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    // 移动
    public void goDown(){
        row++;
    }
    public void goRight(){
        col++;
    }
    public void goLeft(){
        col--;
    }
}
