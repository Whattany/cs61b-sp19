package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static int width;
    private static int height;

    private static void initWorld(int N) {
        width = 11 * N - 4;
        height = 10 * N;
    }
    private static class Position {
        private static int x;
        private static int y;
    }
    private static TETile randomTile() {
        Random r = new Random();
        int tileNum = r.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.FLOWER;
            case 1: return Tileset.GRASS;
            case 2: return Tileset.TREE;
            case 3: return Tileset.WALL;
            default: return Tileset.MOUNTAIN;
        }
    }
    private void drawRamdomHex(int N, int L, TETile[][] world) {
        Position p = new Position();
        for (int i = 0; i < L; i++) {
            addHexagon(world, N, randomTile(), p);
            p.y = p.y + 2 * N;
        }
    }
    public void tesselation19Hexagon(int N) {
        TERenderer ter = new TERenderer();
        initWorld(N);
        ter.initialize(width, height);
        TETile[][] world = new TETile[width][height];
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        Position p = new Position();
        p.x = N;
        p.y = 2 * N;
        drawRamdomHex(N, 3, world);
        p.x = 3 * N - 1;
        p.y = N;
        drawRamdomHex(N, 4, world);
        p.x = 5 * N - 2;
        p.y = 0;
        drawRamdomHex(N, 5, world);
        p.x = 7 * N - 3;
        p.y = N;
        drawRamdomHex(N, 4, world);
        p.x = 9 * N - 4;
        p.y = 2 * N;
        drawRamdomHex(N, 3, world);
        ter.renderFrame(world);
    }

    private static void addHexagon(TETile[][] world, int N, TETile T, Position p) {
        Random r = new Random();
        for (int i = 0; i < 2 * N; i++) {
            if (i < N) {
                for (int j = 0; j < N + 2 * i; j++) {
                    if (T == Tileset.MOUNTAIN || T == Tileset.FLOWER) {
                        world[p.x - i + j][p.y + i] = TETile.colorVariant(T, 100, 100, 100, r);
                    } else {
                        world[p.x - i + j][p.y + i] = T;
                    }
                }
            } else {
                for (int j = 0; j < 3 * N - 2 - 2 * (i - N); j++) {
                    if (T == Tileset.MOUNTAIN || T == Tileset.FLOWER) {
                        world[p.x + i - 2 * N + 1 + j][p.y + i] =
                                TETile.colorVariant(T, 100, 100, 100, r);
                    } else {
                        world[p.x + i - 2 * N + 1 + j][p.y + i] = T;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        HexWorld H = new HexWorld();
        H.tesselation19Hexagon(3);
    }

}
