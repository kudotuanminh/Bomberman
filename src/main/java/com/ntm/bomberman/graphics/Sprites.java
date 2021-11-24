package com.ntm.bomberman.graphics;

public class Sprites {
    /** Board sprites. */
    //
    // Contain: grass, brick, wall, portal.
    public static Sprite grass =
            new Sprite(Sprite.DEFAULT_SIZE, 6, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite brick =
            new Sprite(Sprite.DEFAULT_SIZE, 7, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite wall =
            new Sprite(Sprite.DEFAULT_SIZE, 5, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite portal =
            new Sprite(Sprite.DEFAULT_SIZE, 4, 0, SpriteSheet.tiles, 14, 14);

    /** Bomber sprites. */
    //
    // Contain: player_up, player_down, player_left, player_right,
    // player_up_1, player_up_2,
    // player_down_1, player_down_2,
    // player_left_1, player_left_2,
    // player_right_1, player_right_2,
    // player_dead_1, player_dead_2, player_dead_3.
    public static Sprite player_up =
            new Sprite(Sprite.DEFAULT_SIZE, 0, 0, SpriteSheet.tiles, 12, 16);
    public static Sprite player_down =
            new Sprite(Sprite.DEFAULT_SIZE, 2, 0, SpriteSheet.tiles, 12, 15);
    public static Sprite player_left =
            new Sprite(Sprite.DEFAULT_SIZE, 3, 0, SpriteSheet.tiles, 10, 15);
    public static Sprite player_right =
            new Sprite(Sprite.DEFAULT_SIZE, 1, 0, SpriteSheet.tiles, 10, 16);

    public static Sprite player_up_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 0, 1, SpriteSheet.tiles, 12, 16);
    public static Sprite player_up_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 0, 2, SpriteSheet.tiles, 12, 15);

    public static Sprite player_down_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 2, 1, SpriteSheet.tiles, 12, 15);
    public static Sprite player_down_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 2, 2, SpriteSheet.tiles, 12, 16);

    public static Sprite player_left_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 3, 1, SpriteSheet.tiles, 11, 16);
    public static Sprite player_left_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 3, 2, SpriteSheet.tiles, 12, 16);

    public static Sprite player_right_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 1, 1, SpriteSheet.tiles, 11, 16);
    public static Sprite player_right_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 1, 2, SpriteSheet.tiles, 12, 16);

    public static Sprite player_dead_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 4, 2, SpriteSheet.tiles, 14, 16);
    public static Sprite player_dead_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 5, 2, SpriteSheet.tiles, 13, 15);
    public static Sprite player_dead_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 6, 2, SpriteSheet.tiles, 16, 16);

    /** Character sprites. */
    //
    // Contain: mob_dead_1, mob_dead_2, mob_dead_3.
    public static Sprite mob_dead_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 15, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite mob_dead_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 15, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite mob_dead_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 15, 2, SpriteSheet.tiles, 16, 16);

    // BALLOM
    //
    // Contain: ballom_left_1, ballom_left_2, ballom_left_3,
    // ballom_right_1, ballom_right_2, ballom_right_3,
    // ballom_dead.
    public static Sprite balloom_left_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 9, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite balloom_left_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 9, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite balloom_left_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 9, 2, SpriteSheet.tiles, 16, 16);

    public static Sprite balloom_right_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 10, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite balloom_right_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 10, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite balloom_right_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 10, 2, SpriteSheet.tiles, 16, 16);

    public static Sprite balloom_dead =
            new Sprite(Sprite.DEFAULT_SIZE, 9, 3, SpriteSheet.tiles, 16, 16);

    // ONEAL
    //
    // Contain: oneal_left_1, oneal_left_2, oneal_left_3,
    // oneal_right_1, oneal_right_2, oneal_right_3,
    // oneal_dead.
    public static Sprite oneal_left_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 11, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite oneal_left_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 11, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite oneal_left_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 11, 2, SpriteSheet.tiles, 16, 16);

    public static Sprite oneal_right_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 12, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite oneal_right_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 12, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite oneal_right_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 12, 2, SpriteSheet.tiles, 16, 16);

    public static Sprite oneal_dead =
            new Sprite(Sprite.DEFAULT_SIZE, 11, 3, SpriteSheet.tiles, 16, 16);

    // Doll
    //
    // Contain: doll_left_1, doll_left_2, doll_left_3,
    // doll_right_1, doll_right_2, doll_right_3,
    // doll_dead.
    public static Sprite doll_left_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 13, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite doll_left_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 13, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite doll_left_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 13, 2, SpriteSheet.tiles, 16, 16);

    public static Sprite doll_right_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 14, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite doll_right_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 14, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite doll_right_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 14, 2, SpriteSheet.tiles, 16, 16);

    public static Sprite doll_dead =
            new Sprite(Sprite.DEFAULT_SIZE, 13, 3, SpriteSheet.tiles, 16, 16);

    // Minvo
    //
    // Contain: minvo_left_1, minvo_left_2, minvo_left_3,
    // minvo_right_1, minvo_right_2, minvo_right_3,
    // minvo_dead.
    public static Sprite minvo_left_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 8, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite minvo_left_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 8, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite minvo_left_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 8, 7, SpriteSheet.tiles, 16, 16);

    public static Sprite minvo_right_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 9, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite minvo_right_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 9, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite minvo_right_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 9, 7, SpriteSheet.tiles, 16, 16);

    public static Sprite minvo_dead =
            new Sprite(Sprite.DEFAULT_SIZE, 8, 8, SpriteSheet.tiles, 16, 16);

    // Kondoria
    //
    // Contain: kondoria_left_1, kondoria_left_2, kondoria_left_3,
    // kondoria_right_1, kondoria_right_2, kondoria_right_3,
    // kondoria_dead.
    public static Sprite kondoria_left_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 10, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite kondoria_left_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 10, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite kondoria_left_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 10, 7, SpriteSheet.tiles, 16, 16);

    public static Sprite kondoria_right_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 11, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite kondoria_right_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 11, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite kondoria_right_3 =
            new Sprite(Sprite.DEFAULT_SIZE, 11, 7, SpriteSheet.tiles, 16, 16);

    public static Sprite kondoria_dead =
            new Sprite(Sprite.DEFAULT_SIZE, 10, 8, SpriteSheet.tiles, 16, 16);

    /** Bomb sprites. */
    //
    // Contain: bomb, bomb_1, bomb_2.
    public static Sprite bomb =
            new Sprite(Sprite.DEFAULT_SIZE, 0, 3, SpriteSheet.tiles, 15, 15);
    public static Sprite bomb_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 1, 3, SpriteSheet.tiles, 13, 15);
    public static Sprite bomb_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 2, 3, SpriteSheet.tiles, 12, 14);

    /** Explosion sprites. */
    //
    // Contain: bomb_exploded, bomb_exploded_1, bomb_exploded_2,
    // explosion_vertical, explosion_vertical_1, explosion_vertical_2,
    // explosion_horizontal, explosion_horizontal_1, explosion_horizontal_2,

    // explosion_horizontal_left_last, explosion_horizontal_left_last_1,
    // expolosion_horizontal_left_last_2,

    // explosion_horizontal_right_last, explosion_horizontal_right_last_1,
    // explosion_horizontal_right_last_2,

    // explosion_vertical_top_last, explosion_vertical_top_last_1,
    // explosion_vertical_top_last_2,

    // explosion_vertical_bottom_last, explosion_vertical_bottom_last_1,
    // explosion_vertical_bottom_last_2,

    // brick_exploded, brick_exploded_1, brick_exploded_2.
    public static Sprite bomb_exploded =
            new Sprite(Sprite.DEFAULT_SIZE, 0, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite bomb_exploded_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 0, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite bomb_exploded_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 0, 6, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_vertical =
            new Sprite(Sprite.DEFAULT_SIZE, 1, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 2, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 3, 5, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_horizontal =
            new Sprite(Sprite.DEFAULT_SIZE, 1, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 1, 8, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 1, 9, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_horizontal_left_last =
            new Sprite(Sprite.DEFAULT_SIZE, 0, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_left_last_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 0, 8, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_left_last_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 0, 9, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_horizontal_right_last =
            new Sprite(Sprite.DEFAULT_SIZE, 2, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_right_last_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 2, 8, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_right_last_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 2, 9, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_vertical_top_last =
            new Sprite(Sprite.DEFAULT_SIZE, 1, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_top_last_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 2, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_top_last_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 3, 4, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_vertical_bottom_last =
            new Sprite(Sprite.DEFAULT_SIZE, 1, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_bottom_last_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 2, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_bottom_last_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 3, 6, SpriteSheet.tiles, 16, 16);

    public static Sprite brick_exploded =
            new Sprite(Sprite.DEFAULT_SIZE, 7, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite brick_exploded_1 =
            new Sprite(Sprite.DEFAULT_SIZE, 7, 2, SpriteSheet.tiles, 16, 16);
    public static Sprite brick_exploded_2 =
            new Sprite(Sprite.DEFAULT_SIZE, 7, 3, SpriteSheet.tiles, 16, 16);

    /** Powerups sprites. */
    //
    // Contain: powerup_bombs, powerup_flames, powerup_speed, powerup_wallpass,
    // powerup_detonator, powerup_bombpass, powerup_flamepass.
    public static Sprite powerup_bombs =
            new Sprite(Sprite.DEFAULT_SIZE, 0, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_flames =
            new Sprite(Sprite.DEFAULT_SIZE, 1, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_speed =
            new Sprite(Sprite.DEFAULT_SIZE, 2, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_wallpass =
            new Sprite(Sprite.DEFAULT_SIZE, 3, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_detonator =
            new Sprite(Sprite.DEFAULT_SIZE, 4, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_bombpass =
            new Sprite(Sprite.DEFAULT_SIZE, 5, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_flamepass =
            new Sprite(Sprite.DEFAULT_SIZE, 6, 10, SpriteSheet.tiles, 16, 16);
}
