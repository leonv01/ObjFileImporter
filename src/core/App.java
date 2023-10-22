package core;
import java.io.IOException;

import core.objmeta.Entity;
import core.objmeta.Face;
import core.objmeta.ObjFileReader;
import core.utils.Vector3D;
import core.utils.Vertice;

public class App {

    public static void main(String[] args) {
        Entity entity = null;
        try{
           entity = ObjFileReader.createObject(
                "C:\\Users\\leonv\\Documents\\JavaTools\\ObjFileImporter\\ObjFileImporter\\src\\obj\\star-destroyer\\stardestroyer.obj"
                );
        }catch(IOException ignored){ 
            System.out.println(ignored);
        }

        System.out.println(entity != null ? entity.toString() : "");
  
    }

}
