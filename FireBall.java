import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FireBall {

    //public ArrayList<Integer> balls = new ArrayList<>();
    Character character;
    public double x;
    public double y;
    public double xR;
    public double yR;
    public int radius;
    public double speed;
    public int num;
    public int k;

    public FireBall(Character character, double x, double y, double xL, double yL, int i, int k, int radius) {
        this.character = character;
        this.radius = radius;
        this.x = xL;
        this.y = yL;
        xR = x - this.x;
        yR = y - this.y;
        if (k == 2) {
            this.speed = 0.5;
        } else {
            this.speed = 1;
        }
        this.num = i;
        this.k = k;
    }

    public void drawBall(Graphics g) {
        if (k == 2) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.red);
        }
        g.drawOval((int) x, (int) y, radius, radius);
        g.setColor(new Color(0xFF000D01, true));
    }

    public void update(long dt) {
            this.x += speed * (xR/Math.sqrt(xR*xR + yR*yR)) * dt;
            this.y += speed * (yR/Math.sqrt(xR*xR + yR*yR)) * dt;
            //System.out.println(x);
    }

    public void changeLocation(int x) {
        if (character.startGame) {
            if (x == 1) {
                this.y = this.y + 1000;
            } else if (x == 2) {
                this.x = this.x - 1000;
            } else if (x == 3) {
                this.y = this.y - 1000;
            } else if (x == 4) {
                this.x = this.x + 1000;
            }
        }

    }
}
