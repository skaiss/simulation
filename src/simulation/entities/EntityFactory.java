package simulation.entities;

import simulation.entities.creatures.Herbivore;
import simulation.entities.creatures.Predator;
import simulation.entities.obstacles.Grass;
import simulation.entities.obstacles.Rock;
import simulation.entities.obstacles.Tree;

public class EntityFactory {

    public Entity createEntity(EntityType entityType) {
        Entity entity = null;
        switch (entityType) {
            case HERBIVORE:
                entity = new Herbivore();
                break;
            case PREDATOR:
                entity = new Predator();
                break;
            case GRASS:
                entity = new Grass();
                break;
            case ROCK:
                entity = new Rock();
                break;

            case TREE:
                entity = new Tree();
                break;

        }
        return entity;
    }
}
