package core;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ObjFileReader {

    private final String path;
    
    public ObjFileReader(String path){
        this.path = path;
    }

    public void createObject() throws IOException {
        ArrayList<Vector3D> verticeList = new ArrayList<>();
        ArrayList<Vector3D> verticeNormalList = new ArrayList<>();
        ArrayList<Vector3D> verticeTextureList = new ArrayList<>();

        ArrayList<Face> faces = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(path));

        String line, name = "Object";
        while((line = br.readLine()) != null){

            line = line.trim();
            // removes multiple whitespaces 
            line = line.replaceAll("^ +| +$|( )+", "$1");

            /*
             * Vertex
             * Parses all 3 coordinates into floats and stores in 3D Vector
             */

            if(line.startsWith("v ")){
                String[] parts = line.split(" ");

                float x = Float.parseFloat(parts[1]);
                float y = Float.parseFloat(parts[2]);
                float z = Float.parseFloat(parts[3]);

                Vector3D vector3d = new Vector3D(x, y, z);
                verticeList.add(vector3d);

                //System.out.println("x: " + x + " y: " + y + " z: " + z);
            }

            /*
             * Vertex normal
             * Parses all 3 coordinates into floats and stores in 3D Vector
             */
            else if(line.startsWith("vn ")){
                String[] parts = line.split(" ");

                float x = Float.parseFloat(parts[1]);
                float y = Float.parseFloat(parts[2]);
                float z = Float.parseFloat(parts[3]);

                Vector3D vector3d = new Vector3D(x, y, z);
                verticeNormalList.add(vector3d);

                //System.out.println("x: " + x + " y: " + y + " z: " + z);
            }

            /*
             * Vertex texture coordinates
             * Parses both u and v coordinates into floats and stores in 3D Vector
             * -> (u, v, 0)
             */
            else if(line.startsWith("vt ")){
                String[] parts = line.split(" ");

                float u = Float.parseFloat(parts[1]);
                float v = Float.parseFloat(parts[2]);

                Vector3D vector3d = new Vector3D(u, v, 0f);
                verticeTextureList.add(vector3d);

                //System.out.println("u: " + u + " v: " + v);
            }

            /*
             * Face
             * Reads arbitrary amount of vertice-indexes
             * structure: f v/vt/vn v/vt/vn v/vt/vn v/vt/vn
             */
            else if(line.startsWith("f ")){
                String[] parts = line.split(" ");

                // int[VerticeID][VectorType]
                String[][] idxSep = new String[parts.length - 1][];
                int[][] idx = new int[parts.length - 1][];

                for (int i = 1; i < parts.length; i++) {
                    idxSep[i - 1] = parts[i].split("/");
                    idx[i - 1] = new int[idxSep[i - i].length];
                }

                for (int i = 0; i < idxSep.length; i++) {
                    for (int j = 0; j < idxSep[i].length; j++) {
                        idx[i][j] = Integer.parseInt(idxSep[i][j]);
                    }
                }

                // length of vertices
                Vertice[] vrt = new Vertice[idx.length];

                for (int i = 0; i < vrt.length; i++) {
                    int[] idxV = new int[3];

                    for(int j = 0; j < idx[i].length; j++)
                        idxV[j] = idx[i][j];

                    Vector3D v = verticeList.get(idxV[0] - 1);

                    /*
                     * the index 0 can be used due to no definition within the obj-file
                     * -> 0 doesn't exist as index access
                     */
                    Vector3D vt = idxV[1] == 0 ? new Vector3D() : verticeTextureList.get(idxV[1] - 1);
                    Vector3D vn = idxV[2] == 0 ? new Vector3D() : verticeTextureList.get(idxV[2] - 1);

                    vrt[i] = new Vertice(
                        v, 
                        vt, 
                        vn
                    );
                }
                Face face = new Face(vrt);
                faces.add(face);
            }

            else if(line.startsWith("o ")){
                String[] part = line.split(" ");
                name = part[1];
            }
        }
        br.close();
        
        Entity entity = new Entity(faces);
        entity.setName(name);
        entity.updatePosition(
            new Vector3D(
                new float[]{
                    50f, 50f, 2f
                }
            )
        );

        System.out.println(entity.toString());
    }

    public void createMaterial() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        boolean createMaterial = false;

        ArrayList<Material> materials = new ArrayList<>();

        Material mat = null;
        String matName = "";
        
        float d = 0f;
        float Ns = 0f;

        while((line = br.readLine()) != null){    
            line = line.replaceAll("^ +| +$|( )+", "$1");
            if(createMaterial){
                if(line.contains("Ka")){
                    String[] temp = line.split("Ka ");
                    String[] values = temp[1].split(" ");

                    int i = 0;

                    float[] Ka = new float[3];
                    for (String string : values) {
                        Ka[i++] = Float.parseFloat(string);
                    }
                    mat.setKa(Ka);
                }else if(line.contains("Kd ")){
                    String[] temp = line.split("Kd ");
                    String[] values = temp[1].split(" ");

                    float[] Kd = new float[3];
                    int i = 0;
                    
                    for (String string : values) {
                        Kd[i++] = Float.parseFloat(string);
                    }
                    mat.setKd(Kd);
                }else if(line.contains("Ks ")){
                    String[] temp = line.split("Ks ");
                    String[] values = temp[1].split(" ");

                    float[] Ks = new float[3];

                    int i = 0;
                    for (String string : values) {
                        Ks[i++] = Float.parseFloat(string);
                    }
                    mat.setKs(Ks);
                }else if(line.contains("Ke ")){
                    String[] temp = line.split("Ke ");
                    String[] values = temp[1].split(" ");

                    float[] Ke = new float[3];

                    int i = 0;
                    for (String string : values) {
                        Ke[i++] = Float.parseFloat(string);
                    }
                    mat.setKe(Ke);
                }else if(line.contains("illum")){
                    String[] temp = line.split("illum ");
                    mat.setIllum(Integer.parseInt(temp[1]));
                }else if(line.contains("d ") && !line.contains("Kd")){
                    String[] temp = line.split("d ");
                    d = Float.parseFloat(temp[1]);
                    mat.setD(d);
                }else if(line.contains("Ns ")){
                    String[] temp = line.split("Ns ");
                    Ns = Float.parseFloat(temp[1]);
                    mat.setNs(Ns);
                }else if(line.equals("")){
                    materials.add(mat);
                    createMaterial = false;
                }
            }
            else{
                if(line.startsWith("newmtl")){
                    createMaterial = true;
                    mat = new Material();
                    String[] temp = line.split(" ");
                    mat.setName(temp[1]);
                }
            }
        }
        if(mat != null)
            materials.add(mat);
        
        br.close();

        for (Material mats : materials) {
            System.out.println(mats);
        }
    }
}
