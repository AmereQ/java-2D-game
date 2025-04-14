import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class Enemy extends Rectangle{
    private int x = 0;
    private int y = 0;
    private int width = 80;
    private int height = 80;
    private int speedY = 1;


    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void update(int x, int y, int width, int height) {
        this.x = x;
        this.y =y;
        this.width = width;
        this.height = height;
    }

    public int getSpeedY() {
        return speedY;
    }
    public void setSpeedY(int speedY) {
       this.speedY =  speedY;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getXInt() {
        return x;
    }
    public int getYInt() {
        return y;
    }
    public int getWidthInt() {
        return width;
    }
    public int getHeightInt() {
        return height;
    }
    public Rectangle getBounds() {
        return new Rectangle(getXInt(), getYInt(), getWidthInt(), getHeightInt());
    }


    public static ArrayList<Enemy> createEnemies(int size) {
        ArrayList<Enemy> enemies  = new ArrayList<Enemy>();
        Random rand = new Random();
        int x = rand.nextInt(32) * 25;
        for (int i = 0; i < size; i++) {
            Enemy newEnemy = new Enemy(x, 0, 80, 80);
            enemies.add(newEnemy);
        }
        return enemies;
    }

    public static void updateEnemies(int parm, ArrayList<Enemy> enemies, int speedy) {
        for (Enemy enemy1 : enemies) {
            if (parm == 1) {
                enemy1.update(enemy1.getXInt(), speedy, enemy1.getWidthInt(), enemy1.getHeightInt());
            } else {
                Random rand = new Random();
                int x = rand.nextInt(32) * 25;
                enemy1.update(x, speedy, enemy1.getWidthInt(), enemy1.getHeightInt());
            }
        }
    }

    public static void drawEnemies(Graphics g, ArrayList<Enemy> enemies, Color color) {
        for (Enemy enemy: enemies) {
            g.setColor(color);
            g.fillRect(enemy.getXInt(), enemy.getYInt(), enemy.getWidthInt(),  enemy.getHeightInt());
        }
    }
}
