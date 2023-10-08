public class Face {
    Vertice[] verts = new Vertice[3];

    public Face(){
        verts = new Vertice[]{
            new Vertice(),
            new Vertice(),
            new Vertice()
        };
    }

    public Face(Vertice[] verts){
        this.verts = verts;
    }

    public void updatePos(Vector3D pos){
        for (Vertice vertice : verts) {
            vertice.updatePos(pos);
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        int i = 0;
        for (Vertice vertice : verts) {
            str.append(
                String.format(
                    "vert %d\n%s\n", ++i, vertice)
            );
        }

        return str.toString();
    }
}
