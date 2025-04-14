import java.awt.*;
public class Player extends Rectangle{
    private int x = 400;
    private int y = 510;
    private int width = 50;
    private int height = 50;

    private int speedX = 40;


    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void updatePlayer(int x) {
        this.x = x;
    }

    public  int getSpeedX() {
        return speedX;
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

    public void drawPlayer(Graphics g, Color color) {
        g.setColor(Color.orange);
        g.fillRect(x, y, width, height);
    }


    public Rectangle getBounds() {
        return new Rectangle(getXInt(), getYInt(), getWidthInt(), getHeightInt());
    }

}
