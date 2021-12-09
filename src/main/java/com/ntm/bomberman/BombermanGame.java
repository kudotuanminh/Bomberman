package com.ntm.bomberman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.ntm.bomberman.input.Keyboard;
import com.ntm.bomberman.sound.Sound;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.ntm.bomberman.graphics.*;
import com.ntm.bomberman.entities.*;
import com.ntm.bomberman.entities.bomb.*;
import com.ntm.bomberman.entities.objects.*;
import com.ntm.bomberman.entities.enemies.*;
// import com.ntm.bomberman.entities.items.*;

public class BombermanGame extends Application {
    public int WIDTH = 31;
    public int HEIGHT = 13;

    private GraphicsContext gc;
    private Canvas canvas;

    private static List<Entity> entities = new ArrayList<>();
    private static List<Entity> staticEntities = new ArrayList<>();
    private static List<Entity> explosions = new ArrayList<>();

    private Bomber bomberman;
    private static Bomb bomb;
    private Portal portal;

    private int level = 1;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();

        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH,
                Sprite.SCALED_SIZE * HEIGHT);
        canvas.setLayoutX(0);
        canvas.setLayoutY(Sprite.SCALED_SIZE * 2);
        gc = canvas.getGraphicsContext2D();

        canvas.requestFocus();
        canvas.setFocusTraversable(true);

        canvas.setOnKeyPressed((KeyEvent event) -> {
            Keyboard.handleMovement(event, bomberman);
            if (event.getCode() == KeyCode.SPACE && bomb == null) {
                bomb = new Bomb(bomberman.getX() / Sprite.SCALED_SIZE,
                        bomberman.getY() / Sprite.SCALED_SIZE,
                        Sprites.bomb.getFxImage());
            }
        });

        root.getChildren().addAll(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            final double ns = 1000000000.0 / 60;
            long lastTime = System.nanoTime();
            double delta = 0;
            int updates = 0;

            @Override
            public void handle(long now) {
                delta += (now - lastTime) / ns;
                lastTime = now;
                while (delta >= 1) {
                    render();
                    try {
                        update();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    updates++;
                    delta--;
                }
            }
        };
        timer.start();

        createMap();
        Sound.play(Sound.ingame);
    }

    public void createMap() throws IOException {
        staticEntities.clear();
        entities.clear();
        canvas.setDisable(false);

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(
                        "./src/resources/levels/Level" + level + ".txt"),
                "UTF-8"));

        String line;
        line = fileReader.readLine();
        String[] args = line.split(" ");
        int L = Integer.parseInt(args[0]);
        int R = Integer.parseInt(args[1]);
        int C = Integer.parseInt(args[2]);
        HEIGHT = R;
        WIDTH = C;

        int rowCount = -1;
        while ((line = fileReader.readLine()) != null) {
            rowCount++;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '#') {
                    staticEntities.add(
                            new Wall(i, rowCount, Sprites.wall.getFxImage()));
                } else {
                    staticEntities.add(
                            new Grass(i, rowCount, Sprites.grass.getFxImage()));
                }
            }
            for (int i = 0; i < line.length(); i++) {
                switch (line.charAt(i)) {
                    case '*':
                        entities.add(new Brick(i, rowCount,
                                Sprites.brick.getFxImage()));
                        break;
                    case 'x':
                        portal = new Portal(i, rowCount,
                                Sprites.portal.getFxImage());
                        entities.add(new Brick(i, rowCount,
                                Sprites.brick.getFxImage()));
                        break;
                    case 'p':
                        bomberman = new Bomber(i, rowCount,
                                Sprites.player_right.getFxImage());
                        entities.add(bomberman);
                        break;
                    case '1':
                        entities.add(new Ballom(i, rowCount,
                                Sprites.ballom_left_1.getFxImage()));
                        break;
                    case '2':
                        entities.add(new Oneal(i, rowCount,
                                Sprites.oneal_left_1.getFxImage()));
                        break;
                    case '3': // ovape
                        entities.add(new Ovape(i, rowCount,
                                Sprites.ovape_dead.getFxImage()));
                        break;
                    case '4': // doll
                        entities.add(new Doll(i, rowCount,
                                Sprites.ovape_dead.getFxImage()));
                        break;
                }
            }
        }

        fileReader.close();
        // status.setText("Level " + level);
    }

    public void update() throws IOException {
        // entities.forEach(Entity::update);
        if (bomberman.isRemoved()) {
            // status.setText("Game Over");
            canvas.setDisable(true);
        }
        if (isWin()) {
            level++;
            if (level <= 2)
                createMap();
            else {
                // status.setText("You Win!");
                canvas.setDisable(true);
            }
        }
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            entity.update();
            if (entity.isRemoved()) {
                entities.remove(i);
            }
        }
        if (bomb != null) {
            bomb.update();
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
        staticEntities.forEach(g -> g.render(gc));
        portal.render(gc);
        entities.forEach(g -> g.render(gc));
        if (bomb != null) {
            bomb.render(gc);
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
        for (Entity entity : staticEntities) {
            if (entity.compareCoordinate(x, y))
                return entity;
        }
        return null;
    }

    public static Entity getEnemy(int x, int y) {
        for (Entity entity : entities) {
            if (entity.compareCoordinate(x, y) && !(entity instanceof Bomber))
                return entity;
        }
        return null;
    }

    public static void bombExplode(List<Entity> exs) {
        bomb = null;
        explosions = exs;
    }

    private boolean isWin() {
        for (Entity entity : entities) {
            if (entity instanceof Enemies) {
                return false;
            }
        }
        return (bomberman.getX() == portal.getX()
                && bomberman.getY() == portal.getY());
    }
}
