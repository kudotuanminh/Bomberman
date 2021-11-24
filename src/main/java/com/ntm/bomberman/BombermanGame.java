package com.ntm.bomberman;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
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
    private List<Entity> entities = new ArrayList<>();

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        createMap();
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH,
                Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
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
                    char c = line.charAt(i);
                    entities.add(new Grass(i, n, Sprites.grass.getFxImage()));
                    switch (c) {
                        case 'p': // bomber
                            entities.add(new Bomber(i, n,
                                    Sprites.player_right.getFxImage()));
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
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        entities.forEach(g -> g.render(gc));
    }
}
