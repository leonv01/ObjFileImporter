import java.util.ArrayList;

public class Entity {
    ArrayList<Face> faces;
    String name = "";
    int entityID = 0;
    Vector3D pivot;
    boolean smoothShading;

    public Entity(){
        faces = new ArrayList<>(0);
        pivot = new Vector3D();
    }

    public Entity(ArrayList<Face> faces){
        this.faces = faces;
        pivot = new Vector3D();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSmoothShading(boolean smoothShading){
        this.smoothShading = smoothShading;
    }

    public void updatePosition(Vector3D vec){
        pivot.add(vec);
        for(Face face: faces)
            face.updatePos(pivot);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        str.append(String.format("object name: %s\n", name));

        int i = 0;
        for (Face face : faces) {
            str.append(String.format("Face nr. %d\n%s\n", ++i, face));
        }

        return str.toString();
    }
}
