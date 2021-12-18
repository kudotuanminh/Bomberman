package com.ntm.bomberman;

import java.io.*;
import java.util.*;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.paint.Color;

import com.ntm.bomberman.gui.*;
import com.ntm.bomberman.sound.Sound;
import com.ntm.bomberman.input.Keyboard;
import com.ntm.bomberman.graphics.*;
import com.ntm.bomberman.entities.*;
import com.ntm.bomberman.entities.objects.*;
import com.ntm.bomberman.entities.enemies.*;
import com.ntm.bomberman.entities.items.*;

public class BombermanGame extends Application {
    public static int WIDTH = 31;
    public int HEIGHT = 13;
    Scene scene1, scene2;

    private GraphicsContext gc;
    private Canvas canvas;

    // private LabelGame caption;
    // private ButtonGame nextLevel;
    // private ButtonGame playAgain;

    // private boolean soundDead = false;

    private static List<Entity> staticEntities = new ArrayList<>();
    private static List<Entity> entities = new ArrayList<>();
    private static List<Entity> items = new ArrayList<>();
    private static List<Entity> enemies = new ArrayList<>();
    private static List<Entity> explosions = new ArrayList<>();

    public static Bomber bomberman;
    private Portal portal;
    private boolean isWin = false;
    Stage window;

    private int level = 1;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        ImageView imageView = new ImageView(
                new Image(new File("src/resources/images/banner.png").toURI()
                        .toString()));
        imageView.setFitHeight(350);
        imageView.setFitWidth(1050);

        ImageView imageView2 = new ImageView(
                new Image(new File("src/resources/images/play_button.jpg")
                        .toURI().toString()));
        imageView2.setFitHeight(250);
        imageView2.setFitWidth(1035);

        Label label = new Label("BOMBERMAN");
        label.setGraphic(imageView);

        FlowPane root1 = new FlowPane();
        root1.setPadding(new Insets(10));
        root1.getChildren().add(label);

        Button button1 = new Button("", imageView2);
        button1.setOnAction(event -> {
            window.setScene(scene2);
        });
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label, root1, button1);

        scene1 = new Scene(layout1, 1050, 620);

        layout1.setBackground(new Background(new BackgroundFill(Color.BLACK,
                CornerRadii.EMPTY, Insets.EMPTY)));

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

            if (event.getCode() == KeyCode.F12) {
                isWin = true;
                System.out.println("cheated xD");
            }
        });

        root.getChildren().addAll(canvas);
        scene2 = new Scene(root);
        stage.setScene(scene1);
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

        Sound.play(Sound.stage_theme);
        createMap();
    }

    public void createMap() throws IOException {
        // Sound.play(Sound.level_start);

        isWin = false;
        staticEntities.clear();
        entities.clear();
        items.clear();
        enemies.clear();
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
                if (line.charAt(i) == '#') { // wall
                    staticEntities.add(
                            new Wall(i, rowCount, Sprites.wall.getFxImage()));
                } else { // grass
                    staticEntities.add(
                            new Grass(i, rowCount, Sprites.grass.getFxImage()));
                }
            }
            for (int i = 0; i < line.length(); i++) {
                switch (line.charAt(i)) {
                    case '*': // brick
                        entities.add(new Brick(i, rowCount,
                                Sprites.brick.getFxImage()));
                        break;
                    case 'x':// portal
                        portal = new Portal(i, rowCount,
                                Sprites.portal.getFxImage());
                        staticEntities.add(portal);
                        entities.add(new Brick(i, rowCount,
                                Sprites.brick.getFxImage()));
                        break;

                    case 'b': // bombItem
                        items.add(new BombItems(i, rowCount,
                                Sprites.powerup_bombs.getFxImage()));
                        entities.add(new Brick(i, rowCount,
                                Sprites.brick.getFxImage()));
                        break;
                    case 'f':// flameItem
                        items.add(new FlameItems(i, rowCount,
                                Sprites.powerup_flames.getFxImage()));
                        entities.add(new Brick(i, rowCount,
                                Sprites.brick.getFxImage()));
                        break;
                    case 's':// speedItem
                        items.add(new SpeedItems(i, rowCount,
                                Sprites.powerup_speed.getFxImage()));
                        entities.add(new Brick(i, rowCount,
                                Sprites.brick.getFxImage()));
                        break;

                    case 'p': // Bomberman
                        bomberman = new Bomber(i, rowCount,
                                Sprites.player_right.getFxImage());
                        entities.add(bomberman);
                        break;

                    case '1': // Ballom
                        enemies.add(new Ballom(i, rowCount,
                                Sprites.ballom_left_1.getFxImage()));
                        break;
                    case '2': // Oneal
                        enemies.add(new Oneal(i, rowCount,
                                Sprites.oneal_left_1.getFxImage()));
                        break;
                    case '3': // Ovape
                        enemies.add(new Ovape(i, rowCount,
                                Sprites.ovape_left_1.getFxImage()));
                        break;
                    case '4':// Dall
                        enemies.add(new Dall(i, rowCount,
                                Sprites.dall_left_1.getFxImage()));
                        break;
                    case '5': // Kondoria
                        enemies.add(new Kondoria(i, rowCount,
                                Sprites.kondoria_left_1.getFxImage()));
                        break;
                }
            }

        }

        fileReader.close();
    }

    public void update() throws IOException {
        if (bomberman.isRemoved()) {
            canvas.setDisable(true);
        }
        checkWinState();
        if (isWin) {
            // Sound.play(Sound.level_complete);
            level++;
            if (level <= 2)
                createMap();
            else {
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
        for (int i = 0; i < enemies.size(); i++) {
            Entity enemy = enemies.get(i);
            enemy.update();
            if (enemy.isRemoved()) {
                Sound.play(Sound.enemy_died);
                enemies.remove(i);
            }
        }
        for (int i = 0; i < items.size(); i++) {
            Entity item = items.get(i);
            item.update();
            if (item.isRemoved()) {
                Sound.play(Sound.item);
                items.remove(i);
            }
        }
        for (int i = 0; i < bomberman.bombs.size(); i++) {
            bomberman.bombs.get(i).update();
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
        items.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        enemies.forEach(g -> g.render(gc));
        bomberman.bombs.forEach(g -> g.render(gc));

        if (!explosions.isEmpty()) {
            explosions.forEach(g -> g.render(gc));
        }
    }

    public static Entity getEntity(int x, int y) {
        for (Entity enemy : enemies) {
            if (enemy.compareCoordinate(x, y)) {
                return enemy;
            }
        }
        for (Entity entity : entities) {
            if (entity.compareCoordinate(x, y)) {
                return entity;
            }
        }
        for (Entity entity : staticEntities) {
            if (entity.compareCoordinate(x, y)) {
                return entity;
            }
        }
        return null;
    }

    public static Entity getEnemy(int x, int y) {
        for (Entity enemy : enemies) {
            if (enemy.compareCoordinate(x, y)) {
                return enemy;
            }
        }
        return null;
    }

    public static void bombExplode(List<Entity> exs) {
        if (bomberman.bombs.size() > 0) {
            bomberman.bombs.remove(bomberman.bombs.get(0));
        }
        explosions = exs;
    }

    private void checkWinState() {
        if (isWin) {
            return;
        } else {
            isWin = (bomberman.getX() == portal.getX()
                    && bomberman.getY() == portal.getY() && enemies.isEmpty());
        }
    }
}
