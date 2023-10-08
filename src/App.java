import java.io.IOException;

public class App {
    public static void main(String[] args) {
            
        ObjFileReader objFileReader = new ObjFileReader(
            "C:\\Users\\leonv\\Desktop\\box.obj"
        );

        try{
            objFileReader.createObject();
        }catch(IOException ignored){
            System.out.println(ignored);
        }
    }
}
