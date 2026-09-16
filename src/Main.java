import simulation.actions.initActions.SpawnAction;
import simulation.actions.turnActions.WorldMapIteratorAction;
import simulation.entities.creatures.Predator;
import simulation.entities.obstacles.Rock;
import simulation.entities.obstacles.Tree;
import simulation.factory.WorldMapFactory;
import simulation.factory.WorldMapSize;
import simulation.worldmap.Coordinates;
import simulation.worldmap.CoordinatesUtils;
import simulation.worldmap.WorldMap;
import simulation.renderer.ConsoleRenderer;


public class Main {
    public static void main(String[] args) {

        ConsoleRenderer renderer = new ConsoleRenderer();
        WorldMapFactory worldMapFactory = new WorldMapFactory();
        SpawnAction spawnAction = new SpawnAction();
        WorldMapIteratorAction worldMapIteratorAction = new WorldMapIteratorAction();
        WorldMap worldMap = worldMapFactory.createWorldMap(WorldMapSize.SMALL);
        spawnAction.execute(worldMap);
        renderer.render(worldMap);
        worldMapIteratorAction.iterateWorldMap(worldMap);





    }
}