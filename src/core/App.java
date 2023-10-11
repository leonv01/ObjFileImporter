package core;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
            
        ObjFileReader objFileReader = new ObjFileReader(
            "C:\\Users\\Leon\\Documents\\ObjFileImporter\\src\\obj\\star-destroyer\\stardestroyer.obj"
        );

        try{
            objFileReader.createObject();
        }catch(IOException ignored){
            System.out.println(ignored);
        }
    }
}
