package com.ntm.bomberman;

import java.io.*;
import java.util.*;

import com.ntm.bomberman.entities.items.SpeedItem;
import com.ntm.bomberman.input.Keyboard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.*;

import com.ntm.bomberman.graphics.*;
import com.ntm.bomberman.entities.*;
import com.ntm.bomberman.entities.bomb.*;
import com.ntm.bomberman.entities.objects.*;
import com.ntm.bomberman.entities.movingEntities.*;
import com.ntm.bomberman.entities.movingEntities.enemies.*;
import com.ntm.bomberman.sound.Sound;
// import com.ntm.bomberman.entities.items.*;


public class BombermanGame extends Application {
    public int WIDTH;
    public int HEIGHT;

    private GraphicsContext gc;
    private Canvas canvas;
    private static List<Entity> entities = new ArrayList<>();
    private static List<Entity> friendlyEntities = new ArrayList<>();
    private static List<Entity> explosions = new ArrayList<>();
    private static List<Bomb> bombs = new ArrayList<>();
    private static int  speedItem = 0;

    private Bomber bomberman;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        this.createMap();
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH,
                Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        canvas.requestFocus();
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed((KeyEvent event) -> {
            Keyboard.handleMovement(event, bomberman);
        });

        // Tao root container
        // Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();
        Sound.play("sounds/howlingabyss_ingame.wav");
    }

    public void createMap() {
        try {

            BufferedReader fileReader =
                    new BufferedReader(new InputStreamReader(
                            new FileInputStream(
                                    "./src/resources/levels/Level1.txt"),
                            "UTF-8"));


            String line;
            line = fileReader.readLine();
            String[] args = line.split(" ");
            int L = Integer.parseInt(args[0]);
            int R = Integer.parseInt(args[1]);
            int C = Integer.parseInt(args[2]);
            HEIGHT = R;
            WIDTH = C;

            int n = -1;
            while ((line = fileReader.readLine()) != null) {
                n++;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '#') {
                        friendlyEntities
                                .add(new Wall(i, n, Sprites.wall.getFxImage()));
                    } else {
                        friendlyEntities.add(
                                new Grass(i, n, Sprites.grass.getFxImage()));
                    }
                }
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    // entities.add(new Grass(i, n,
                    // Sprites.grass.getFxImage()));
                    switch (c) {
                        case 'p': // bomber
                            bomberman = new Bomber(i, n,
                                    Sprites.player_right.getFxImage());
                            entities.add(bomberman);
                            break;
                        // objects
                        case '#': // wall
                            entities.add(
                                    new Wall(i, n, Sprites.wall.getFxImage()));
                            break;
                        case '*': {// brick
                            if (speedItem == 0) {
                                entities.add(new SpeedItem(i -1 , n,
                                        Sprites.powerup_speed.getFxImage()));
                                speedItem = 1;
                            }
                            entities.add(new Brick(i, n,
                                    Sprites.brick.getFxImage()));
                        }
                            break;

                        // items
                        case 'x': // portals
                            entities.add(new Portal(i, n,
                                    Sprites.portal.getFxImage()));
                            entities.add(new Brick(i, n,
                                    Sprites.brick.getFxImage()));
                            break;
                        // enemies
                        case '1': // balloon
                            entities.add(new Balloon(i, n,
                                    Sprites.balloom_right_1.getFxImage()));
                            break;
                        case '2': // oneal
                            entities.add(new Oneal(i, n,
                                    Sprites.oneal_right_1.getFxImage()));
                            break;
                    }
                }
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void update() {
        // entities.forEach(Entity::update);
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            entity.update();
            if (entity.isRemoved()) {
                entities.remove(i);
            }
        }
        if (bombs != null) {
            for (Bomb bomb : bombs) {
                bomb.update();
            }
        }
        if (!explosions.isEmpty()) {
            for (int i = 0; i < explosions.size(); i++) {
                Entity entity = explosions.get(i);
                entity.update();
                if (entity.isRemoved()) {
                    explosions.remove(i);
                }
            }
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        friendlyEntities.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        if (bombs != null) {
            for (Bomb bomb : bombs) {
                bomb.render(gc);
            }
        }
        if (!explosions.isEmpty()) {
            explosions.forEach(g -> g.render(gc));
        }
    }

    public static Entity getEntity(int x, int y) {
        for (Entity entity : entities) {
            if (entity.compareCoordinate(x, y))
                return entity;
        }
        for (Entity entity : friendlyEntities) {
            if (entity.compareCoordinate(x, y))
                return entity;
        }
        if (bombs != null) {
            for (Bomb bomb : bombs) {
                if (bomb.compareCoordinate(x, y))
                    return bomb;
            }
        }
        return null;
    }

    public static Entity getEnemy(int x, int y) {
        for (Entity entity : entities) {
            if (entity.compareCoordinate(x,
                    y) /* && !(entity instanceof Bomber) */)
                return entity;
        }
        return null;
    }

    public static void addBomb(Bomb bomb) {
        bombs.add(bomb);
        //Sound.play("sound/bomset.wav");
    }

    // public static void bombExplode(List<Entity> exs) {
    // bomb = null;
    // explosions = exs;
    // }
}
