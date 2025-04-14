import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Score {
    private  int score = 0;

    public void incrementScore() {
        this.score++;
    }
    public void resetScore() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void drawScore(Graphics g, Color color) {
        g.setColor(color);
        g.setFont(new Font("Ariel",Font.BOLD, 20 ));
        g.drawString("Punkty: " + score, 10 , 20);
    }

    public void drawEndScore(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Ariel",Font.BOLD, 30 ));
        g.drawString("Chcesz kontyunowac gre? wcisnij 'Enter' ",200,300);
        g.setFont(new Font("Ariel",Font.BOLD, 30 ));
        g.drawString("twoje punkty wynoszą: " + score,200,330);
    }

}
