package core;
import java.io.IOException;

import core.objData.Entity;
import core.objData.ObjFileReader;

public class App {

    public static void main(String[] args) {
        Entity entity = null;

        try{
            entity = ObjFileReader.createObject(
                "C:\\Users\\Leon\\Documents\\ObjFileImporter\\src\\obj\\star-destroyer\\stardestroyer.obj"
                );
        }catch(IOException ignored){ 
            System.out.println(ignored);
        }

        if(entity != null)
            System.out.println(entity);
    }

}
