package simulation.factory;

import simulation.worldmap.WorldMap;


public class WorldMapFactory {

   public WorldMap createWorldMap(WorldMapSize worldMapSize){
           WorldMap worldMap = switch (worldMapSize) {
               case SMALL -> new WorldMap(10, 8);
               case MEDIUM -> new WorldMap(15, 10);
               case LARGE -> new WorldMap(20, 12);
           };
       return worldMap;
       }
   }
