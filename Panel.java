import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

public class Panel extends JPanel implements KeyListener, ActionListener {

    private final Timer time;
    private ArrayList<Enemy> enemies;
    private int amountOfEnemies = 2;
    private int speedX = 400;
    private int speedY = 1;
    private int gameSpeed = 3;

    private boolean run = true;
    private final Player player = new Player(speedX, 510, 50, 50);
    private final Score score = new Score();

    public Panel() throws IOException {
        time = new Timer( 10, this);
        time.start();
        enemies = Enemy.createEnemies(amountOfEnemies);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);
    }

    public void reset() {
        score.resetScore();
        amountOfEnemies = 2;
        speedX = 400;
        speedY = 1;
        gameSpeed = 3;
        run = true;
        enemies = Enemy.createEnemies(amountOfEnemies);
    }

    public void paint(Graphics g) {
        // Set background color
        g.setColor(Color.black);
        g.fillRect(0,0,920,600);

        // Set colors for enemies
        Enemy.drawEnemies(g, enemies, Color.CYAN);

        // Set color for player and draw him
        player.drawPlayer(g, Color.orange);

        // Set score Color
        score.drawScore(g, Color.GREEN);

        // Draw final score when game ends
        if (run==false) {
            score.drawEndScore(g);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        // Update player position
        player.updatePlayer(speedX);

        // Update enemy position
        speedY += gameSpeed;

        // Update enemy ArrayList
        Enemy.updateEnemies(1, this.enemies, speedY);

        // Check if enemy touch bottom of screen
        // And reset him to the top
        if (speedY >= 600) {
            speedY = 0;
            score.incrementScore();

            Enemy.updateEnemies(0, this.enemies, speedY);

            // Increase game speed every two points
            if (score.getScore() % 2 == 0) {
                gameSpeed++;
            }

            // Increase amount of enemies every five points
            if (score.getScore() % 5 == 0) {
                amountOfEnemies++;
                this.enemies = Enemy.createEnemies(amountOfEnemies);
            }
        }


        // Check if player intersects with one of enemies
        for (Enemy enemy : enemies) {
            if (enemy.getBounds().intersects(player.getBounds())) {
                run = false;
                time.stop();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        // Check which key was pressed and change x position
        if(e.getKeyCode() == KeyEvent.VK_A){
            if(speedX != 0){
                speedX -= player.getSpeedX();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            if(speedX !=0){
                speedX -= player.getSpeedX();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            if(speedX !=840){
                speedX += player.getSpeedX();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_F) {
            if (speedX != 840) {
                speedX += player.getSpeedX();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if (run==false) {
                reset();
                time.start();
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
