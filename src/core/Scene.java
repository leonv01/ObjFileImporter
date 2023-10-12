package core;

import java.util.*;

import core.objmeta.Entity;

public class Scene {
    private ArrayList<Entity> entities = new ArrayList<>();

    private static Scene scene;

    public static Scene getScene() {
        return scene;
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    
}
