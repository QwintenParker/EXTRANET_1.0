import java.awt.*;
import java.util.ArrayList;

public class Wall {

    public double x;
    public double y;
    public double width;
    public double height;
    public Character character;
    public long previousWorldUpdateTime;
    public double speedX;
    public double speedY;
    public boolean wallL;
    public boolean wallR;
    public boolean wallU;
    public boolean wallD;
    public int num;

    public Wall(double x, double y, Character character, double width, double height, int n) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.character = character;
        this.speedX = 0.2;
        this.speedY = 0.2;
        this.wallL = false;
        this.wallR = false;
        this.wallU = false;
        this.wallD = false;
        this.previousWorldUpdateTime = System.currentTimeMillis();
        this.num = n;
    }

    public void checkObjects() {
        if (character.startGame) {
            if (character.x >= this.x && character.x <= this.x + width && character.y + 7  >= this.y && character.y + character.height - 7 <= this.y + height) {
                character.x = x + width;
            }

            if (character.x + character.width >= this.x && character.x + character.width <= this.x + width && character.y + 7 >= this.y && character.y + character.height - 7 <= this.y + height) {
                character.x = x - 50;
            }

            if (character.x + 7 >= this.x && character.x + character.width - 7 <= x + width && character.y >= y && character.y <= y + height) {
                character.y = y + height;
            }

            if (character.x + 7 >= this.x && character.x + character.width - 7 <= this.x + width && character.y + character.height >= this.y && character.y + character.height <= this.y + height) {
                character.y = y - 50;
            }
        }


    }

    public void checkObjects(Boss boss) {
        if (character.startGame) {
            if (boss.x >= this.x && boss.x <= this.x + width && boss.y + 7  >= this.y && boss.y + boss.height - 7 <= this.y + height) {
                boss.x = x + width;
                boss.xH = boss.x + 50;
            }

            if (boss.x + boss.width >= this.x && boss.x + boss.width <= this.x + width && boss.y + 7 >= this.y && boss.y + boss.height - 7 <= this.y + height) {
                boss.x = x - boss.width;
                boss.xH = boss.x + 50;
            }

            if (boss.x + 7 >= this.x && boss.x + boss.width - 7 <= x + width && boss.y >= y && boss.y <= y + height) {
                boss.y = y + height;
                boss.yH = boss.y - 20;
            }

            if (boss.x + 7 >= this.x && boss.x + boss.width - 7 <= this.x + width && boss.y + boss.height >= this.y && boss.y + boss.height <= this.y + height) {
                boss.y = y - boss.width;
                boss.yH = boss.y - 20;
            }
        }


    }

    public void checkObjects(Enemy enemy) {
        if (character.startGame) {
            if (enemy.x >= this.x && enemy.x <= this.x + width && enemy.y + enemy.height - 7 >= this.y && enemy.y + 7 <= this.y + height) {
                if (num == 2) {
                    System.out.println("22222");
                    enemy.x = character.x + character.width + 10;
                } else {
                    enemy.x = x + width;
                }
                enemy.xH = enemy.x + 5;
            }

            if (enemy.x + enemy.width >= this.x && enemy.x + enemy.width <= this.x + width && enemy.y + enemy.height - 7 >= this.y && enemy.y + 7 <= this.y + height) {
                if (num == 4) {
                    System.out.println("44444");
                    enemy.x = character.x - 10;
                } else {
                    enemy.x = x - 40;
                }
                enemy.xH = enemy.x + 5;
            }

            if (enemy.x + enemy.width - 7 >= this.x && enemy.x + 7 <= x + width && enemy.y >= y && enemy.y <= y + height) {
                if (num == 3) {
                    System.out.println("33333");
                    enemy.y = character.y + height + 10;
                } else {
                    enemy.y = y + height;
                }
                enemy.yH = enemy.y - 10;
            }

            if (enemy.x + enemy.width - 7 >= this.x && enemy.x + 7 <= this.x + width && enemy.y + enemy.height >= this.y && enemy.y + enemy.height <= this.y + height) {
                if (num == 1) {
                    System.out.println("11111");
                    enemy.y = character.y - 10;
                } else {
                    enemy.y = y - 40;
                }
                enemy.yH = enemy.y - 10;
            }
        }


    }

    public void checkObjects(EnemySnyp enemy) {
        if (character.startGame) {
            if (enemy.x >= this.x && enemy.x <= this.x + width && enemy.y + enemy.height - 7 >= this.y && enemy.y + 7 <= this.y + height) {
                if (num == 2) {
                    System.out.println("22222");
                    enemy.x = character.x + character.width + 10;
                } else {
                    enemy.x = x + width;
                }
                enemy.xH = enemy.x + 5;
            }

            if (enemy.x + enemy.width >= this.x && enemy.x + enemy.width <= this.x + width && enemy.y + enemy.height - 7 >= this.y && enemy.y + 7 <= this.y + height) {
                if (num == 4) {
                    System.out.println("44444");
                    enemy.x = character.x - 10;
                } else {
                    enemy.x = x - 40;
                }
                enemy.xH = enemy.x + 5;
            }

            if (enemy.x + enemy.width - 7 >= this.x && enemy.x + 7 <= x + width && enemy.y >= y && enemy.y <= y + height) {
                if (num == 3) {
                    System.out.println("33333");
                    enemy.y = character.y + height + 10;
                } else {
                    enemy.y = y + height;
                }
                enemy.yH = enemy.y - 10;
            }

            if (enemy.x + enemy.width - 7 >= this.x && enemy.x + 7 <= this.x + width && enemy.y + enemy.height >= this.y && enemy.y + enemy.height <= this.y + height) {
                if (num == 1) {
                    System.out.println("11111");
                    enemy.y = character.y - 10;
                } else {
                    enemy.y = y - 40;
                }
                enemy.yH = enemy.y - 10;
            }
        }


    }

    public void checkObjects(FireBall ball) {
        if (character.startGame) {
            if (ball.x + ball.radius >= this.x && ball.x <= this.x + width && ball.y + ball.radius >= this.y && ball.y <= this.y + height) {
                if (ball.k == 0) {
                    character.removeBall(ball.num);
                }
            }
        }
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

    public void changeNLocation(int nX, int nY) {
        x = x + 1000 * nX;
        y = y + 1000 * nY;
    }



    public void draw(Graphics g) {
        if (character.startGame) {
            g.setColor(Color.GREEN);
            g.drawRect((int) x, (int) y, (int) width, (int) height);
            g.setColor(new Color(0xFF000D01));
            this.checkObjects();
        }

    }

}
