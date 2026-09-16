package simulation.renderer;

import simulation.entities.Entity;
import simulation.entities.creatures.Herbivore;
import simulation.entities.creatures.Predator;
import simulation.entities.obstacles.Grass;
import simulation.entities.obstacles.Rock;
import simulation.entities.obstacles.Tree;
import simulation.worldmap.Coordinates;
import simulation.worldmap.CoordinatesUtils;
import simulation.worldmap.WorldMap;


public class ConsoleRenderer {

    private final static String PREDATOR_EMOJI = ("🐺");
    private final static String HERBIVORE_EMOJI = ("🐇");
    private final static String GRASS_EMOJI = ("🌿");
    private final static String ROCK_EMOJI = ("🪨");
    private final static String TREE_EMOJI = ("🌳");
    private final static String EMPTY_EMOJI = ("◼️");

    public void render(WorldMap worldMap) {
        int mapHeight = worldMap.getWorldMapHeight();
        int mapWidth = worldMap.getWorldMapWidth();

        System.out.println();

        for (int row = 0; row < mapHeight; row++) {
            for (int column = 0; column < mapWidth; column++) {

                Coordinates coordinates = new Coordinates(column, row);
                if (CoordinatesUtils.isCellEmpty(coordinates, worldMap)) {
                    printSpriteForEmptyCell();
                } else printSpriteEntity(coordinates, worldMap);
            }
            System.out.println();
        }
    }

        public void printSpriteForEmptyCell () {
            System.out.print(EMPTY_EMOJI);
        }

        public String getEntitySprite(Entity entity){
            if (entity instanceof Predator) {
                return PREDATOR_EMOJI;
            }
            if (entity instanceof Herbivore) {
                return HERBIVORE_EMOJI;
            }
            if (entity instanceof Grass) {
                return GRASS_EMOJI;
            }
            if (entity instanceof Rock) {
                return ROCK_EMOJI;
            }
            if (entity instanceof Tree) {
                return TREE_EMOJI;
            } else return EMPTY_EMOJI;
        }

        public void printSpriteEntity (Coordinates coordinates, WorldMap worldMap){
            Entity entity = worldMap.getEntity(coordinates, worldMap);
            System.out.print(getEntitySprite(entity));
        }

    }
