package simulation.worldmap;

import simulation.entities.Entity;
import simulation.entities.EntityFactory;
import simulation.entities.creatures.Creature;

import java.util.*;


public class WorldMap {

    private Map<Coordinates, Entity> entities;

    EntityFactory entityFactory = new EntityFactory();

    private final int mapWidth;
    private final int mapHeight;

    public WorldMap(int mapWidth, int mapHeight) {
        this.entities = new HashMap<Coordinates, Entity>();
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public int getWorldMapWidth() {
        return mapWidth;
    }

    public int getWorldMapHeight() {
        return mapHeight;
    }

    public Map<Coordinates, Entity> getEntities() {
        return entities;
    }

    public Entity getEntity(Coordinates coordinates, WorldMap worldMap) {
        CoordinatesUtils.validateCoordinates(coordinates, worldMap);
        return entities.get(coordinates);
    }

    public void setEntity(Coordinates coordinates, Entity entity, WorldMap worldMap) {
        CoordinatesUtils.validateCoordinates(coordinates, worldMap);
        entities.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates, WorldMap worldMap) {
        CoordinatesUtils.validateCoordinates(coordinates, worldMap);
        entities.remove(coordinates);
    }

    public Coordinates getEntityCoordinates(Entity entity) {
        for (Map.Entry<Coordinates, Entity> entry : entities.entrySet()) {
            if (entry.getValue() == entity) return entry.getKey();
        }
        throw new IllegalArgumentException("coordinates not found for entity: " + entity);
    }

    public List<Entity> getAllEntities() {
        return new ArrayList<>(entities.values());
    }

    public List<Creature> getALlCreatures() {
        List<Entity> entities = getAllEntities();
        List<Creature> creatures = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity instanceof Creature) {
                creatures.add((Creature) entity);
            }
        }
        return creatures;

    }

    public HashMap<Creature, Coordinates> makeMap(){
        List<Creature> creatures = getALlCreatures();
        HashMap<Creature, Coordinates> result = new HashMap<>();
        for(Creature creature : creatures) {
            Coordinates coordinates = getEntityCoordinates((Creature) creature);
            result.put(creature, coordinates);
        }
        return result;
    }


//   public boolean isCellAvailableForMove(Coordinates coordinates){
//      if (isCellEmpty(coordinates)) return true;
//      Entity entity = getEntity(coordinates);
//      return entity instanceOf Grass;
//   }


}