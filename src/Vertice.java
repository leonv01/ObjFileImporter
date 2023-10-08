public class Vertice {
    Vector3D absolute;
    Vector3D rel;
    Vector3D normal;
    Vector3D texture;

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
