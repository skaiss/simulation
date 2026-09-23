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

    public List<Coordinates> findPath(Coordinates coordinates, WorldMap worldMap){
        Queue<Coordinates> nextVisitCloseCells = new ArrayDeque<>();
        //Set <Coordinates> visitedCells = new HashSet<>();
        //List <Coordinates> result = new ArrayList<>();
        HashMap<Coordinates, Coordinates> parentCells = new HashMap<>();

        nextVisitCloseCells.add(coordinates);
        parentCells.put(coordinates, null);

        Entity creature = worldMap.getEntity(coordinates,worldMap);
        while (!nextVisitCloseCells.isEmpty()) {
            Coordinates current = nextVisitCloseCells.poll();
            Entity target = worldMap.getEntity(current, worldMap);
//            if (visitedCells.contains(current)) {
//                continue;
//            }
            //visitedCells.add(current);


            if (hasTargetEntity(creature, target)) {
               return buildShortestPath(coordinates, current, parentCells);

                }

            //nextVisitCloseCells.addAll(getAvailableMoveCloseCells(current, worldMap));

            for (Coordinates cell: getAvailableMoveCloseCells(current,worldMap)){
                if(!parentCells.containsKey(cell)){
                    parentCells.put(cell, current);
                    nextVisitCloseCells.add(cell);
                }
            }

        }
        return Collections.emptyList();
    }

    public List<Coordinates> buildShortestPath(Coordinates start, Coordinates target, HashMap<Coordinates, Coordinates> parentCells){
        List <Coordinates> path = new ArrayList<>();

        Coordinates current = target;
            while(!current.equals(start)){
                path.add(current);
                current = parentCells.get(current);
            }

        Collections.reverse(path);


        return path;
    }



    public boolean hasTargetEntity(Entity creature, Entity target){
    if(creature instanceof Predator && target instanceof Herbivore){
        return true;
    } else
        return creature instanceof Herbivore && target instanceof Grass;
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