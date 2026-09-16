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

    public void findPath(Coordinates coordinates, WorldMap worldMap){
        Queue<Coordinates> nextVisitCloseCells = new ArrayDeque<>(getAvailableMoveCloseCells(coordinates, worldMap));
        Set <Coordinates> visitedCells = new HashSet<>();
        HashMap<Coordinates, Coordinates> parentCells = new HashMap<>();
        while (!nextVisitCloseCells.isEmpty()) {

            Coordinates current = nextVisitCloseCells.poll();

            if (visitedCells.contains(current)) {
                continue;
            }
            visitedCells.add(current);

            if (hasTargetEntity(coordinates, current, worldMap)) {
                System.out.println("1");

                } else {

                fillParentCells(current, parentCells, worldMap);
                nextVisitCloseCells.addAll(getAvailableMoveCloseCells(current, worldMap));

            }

        }
    }

    public void fillParentCells(Coordinates coordinates, HashMap<Coordinates, Coordinates> parentCells, WorldMap worldMap){
        List<Coordinates> result = new ArrayList<>(getAvailableMoveCloseCells(coordinates,worldMap));
        for (Coordinates cell: result){
            parentCells.put(cell, coordinates);
        }

    }

    public boolean hasTargetEntity(Coordinates startCoordinates, Coordinates targetCoordinates, WorldMap worldMap){
    Entity entity = worldMap.getEntity(startCoordinates, worldMap);
    Entity targetEntity = worldMap.getEntity(targetCoordinates, worldMap);
    if(entity instanceof Predator && targetEntity instanceof Herbivore){
        return true;
    } else
        return entity instanceof Herbivore && targetEntity instanceof Grass;
    }

    public List<Coordinates> getAvailableMoveCloseCells (Coordinates coordinates, WorldMap worldMap){
        List<Coordinates> result = new ArrayList<>();
        for (Coordinates cell : CoordinatesUtils.getCloseCells(coordinates)){
            if(CoordinatesUtils.isInBounds(cell, worldMap) && CoordinatesUtils.isCellEmpty(cell, worldMap)) {
                result.add(cell);
            }
        }
        return result;
    }



}