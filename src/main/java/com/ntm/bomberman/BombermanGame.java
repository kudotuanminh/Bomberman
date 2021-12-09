package com.ntm.bomberman;

import java.io.*;
import java.util.*;

import com.ntm.bomberman.entities.Bomb.Bomb;
import com.ntm.bomberman.input.Direction;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.*;

import com.ntm.bomberman.graphics.*;
import com.ntm.bomberman.entities.*;
import com.ntm.bomberman.entities.objects.*;
import com.ntm.bomberman.entities.enemies.*;
// import com.ntm.bomberman.entities.items.*;


public class BombermanGame extends Application {
    public int WIDTH;
    public int HEIGHT;

    private GraphicsContext gc;
    private Canvas canvas;
    private static List<Entity> entities = new ArrayList<>();
    private static List<Entity> friendlyEntities = new ArrayList<>();
    private static List<Entity> explosions = new ArrayList<>();

    private Bomber bomberman;
    private static Bomb bomb;
    private Portal portal;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        createMap();
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH,
                Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        canvas.requestFocus();
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(( KeyEvent event ) -> {
            if (event.getCode() == KeyCode.RIGHT) {
                bomberman.setDirection(Direction.RIGHT);
            }
            if (event.getCode() == KeyCode.LEFT) {
                bomberman.setDirection(Direction.LEFT);
            }
            if (event.getCode() == KeyCode.UP) {
                bomberman.setDirection(Direction.UP);
            }
            if (event.getCode() == KeyCode.DOWN) {
                bomberman.setDirection(Direction.DOWN);
            }
            if (event.getCode() == KeyCode.SPACE && bomb == null) { //  && bomberman.isAlive()
                bomb = new Bomb(bomberman.getX() / Sprite.SCALED_SIZE ,
                        bomberman.getY() / Sprite.SCALED_SIZE ,
                        Sprites.bomb.getFxImage());

            }
        });

        // Tao root container
        //Group root = new Group();
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
                        friendlyEntities.add(new Wall(i , n , Sprites.wall.getFxImage()));
                    } else {
                        friendlyEntities.add(new Grass(i , n , Sprites.grass.getFxImage()));
                    }
                }
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    //entities.add(new Grass(i, n, Sprites.grass.getFxImage()));
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
                        case '*': // brick
                            entities.add(new Brick(i, n,
                                    Sprites.brick.getFxImage()));
                            break;
                        // items
                        case 'x': // portals
                            portal = new Portal(i, n, Sprites.portal.getFxImage());
                            //entities.add(new Portal(i, n,
                                    //Sprites.portal.getFxImage()));
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
        //entities.forEach(Entity::update);
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
        friendlyEntities.forEach(g -> g.render(gc));
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
            if (entity.compareCoordinate(x, y)) return entity;
        }
        for (Entity entity : friendlyEntities) {
            if (entity.compareCoordinate(x , y)) return entity;
        }
        return null;
    }

    public static Entity getEnemy(int x, int y) {
        for (Entity entity : entities) {
            if (entity.compareCoordinate(x, y) && !(entity instanceof Bomber)) return entity;
        }
        return null;
    }

    public static void bombExplode( List<Entity> exs ) {
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
