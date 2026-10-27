import simulation.actions.initActions.SpawnAction;
import simulation.actions.turnActions.WorldMapIteratorAction;
import simulation.factory.WorldMapFactory;
import simulation.factory.WorldMapSize;
import simulation.renderer.ConsoleRenderer;
import simulation.worldmap.WorldMap;

import static java.lang.Thread.sleep;


public static void main(String[] args) throws InterruptedException {

    ConsoleRenderer renderer = new ConsoleRenderer();
    WorldMapFactory worldMapFactory = new WorldMapFactory();
    SpawnAction spawnAction = new SpawnAction();
    WorldMapIteratorAction worldMapIteratorAction = new WorldMapIteratorAction();
    WorldMap worldMap = worldMapFactory.createWorldMap(WorldMapSize.SMALL);
    spawnAction.execute(worldMap);
//    renderer.render(worldMap);
//    worldMapIteratorAction.iterateWorldMap(worldMap);
//    renderer.render(worldMap);

        renderer.render(worldMap);
        while(true){
            worldMapIteratorAction.iterateWorldMap(worldMap);
            renderer.render(worldMap);
            System.out.println("\n");
            sleep(1000);
        }



}


