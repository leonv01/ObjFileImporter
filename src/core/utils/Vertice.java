package core.utils;

public class Vertice {
    Vector3D absolute;  // absolute coordinates: relative added with offset
    Vector3D rel;       // relative coordinates from the obj containing original size
    Vector3D normal;    // normals
    Vector3D texture;   // texture coordinates

    public Vertice(){
        rel = absolute = normal = texture = new Vector3D();
    } 

    public Vertice(Vector3D pos, Vector3D normal, Vector3D texture){
        this.rel = pos;
        this.absolute = pos;
        this.normal = normal;
        this.texture = texture;
    }

    public void updatePos(Vector3D pivot){
        absolute = Vector3D.add(rel, pivot);
    }

    @Override
    public String toString(){
        return String.format(
            "\trelative: %s\n\tabsolute: %s\n\tnormal: %s\n\ttexture: %s", rel, absolute, normal, texture);
    }
}
