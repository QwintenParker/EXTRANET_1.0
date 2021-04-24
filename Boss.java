import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Boss {

    public double x;
    public double y;
    public double xH;
    public double yH;
    Character character;
    public double width;
    public double height;
    public Font font1;
    public Font font2;
    public double bossHealth;
    public int runningX;
    public int runningY;
    public double speedX;
    public double speedY;
    public boolean go;
    public long previousWorldUpdateTime;
    public int hitFirst;
    public ArrayList<FireBall> bossBalls = new ArrayList<>();

    public Boss(Character character, double x,  double y) {
        this.x = x;
        this.y = y;
        this.character = character;
        width = 350;
        height = 350;
        font1 = new Font("TimesRoman", Font.BOLD, 30);
        font2 = new Font("TimesRomab", Font.PLAIN, 12);
        bossHealth = 1000;
        xH = x + 40;
        yH = y - 20;
        speedX = 0.07;
        speedY = 0.07;
        go = false;
        hitFirst = 0;
        previousWorldUpdateTime = System.currentTimeMillis();
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, (int) width, (int) height);
        g.setColor(Color.white);
        g.setFont(font1);
        g.drawString(String.valueOf(bossHealth), (int) xH, (int) yH);
        g.setFont(font2);
        g.setColor(new Color(0xFF000D01, true));

        for (int i = 0; i < bossBalls.size(); i++) {
            (bossBalls.get(i)).drawBall(g);;
            bossBalls.get(i).num = i;
        }
    }

    public void updateBoss(long dt) {
        if (character.startGame && !character.pause) {
            if (bossHealth <= 0) {
                go = false;
                x = -999999999;
                y = -999999999;
                character.win = true;
            }



            if (x >= character.x - 150 && x + width <= character.x + 200 && y >= character.y - 150 && y + height <= character.y + 20) {
                runningX = 0;
                runningY = 0;
            } else {
                if (character.x + 25 > x + 77) {
                    runningX = 1;
                } else if (character.x + 25 < x + 73) {
                    runningX = -1;
                } else if (character.x + 25 <= x + 77 && character.x + 25 >= x + 73) {
                    runningX = 0;
                }


                //if (go) {
                if (character.y + 25 > y + 77) {
                    runningY = 1;
                } else if (character.y + 25 < y + 73) {
                    runningY = -1;
                } else if (character.y + 25 <= y + 77 && character.y + 25 >= y + 73) {
                    runningY = 0;
                }
            }

            if (character.x + character.width > x - 600 && character.x < x + 750 && character.y + character.height > y - 600 && character.y < y + 750) {
                go = true;
            }
            if (go) {
                x += runningX * speedX * dt;
                y += runningY * speedY * dt;
                xH = x + 40;
                yH = y - 20;

            }

            for (int i = 0; i < bossBalls.size(); i++) {
                bossBalls.get(i).update(dt);
            }
        }
    }

    public void changeLocation(int x) {
        if (character.startGame) {
            if (x == 1) {
                this.y = this.y + 1000;
                this.yH = this.yH + 1000;
            } else if (x == 2) {
                this.x = this.x - 1000;
                this.xH = this.xH - 1000;
            } else if (x == 3) {
                this.y = this.y - 1000;
                this.yH = this.yH - 1000;
            } else if (x == 4) {
                this.x = this.x + 1000;
                this.xH = this.xH + 1000;
            }

            for (int i = 0; i < bossBalls.size(); i++) {
                bossBalls.get(i).changeLocation(x);
            }
        }

    }

    public void updateDamage() {
        if (character.startGame && !character.pause) {
            if ((character.x - 5 <= x + width && character.x + 55 >= x) && (character.y - 5 <= y + height && character.y + 55 >= y)) {
                long currentTime1 = System.currentTimeMillis();
                if ((currentTime1 - previousWorldUpdateTime) >= 2000) {
                    if (character.characterHealth > 0 && hitFirst == 1) {
                        previousWorldUpdateTime = currentTime1;
                        character.characterHealth -= (int) (Math.random() * 11) + 20;
                        System.out.println("BIG HIT");
                    } else {
                        previousWorldUpdateTime = currentTime1;
                        hitFirst = 1;
                    }
                }

            } else {
                hitFirst = 0;
            }
        }
    }

    public void characterDamage(MouseEvent e) {
        if (character.startGame && !character.pause) {
            if (e.getX() >= this.x && e.getX() <= this.x + width && e.getY() >= this.y && e.getY() <= this.y + height && e.getButton() == 1) {
                if ((character.x - 5 <= this.x + width && character.x + 55 >= this.x) && (character.y - 5 <= this.y + height && character.y + 55 >= this.y)) {
                    if (character.characterHealth > 0) {
                        this.bossHealth -= (int) ((Math.random() * (character.damageMax + 1)) + (character.damageMax/2));
                        System.out.println("Yes");
                    }
                }
            }
        }
    }

    public void createFireBalls() {
        long currentTime = System.currentTimeMillis();
        if (character.characterHealth > 0 && !character.pause) {
            if (go) {
                if ((currentTime - previousWorldUpdateTime) >= 900) {
                    bossBalls.add(new FireBall(character, character.x, character.y, x + 125, y + 125, bossBalls.size(), 2, 50));
                    previousWorldUpdateTime = currentTime;
                }
            }
        }
    }

    public void updateBallDamage() {
        if (character.startGame && !character.pause) {
            for (int i = 0; i < bossBalls.size(); i++) {
                FireBall ball = bossBalls.get(i);
                if (ball.x + ball.radius >= character.x && ball.x <= character.x + character.width && ball.y + ball.radius >= character.y && ball.y <= character.y + character.height && ball.k == 2) {
                    character.characterHealth -= 25;
                    this.removeBall(ball.num);
                }
            }
        }
    }

    public void checkObjects(Wall wall) {
        if (character.startGame) {
            for (int i = 0; i < bossBalls.size(); i++) {
                FireBall ball = bossBalls.get(i);
                if (ball.x + ball.radius >= wall.x && ball.x <= wall.x + wall.width && ball.y + ball.radius >= wall.y && ball.y <= wall.y + wall.height) {
                    if (ball.k == 2) {
                        this.removeBall(ball.num);
                    }
                }
            }
        }
    }

    public void damageByBall(FireBall ball) {
        if (ball.x + ball.radius >= x && ball.x <= x + width && ball.y + ball.radius >= y && ball.y <= y + height && ball.k == 0) {
            character.removeBall(ball.num);
            bossHealth -= character.ballDamage;
            go = true;
        }
    }

    public void removeBall(int n) {
        int num1 = n;
        bossBalls.remove(num1);
        System.out.println("R" + n);
    }

}
