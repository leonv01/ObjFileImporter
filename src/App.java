import java.io.IOException;

public class App {
    public static void main(String[] args) {
            
        ObjFileReader objFileReader = new ObjFileReader(
            "C:\\Users\\leonv\\Desktop\\xwing.mtl"
        );

        try{
            objFileReader.createMaterial();
        }catch(IOException ignored){
            System.out.println(ignored);
        }
    }
}
