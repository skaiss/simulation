package simulation.worldmap;

import simulation.entities.Entity;
import simulation.entities.EntityFactory;

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

   public List<Entity> getAllEntties(){
       return new ArrayList<>(entities.values());
   }



//   public boolean isCellAvailableForMove(Coordinates coordinates){
//      if (isCellEmpty(coordinates)) return true;
//      Entity entity = getEntity(coordinates);
//      return entity instanceOf Grass;
//   }

}