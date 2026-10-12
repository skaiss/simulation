package simulation.search;

import simulation.entities.Entity;
import simulation.entities.creatures.Herbivore;
import simulation.entities.creatures.Predator;
import simulation.entities.obstacles.Grass;
import simulation.worldmap.Coordinates;
import simulation.worldmap.CoordinatesUtils;
import simulation.worldmap.WorldMap;

import java.util.*;

public class BreadthFirstSearch {

    public List<Coordinates> findPath(Coordinates startCoordinates, WorldMap worldMap){
        Queue<Coordinates> nextVisitCloseCells = new ArrayDeque<>();
        HashMap<Coordinates, Coordinates> parentCells = new HashMap<>();

        nextVisitCloseCells.add(startCoordinates);
        parentCells.put(startCoordinates, null); //????

        Entity creature = worldMap.getEntity(startCoordinates,worldMap);

        while (!nextVisitCloseCells.isEmpty()) {
            Coordinates current = nextVisitCloseCells.poll();

            for (Coordinates cell: getAvailableMoveCloseCells(current,worldMap)) {

                Entity target = worldMap.getEntity(current, worldMap);

                if (hasTargetEntity(creature, target)) {
                    return buildPath(startCoordinates, current, parentCells);
                }

                if (!parentCells.containsKey(cell)) {
                    parentCells.put(cell, current);
                    nextVisitCloseCells.add(cell);
                }
            }

        }
        return Collections.emptyList();  //??????????
    }

    public List<Coordinates> buildPath(Coordinates start, Coordinates target, HashMap<Coordinates, Coordinates> parentCells){
        List <Coordinates> path = new ArrayList<>();
        Coordinates current = target;

            while(!current.equals(start)){
                path.add(current);
                current = parentCells.get(current);
            }

        Collections.reverse(path);
        return path;
    }

    public boolean hasTargetEntity(Entity creature, Entity target) {
        return creature instanceof Predator && target instanceof Herbivore ||
                creature instanceof Herbivore && target instanceof Grass;
    }

    public List<Coordinates> getAvailableMoveCloseCells (Coordinates coordinates, WorldMap worldMap){
        List<Coordinates> result = new ArrayList<>();
        for (Coordinates cell : CoordinatesUtils.getCloseCells(coordinates)){
            if(CoordinatesUtils.isInBounds(cell, worldMap) && !CoordinatesUtils.isObstacle(cell, worldMap)) {
                result.add(cell);
            }
        }
        return result;
    }



}