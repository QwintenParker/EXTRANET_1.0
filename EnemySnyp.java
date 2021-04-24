import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EnemySnyp {

    public double x;
    public double y;
    public double width;
    public double height;
    private double enemySpeedX;
    private double enemySpeedY;
    public Character character;
    private int enemyGoX;
    private int enemyGoY;
    public double xH;
    public double yH;
    public int startEnemy;
    public double enemyHealth;
    public boolean canHit;
    public boolean drawHealth;
    public boolean drawEnemy;
    public boolean go;
    private long previousWorldUpdateTime;
    public ArrayList<FireBall> enemyBalls = new ArrayList<>();

    public EnemySnyp(double x, double y, Character character) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
        this.xH = x + 5;
        this.yH = y - 10;
        this.enemySpeedX = 0.1;
        this.enemySpeedY = 0.1;
        this.character = character;
        this.enemyGoX = 0;
        this.enemyGoY = 0;
        this.startEnemy = 0;
        this.enemyHealth = 100;
        this.canHit = true;
        this.drawHealth = false;
        this.drawEnemy = true;
        previousWorldUpdateTime = System.currentTimeMillis();
        this.go = false;

    }

    public void draw(Graphics g) {
        if (character.startGame) {
            if (drawEnemy) {
                g.setColor(Color.cyan);
                g.fillRect((int) x, (int) y, (int) width, (int) height);
                g.setColor(Color.black);
                g.drawRect((int) x, (int) y, (int) width, (int) height);
                if (drawHealth) {
                    g.setColor(Color.ORANGE);
                    g.drawString(String.valueOf(enemyHealth), (int) xH, (int) yH);
                    g.setColor(Color.black);
                }

                for (int i = 0; i < enemyBalls.size(); i++) {
                    (enemyBalls.get(i)).drawBall(g);
                    enemyBalls.get(i).num = i;
                }
            }
        }
    }


    public void update(long dt) {
        if (character.startGame && !character.pause) {
            if (drawEnemy) {
                if (enemyHealth <= 0) {
                    x = 999999999;
                    y = 999999999;
                    xH = x + 10;
                    yH = y - 10;
                    drawHealth = false;
                    drawEnemy = false;
                    canHit = false;
                    character.characterHealth += 10;
                    character.coins = character.coins + Math.random() * 51;
                    //enemyHealth = 100;
                }



                if (!(character.x + character.width >= x - 100 && character.x <= x + width + 100 && character.y + character.height >= y - 100 && character.y <= y + height + 100)) {
                    enemyGoX = 0;
                    enemyGoY = 0;
                } else {
                    if (character.x + character.width >= x - 100 && character.x + character.width <= x + 20) {
                        enemyGoX = 1;
                    } else if (character.x > x + 20 && character.x <= x + width + 100) {
                        enemyGoX = -1;
                    } else if (!(character.x + character.width >= x - 100 && character.x <= x + width + 100)) {
                        enemyGoX = 0;
                    }


                    if (character.y + character.height >= y - 100 && character.y + character.height < y + 20) {
                        enemyGoY = 1;
                    } else if (character.y > y + 20 && character.y <= y + height + 100) {
                        enemyGoY = -1;
                    } else if (!(character.y + character.height >= y - 100 && character.y <= y + height + 100)){
                        enemyGoY = 0;
                    }

                }





                if (character.x + character.width > x - 600 && character.x < x + 640 && character.y + character.height > y - 600 && character.y < y + 640) {
                    go = true;
                }
                if (go) {
                    x += enemyGoX * enemySpeedX * dt;
                    y += enemyGoY * enemySpeedY * dt;
                    xH += enemyGoX * enemySpeedX * dt;
                    yH += enemyGoY * enemySpeedY * dt;
                    drawHealth = true;

                }

                for (int i = 0; i < enemyBalls.size(); i++) {
                    enemyBalls.get(i).update(dt);
                }

            }
        }


    }

    public void checkAnotherEnemy(Enemy enemy) {
        if (character.startGame) {
            if (x + width > character.x - 10 && x < character.x + character.width + 10 && y + height > character.y - 10 && y < character.y + character.height + 10) {
                if (enemy.x >= this.x && enemy.x <= this.x + width && enemy.y + height - 7 >= this.y && enemy.y + 7 <= this.y + height) {
                    enemy.x = this.x + width;
                    enemy.xH = enemy.x + 5;
                }

                if (enemy.x + width >= this.x && enemy.x + width <= this.x + width && enemy.y + height - 7 >= this.y && enemy.y + 7 <= this.y + height) {
                    enemy.x = this.x - width;
                    enemy.xH = enemy.x + 5;
                }

                if (enemy.y >= this.y && enemy.y <= this.y + width && enemy.x + height - 7 >= this.x && enemy.x + 7 <= this.x + height) {
                    enemy.y = this.y + width;
                    enemy.yH = enemy.y + 60;
                } else {
                    enemy.yH = enemy.y - 10;
                }

                if (enemy.y + width >= this.y && enemy.y + width <= this.y + width && enemy.x + height - 7 >= this.x && enemy.x + 7 <= this.x + height) {
                    enemy.y = this.y - width;
                    enemy.yH = enemy.y - 10;
                }
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

            for (int i = 0; i < enemyBalls.size(); i++) {
                enemyBalls.get(i).changeLocation(x);
            }
        }

    }

    public void createFireBalls() {
        long currentTime = System.currentTimeMillis();
        if (character.characterHealth > 0 && !character.pause) {
            if (go) {
                if ((currentTime - previousWorldUpdateTime) >= 2000) {
                    enemyBalls.add(new FireBall(character, character.x + 25, character.y + 25, x + 15, y + 15, enemyBalls.size(), 1, 10));
                    previousWorldUpdateTime = currentTime;
                }
            }
        }
    }

    public void updateBallDamage() {
        if (character.startGame && !character.pause) {
            for (int i = 0; i < enemyBalls.size(); i++) {
                FireBall ball = enemyBalls.get(i);
                if (ball.x >= character.x && ball.x <= character.x + character.width && ball.y >= character.y && ball.y <= character.y + character.height && ball.k == 1) {
                    character.characterHealth -= 5;
                    this.removeBall(ball.num);
                }
            }
        }
    }

    public void characterDamage(MouseEvent e) {
        if (character.startGame && !character.pause) {
            if (e.getX() >= this.x - 30 && e.getX() <= this.x + 70 && e.getY() >= this.y - 30 && e.getY() <= this.y + 70 && e.getButton() == 1) {
                if ((character.x <= this.x + width + 10 && character.x + character.width >= this.x - 10) && (character.y <= this.y + width + 10 && character.y + character.height >= this.y - 10)) {
                    if (character.characterHealth > 0) {
                        this.enemyHealth -= (int) ((Math.random() * (character.damageMax + 1)) + (character.damageMax/2));
                        System.out.println("Yes");
                    }
                }
            }
        }
    }

    public void damageByBall(FireBall ball) {
        if (ball.x + ball.radius >= x && ball.x <= x + width && ball.y + ball.radius >= y && ball.y <= y + height && ball.k == 0) {
            character.removeBall(ball.num);
            enemyHealth -= character.ballDamage;
            go = true;
        }
    }

    public void checkObjects(Wall wall) {
        if (character.startGame) {
            for (int i = 0; i < enemyBalls.size(); i++) {
                FireBall ball = enemyBalls.get(i);
                if (ball.x + ball.radius >= wall.x && ball.x <= wall.x + wall.width && ball.y + ball.radius >= wall.y && ball.y <= wall.y + wall.height) {
                    if (ball.k == 1) {
                        this.removeBall(ball.num);
                    }
                }
            }
        }
    }

    public void removeBall(int n) {
        int num1 = n;
        enemyBalls.remove(num1);
        System.out.println("R" + n);
    }
}