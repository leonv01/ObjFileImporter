package core.objmeta;
public class Material {
    protected String name;    // material name
    protected float[] Ka;     // ambient color
    protected float[] Kd;     // diffuse color
    protected float[] Ks;     // specular color
    protected float[] Ke;     // emissive coefficient
    protected float d;        // dissolve
    protected float Ns;       // specular highlights
    protected float Ni;       // optical density
    protected int illum;      // illumination model
    protected String map_Kd;  // color texture file

    public Material(){
        Ka = new float[3];
        Kd = new float[3];
        Ks = new float[3];
        Ke = new float[3];
        d = 0f;
        Ns = 0f;
        Ni = 0f;
        illum = 0;
        map_Kd = "";
    }

    public Material(
        String name,
        float[] Ka,
        float[] Kd, 
        float[] Ks,
        float[] Ke,
        float d, 
        float Ns,
        float Ni,
        int illum,
        String map_Kd
        ){
            this.name = name;
            this.Ka = Ka;
            this.Kd = Kd;
            this.Ks = Ks;
            this.Ke = Ke;
            this.d = d;
            this.Ns = Ns;
            this.Ni = Ni;
            this.illum = illum;
            this.map_Kd = map_Kd;
    }


    public void setName (String name){
        this.name = name;
    }
    public void setKa(float[] Ka){
        this.Ka = Ka;
    }
    public void setKd(float[] Kd){
        this.Kd = Kd;
    }
    public void setKs(float[] Ks){
        this.Ks = Ks;
    }
    public void setKe(float[] Ke){
        this.Ke = Ke;
    }
    public void setD(float d){
        this.d = d;
    }
    public void setNs(float Ns){
        this.Ns = Ns;
    }
    public void setNi(float Ni){
        this.Ni = Ni;
    }
    public void setIllum(int illum){
        this.illum = illum;
    }
    public void setMapKd(String map_Kd){
        this.map_Kd = map_Kd;
    }

    @Override
    public String toString(){
        return String.format(
            "material name: %s\n" + 
            "Ka: r(%f) g(%f) b(%f)\n" +
            "Kd: r(%f) g(%f) b(%f)\n" +
            "Ks: r(%f) g(%f) b(%f)\n" +
            "Ke: r(%f) g(%f) b(%f)\n" +
            "d: %f\n" + 
            "Ns: %f\n" +
            "Ni: %f\n" +
            "illum: %d\n" +
            "map_Kd: %s\n", 
            name,
            Ka[0], Ka[1], Ka[2],
            Kd[0], Kd[1], Kd[2], 
            Ks[0], Ks[1], Ks[2],
            Ke[0], Ke[1], Ke[2],
            d,
            Ns,
            Ni,
            illum,
            map_Kd
            );
    }
}
