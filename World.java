import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class World {

    public ArrayList<Wall> walls = new ArrayList<Wall>();
    public ArrayList<Enemy> enemies = new ArrayList<>();
    public ArrayList<EnemySnyp> enemySnyps = new ArrayList<>();
    public ArrayList<Chest> chests = new ArrayList<>();
    public Character character;
    public Boss boss;
    public int runningX;
    public int runningY;
    public World(Character character, Boss boss) {
        this.character = character;
        this.runningX = 0;
        this.runningY = 0;
        this.boss = boss;
    }

    //public void createFirstWorld() {
    //    //0.0
    //    for (double i = 400; i <= 700;) {
    //        walls.add(new Wall(0, i, character, 25, 25, 4));
    //        i = i + 25;
    //    }
//
    //    for (double i = 0; i <= 975;) {
    //        walls.add(new Wall(i, 400, character, 25, 25, 1));
    //        i = i + 25;
    //    }
//
    //    for (double i = 0; i <= 975;) {
    //        walls.add(new Wall(i, 700, character, 25, 25, 3));
    //        i = i + 25;
    //    }
//
    //    //1.0
    //    for (double i = 1000; i <= 1975;) {
    //        walls.add(new Wall(i, 50, character, 25, 25, 1));
    //        i = i + 25;
    //    }
//
    //    for (double i = 1000; i <= 1500;) {
    //        walls.add(new Wall(i, 1025, character, 25, 25, 3));
    //        i = i + 25;
    //    }
//
    //    for (double i = 50; i <= 400;) {
    //        walls.add(new Wall(1000, i, character, 25, 25, 4));
    //        i = i + 25;
    //    }
//
    //    for (double i = 700; i <= 1025;) {
    //        walls.add(new Wall(1000, i, character, 25, 25, 4));
    //        i = i + 25;
    //    }
//
    //    for (double i = 50; i <= 1025;) {
    //        walls.add(new Wall(1975, i, character, 25, 25, 2));
    //        i = i + 25;
    //    }
//
    //}

    public void createFinaleWorld() {
        /*//0.0
        for (double i = 250; i <= 700;) {
            walls.add(new Wall(i, 250, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 250; i <= 350;) {
            walls.add(new Wall(i, 700, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 600; i <= 700;) {
            walls.add(new Wall(i, 700, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 250; i <= 700;) {
            walls.add(new Wall(250, i, character, 50, 50, 0));
            walls.add(new Wall(700, i, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 700; i <= 1000;) {
            walls.add(new Wall(350, i, character, 50, 50, 0));
            walls.add(new Wall(600, i, character, 50, 50, 0));
            i = i + 50;
        }

        //0.1
        for (double i = 1050; i <= 1350;) {
            walls.add(new Wall(350, i, character, 50, 50, 0));
            walls.add(new Wall(600, i, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 0; i <= 350;) {
            walls.add(new Wall(i, 1350, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 600; i <= 950;) {
            walls.add(new Wall(i, 1350, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 0; i <= 950;) {
            walls.add(new Wall(i, 1700, character, 50, 50, 0));
            i = i + 50;
        }

        //1.1
        for (double i = 1000; i <= 1950;) {
            walls.add(new Wall(i, 1350, character, 50, 50, 0));
            walls.add(new Wall(i, 1700, character, 50, 50, 0));
            i = i + 50;
        }
        //2.1
        for (double i = 2000; i <= 2950;) {
            walls.add(new Wall(i, 1050, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 1050; i <= 1350;) {
            walls.add(new Wall(2000, i, character, 50, 50, 0));
            walls.add(new Wall(2950, i, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 1700; i <= 2000;) {
            walls.add(new Wall(2000, i, character, 50, 50, 0));
            walls.add(new Wall(2950, i, character, 50, 50, 0));
            i = i + 50;
        }*/

        //0.0
        walls.add(new Wall(250, 250, character, 500, 50, 0));
        walls.add(new Wall(250, 250, character, 50, 500, 0));
        walls.add(new Wall(700, 250, character, 50, 500, 0));
        walls.add(new Wall(250, 700, character, 150, 50, 0));
        walls.add(new Wall(600, 700, character, 150, 50, 0));
        walls.add(new Wall(350, 700, character, 50, 350, 0));
        walls.add(new Wall(600, 700, character, 50, 350, 0));

        //0.1 , -1.1 , 1.1
        walls.add(new Wall(350, 1050, character, 50, 350, 0));
        walls.add(new Wall(600, 1050, character, 50, 350, 0));
        walls.add(new Wall(-1000, 1350, character, 1400, 50, 0));
        walls.add(new Wall(600, 1350, character, 1400, 50, 0));
        walls.add(new Wall(-1000, 1350, character, 1400, 50, 0));
        walls.add(new Wall(-1000, 1700, character, 3000, 50, 0));
        // temporary
        walls.add(new Wall(-1000, 1350, character, 50, 400, 0));
        //

        //2.1
        walls.add(new Wall(2000, 1050, character, 1000, 50, 0));
        walls.add(new Wall(2000, 1050, character, 50, 350, 0));
        walls.add(new Wall(2950, 1050, character, 50, 350, 0));
        walls.add(new Wall(2000, 1700, character, 50, 350, 0));
        walls.add(new Wall(2950, 1700, character, 50, 350, 0));
        walls.add(new Wall(2000, 2000, character, 350, 50, 0));
        walls.add(new Wall(2650, 2000, character, 350, 50, 0));

        //3.1 , 3.0
        walls.add(new Wall(3000, 1350, character, 350, 50, 0));
        walls.add(new Wall(3000, 1700, character, 700, 50, 0));
        walls.add(new Wall(3300, 700, character, 50, 700, 0));
        walls.add(new Wall(3650, 700, character, 50, 1050, 0));

        //3.0 , 2.0
        walls.add(new Wall(2650, 700, character, 700, 50, 0));
        walls.add(new Wall(2650, 350, character, 700, 50, 0));
        walls.add(new Wall(2650, 50, character, 50, 350, 0));
        walls.add(new Wall(2650, 700, character, 50, 350, 0));
        walls.add(new Wall(2350, 50, character, 350, 50,0));
        walls.add(new Wall(2350, 1000, character, 350, 50,0));
        walls.add(new Wall(2350, 50, character, 50, 1000, 0));

        //3.0 , 3.-1
        walls.add(new Wall(3300, -950, character, 50, 1350,0));
        walls.add(new Wall(3650, -950, character, 50, 1350,0));

        //3.-2
        walls.add(new Wall(3000, -1950, character, 1000, 50,0));
        walls.add(new Wall(3000, -1950, character, 50, 1000,0));
        walls.add(new Wall(3950, -1950, character, 50, 1000,0));
        walls.add(new Wall(3000, -1000, character, 350, 50,0));
        walls.add(new Wall(3650, -1000, character, 350, 50,0));

        //4.0 , 3.0
        walls.add(new Wall(3650, 350, character, 700, 50,0));
        walls.add(new Wall(3650, 700, character, 1050, 50,0));

        //4.-1 . 4.0
        walls.add(new Wall(4300, -650, character, 50, 1050,0));
        walls.add(new Wall(4650, -300, character, 50, 1050,0));
        walls.add(new Wall(4300, -650, character, 700, 50,0));
        walls.add(new Wall(4650, -300, character, 350, 50,0));

        //5.-1
        walls.add(new Wall(5000, -950, character, 1000, 50,0));
        walls.add(new Wall(5000, 0, character, 1000, 50,0));
        walls.add(new Wall(5000, -950, character, 50, 350,0));
        walls.add(new Wall(5950, -950, character, 50, 350,0));
        walls.add(new Wall(5000, -300, character, 50, 350,0));
        walls.add(new Wall(5950, -300, character, 50, 350,0));

        //6.-1 , 6.0 , 6.1
        walls.add(new Wall(6000, -650, character, 700, 50,0));
        walls.add(new Wall(6000, -300, character, 350, 50,0));
        walls.add(new Wall(6300, -300, character, 50, 700,0));
        walls.add(new Wall(6650, -650, character, 50, 2050,0));

        //5.0 , 6.0
        walls.add(new Wall(5000, 350, character, 1350, 50,0));
        walls.add(new Wall(5000, 700, character, 1350, 50,0));
        walls.add(new Wall(5000, 350, character, 50, 350,0));

        //6.0 , 6.1 , 6.2
        walls.add(new Wall(6300, 700, character, 50, 1700,0));
        walls.add(new Wall(6650, 1700, character, 50, 1050,0));
        walls.add(new Wall(6650, 1350, character, 350, 50,0));
        walls.add(new Wall(6650, 1700, character, 350, 50,0));

        //5.2 , 6.2
        walls.add(new Wall(5300, 2350, character, 1050, 50,0));
        walls.add(new Wall(5650, 2700, character, 1050, 50,0));

        //5.2 , 5.3
        walls.add(new Wall(5300, 2350, character, 50, 1050,0));
        walls.add(new Wall(5650, 2700, character, 50, 1050,0));
        walls.add(new Wall(5000, 3350, character, 350, 50,0));
        walls.add(new Wall(5000, 3700, character, 700, 50,0));

        //4.3
        walls.add(new Wall(4000, 4000, character, 1000, 50,0));
        walls.add(new Wall(4000, 3050, character, 350, 50,0));
        walls.add(new Wall(4650, 3050, character, 350, 50,0));
        walls.add(new Wall(4000, 3050, character, 50, 350,0));
        walls.add(new Wall(4950, 3050, character, 50, 350,0));
        walls.add(new Wall(4000, 3700, character, 50, 350,0));
        walls.add(new Wall(4950, 3700, character, 50, 350,0));

        //4.1 , 4.2
        walls.add(new Wall(4000, 1050, character, 1000, 50,0));
        walls.add(new Wall(4000, 1050, character, 50, 350,0));
        walls.add(new Wall(4950, 1050, character, 50, 350,0));
        walls.add(new Wall(4000, 1350, character, 350, 50,0));
        walls.add(new Wall(4650, 1350, character, 350, 50,0));
        walls.add(new Wall(4300, 1350, character, 50, 1700,0));
        walls.add(new Wall(4650, 1350, character, 50, 1700,0));

        //2.3 , 3.3 , 2.2
        walls.add(new Wall(2650, 3350, character, 1350, 50,0));
        walls.add(new Wall(2300, 3700, character, 1700, 50,0));
        walls.add(new Wall(2300, 2050, character, 50, 1700,0));
        walls.add(new Wall(2650, 2050, character, 50, 1350,0));

        //7.1
        walls.add(new Wall(7000, 1050, character, 1000, 50,0));
        walls.add(new Wall(7000, 2000, character, 1000, 50,0));
        walls.add(new Wall(7000, 1050, character, 50, 350,0));
        walls.add(new Wall(7950, 1050, character, 50, 350,0));
        walls.add(new Wall(7000, 1700, character, 50, 350,0));
        walls.add(new Wall(7950, 1700, character, 50, 350,0));

        //8.1
        walls.add(new Wall(8000, 1350, character, 1000, 50,0));
        walls.add(new Wall(8000, 1700, character, 1000, 50,0));

        //9.1 , 9.2 , 10.1 , 10.2
        walls.add(new Wall(9000, 1050, character, 2000, 50,0));
        walls.add(new Wall(9000, 3000, character, 2000, 50,0));
        walls.add(new Wall(9000, 1050, character, 50, 350,0));
        walls.add(new Wall(9000, 1700, character, 50, 1350,0));
        walls.add(new Wall(10950, 1050, character, 50, 2000,0));

    }

    public void createEnemies() {
        enemies.add(new Enemy(- 850, 1440, character));
        enemies.add(new Enemy(- 850, 1530, character));
        enemies.add(new Enemy(- 850, 1620, character));
        enemies.add(new Enemy(2500, 1450, character));
        enemies.add(new Enemy(2500, 1540, character));
        enemies.add(new Enemy(2500, 1630, character));
        enemies.add(new Enemy(2430, 140, character));
        enemies.add(new Enemy(2430, 920, character));
        enemies.add(new Enemy(5100, - 800, character));
        enemies.add(new Enemy(5500, - 800, character));
        enemies.add(new Enemy(5800, - 800, character));
        enemies.add(new Enemy(5100, - 150, character));
        enemies.add(new Enemy(5500, - 150, character));
        enemies.add(new Enemy(5800, - 150, character));
        enemies.add(new Enemy(5200,  440, character));
        enemies.add(new Enemy(5200, 540, character));
        enemies.add(new Enemy(5200, 640, character));
        enemies.add(new Enemy(4480, 3100, character));
        enemies.add(new Enemy(4890, 3550, character));
        enemies.add(new Enemy(4480, 3800, character));
        enemies.add(new Enemy(7890, 1300, character));
        enemies.add(new Enemy(7890, 1500, character));
        enemies.add(new Enemy(7890, 1700, character));
        enemies.add(new Enemy(7200, 1250, character));
        enemies.add(new Enemy(7200, 1800, character));
    }

    public void createEnemySnyps() {
        enemySnyps.add(new EnemySnyp(2700, 1250, character));
        enemySnyps.add(new EnemySnyp(2700, 1800, character));
        enemySnyps.add(new EnemySnyp(4850, 3150, character));
        enemySnyps.add(new EnemySnyp(4850, 3800, character));
        enemySnyps.add(new EnemySnyp(7500, 1250, character));
        enemySnyps.add(new EnemySnyp(7500, 1800, character));
        enemySnyps.add(new EnemySnyp(5120, 540, character));
        enemySnyps.add(new EnemySnyp(4400, 1250, character));
        enemySnyps.add(new EnemySnyp(4480, 1250, character));
        enemySnyps.add(new EnemySnyp(4560, 1250, character));
        enemySnyps.add(new EnemySnyp(3200, -1850, character));
        enemySnyps.add(new EnemySnyp(3750, -1850, character));
        enemySnyps.add(new EnemySnyp(3200, -1200, character));
        enemySnyps.add(new EnemySnyp(3750, -1200, character));
        enemySnyps.add(new EnemySnyp(2500, 140, character));
        enemySnyps.add(new EnemySnyp(2500, 920, character));
    }

    public void createChests() {
        chests.add(new Chest(485, 430, character, 1));
        chests.add(new Chest(-900, 1550, character, 0));
        chests.add(new Chest(2450, 1550, character, 1));
        chests.add(new Chest(2200, 1200, character, 0));
        chests.add(new Chest(2800, 1900, character, 0));
        chests.add(new Chest(4450, 3550, character, 1));
        chests.add(new Chest(4100, 3200, character, 0));
        chests.add(new Chest(4100, 1200, character, 0));
        chests.add(new Chest(4850, 1200, character, 0));
        chests.add(new Chest(2450, 1550, character, 0));
        chests.add(new Chest(5100, 550, character, 0));
        chests.add(new Chest(8500, 1550, character, 1));
        chests.add(new Chest(2450, 550, character, 0));
        chests.add(new Chest(3500, 550, character, 1));
    }


    public void drawWalls(Graphics g) {
        if (character.startGame) {
            for (int i = 0; i < walls.size(); i++) {
                (walls.get(i)).draw(g);
            }
        }

    }

    public void drawChest(Graphics g) {
        if (character.startGame) {
            for (int i = 0; i < chests.size(); i++) {
                (chests.get(i)).draw(g);
            }

            for (int i = 0; i < chests.size(); i++) {
                (chests.get(i)).update();
            }
        }

    }

    public void drawEnemies(Graphics g) {
        if (character.startGame) {
            for (int i = 0; i < enemies.size(); i++) {
                (enemies.get(i)).draw(g);
                //System.out.println(enemies.get(0).x);
            }
        }
    }

    public void drawEnemySnyps(Graphics g) {
        if (character.startGame) {
            for (int i = 0; i < enemySnyps.size(); i++) {
                (enemySnyps.get(i)).draw(g);
            }
        }
    }

    public void updateEnemies(long dt) {
        if (character.startGame) {
            for (int i = 0; i < enemies.size(); i++) {
                (enemies.get(i)).update(dt);
                (enemies.get(i)).updateDamage();
            }

            for (int i = 0; i < enemySnyps.size(); i++) {
                (enemySnyps.get(i)).update(dt);
                (enemySnyps.get(i)).createFireBalls();
            }
        }
    }

    public void updateBallDamage() {
        for (int i = 0; i < enemySnyps.size(); i++) {
            enemySnyps.get(i).updateBallDamage();
        }
    }

    public void checkAnotherEnemy() {
        if (character.startGame) {
            for (int i = 0; i < enemies.size(); i++) {
                for (int j = 0; j < enemies.size(); j ++) {
                    if (i != j) {
                        (enemies.get(i)).checkAnotherEnemy(enemies.get(j));
                    }
                }
            }
        }

    }

    public void updateCharacterDamage(MouseEvent e) {
        if (character.startGame) {
            for (int i = 0; i < enemies.size(); i++) {
                (enemies.get(i)).characterDamage(e);
            }

            for (int j = 0; j < enemySnyps.size(); j++) {
                (enemySnyps.get(j)).characterDamage(e);
            }
        }
    }

    public void damageByBall() {
        if (character.startGame) {
            for (int i = 0; i < enemies.size(); i++) {
                for (int j = 0; j < character.balls.size(); j++) {
                    (enemies.get(i)).damageByBall(character.balls.get(j));
                }
            }

            for (int i = 0; i < enemySnyps.size(); i++) {
                for (int j = 0; j < character.balls.size(); j++) {
                    (enemySnyps.get(i)).damageByBall(character.balls.get(j));
                }
            }

        }
    }

    public void changeLocation(int x) {
        if (character.startGame) {
            for (int i = 0; i < walls.size(); i++) {
                (walls.get(i)).changeLocation(x);
            }

            for (int i = 0; i < enemies.size(); i++) {
                (enemies.get(i)).changeLocation(x);
            }

            for (int i = 0; i < chests.size(); i++) {
                (chests.get(i)).changeLocation(x);
            }

            for (int i = 0; i < enemySnyps.size(); i++) {
                (enemySnyps.get(i)).changeLocation(x);
            }

            for (int i = 0; i < character.balls.size(); i++) {
                (character.balls.get(i)).changeLocation(x);
            }

            boss.changeLocation(x);
        }

    }

    public void checkEnemyWalls() {
        if (character.startGame) {
            for (int i = 0; i < walls.size(); i++) {
                for (int j = 0; j < enemies.size() ; j++) {
                    (walls.get(i)).checkObjects(enemies.get(j));
                }
            }
        }
    }

    public void checkBossWalls() {
        if (character.startGame) {
            for (int i = 0; i < walls.size(); i++) {
                (walls.get(i)).checkObjects(boss);
            }
        }
    }

    public void checkEnemySnypeWalls() {
        if (character.startGame) {
            for (int i = 0; i < walls.size(); i++) {
                for (int j = 0; j < enemySnyps.size() ; j++) {
                    (walls.get(i)).checkObjects(enemySnyps.get(j));
                }
            }
        }
    }

    public void checkFireBalls() {
        if (character.startGame) {
            for (int i = 0; i < walls.size(); i++) {
                for (int j = 0; j < character.balls.size(); j++) {
                    (walls.get(i)).checkObjects(character.balls.get(j));
                }
            }

            for (int i = 0; i < enemySnyps.size(); i++) {
                for (int j = 0; j < walls.size(); j++) {
                    enemySnyps.get(i).checkObjects(walls.get(j));
                }
            }

            for (int j = 0; j < walls.size(); j++) {
                boss.checkObjects(walls.get(j));
            }

        }
    }

    public void openChest(MouseEvent e) {
        if (character.startGame) {
            for (int i = 0; i < chests.size(); i++) {
                (chests.get(i)).open(e);
            }
        }

    }


    public void createTestWorld() {
        for (double i = 300; i <= 650;) {
            walls.add(new Wall(i, 200, character, 25, 25, 0));
            i = i + 25;
        }

        for (double i = 200; i <= 650;) {
            walls.add(new Wall(300, i, character, 25, 25, 0));
            i = i + 25;
        }

        for (double i = 200; i <= 650;) {
            walls.add(new Wall(650, i, character, 25, 25, 0));
            i = i + 25;
        }

        for (double i = 1500; i <= 1875;) {
            walls.add(new Wall(i, 500, character, 25, 25, 0));
            i = i + 25;
        }

        for (double i = -500; i >= -875;) {
            walls.add(new Wall(i, -500, character, 25, 25, 0));
            i = i - 25;
        }
    }


}
