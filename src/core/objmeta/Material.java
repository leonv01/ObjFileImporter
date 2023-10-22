package core.objmeta;
public class Material {
    private String name;    // material name
    private float[] ka;     // ambient color
    private float[] kd;     // diffuse color
    private float[] ks;     // specular color
    private float[] ke;     // emissive coefficient
    private float d;        // dissolve
    private float ns;       // specular highlights
    private float ni;       // optical density
    private int illum;      // illumination model
    private String mapKd;  // color texture file

    public Material(){
        ka = new float[3];
        kd = new float[3];
        ks = new float[3];
        ke = new float[3];
        d = 0f;
        ns = 0f;
        ni = 0f;
        illum = 0;
        mapKd = "";
    }

    public Material(
        String name,
        float[] ka,
        float[] kd, 
        float[] ks,
        float[] ke,
        float d, 
        float ns,
        float ni,
        int illum,
        String mapKd
        ){
            this.name = name;
            this.ka = ka;
            this.kd = kd;
            this.ks = ks;
            this.ke = ke;
            this.d = d;
            this.ns = ns;
            this.ni = ni;
            this.illum = illum;
            this.mapKd = mapKd;
    }


    public void setName (String name){
        this.name = name;
    }
    public void setKa(float[] ka){
        this.ka = ka;
    }
    public void setKd(float[] kd){
        this.kd = kd;
    }
    public void setKs(float[] ks){
        this.ks = ks;
    }
    public void setKe(float[] ke){
        this.ke = ke;
    }
    public void setD(float d){
        this.d = d;
    }
    public void setNs(float ns){
        this.ns = ns;
    }
    public void setNi(float ni){
        this.ni = ni;
    }
    public void setIllum(int illum){
        this.illum = illum;
    }
    public void setMapKd(String mapKd){
        this.mapKd = mapKd;
    }

    public String getName() {
        return name;
    }
    public float[] getKa() {
        return ka;
    }
    public float[] getKd() {
        return kd;
    }
    public float[] getKs() {
        return ks;
    }
    public float[] getKe() {
        return ke;
    }
    public float getD() {
        return d;
    }
    public float getNs() {
        return ns;
    }
    public float getNi() {
        return ni;
    }
    public int getIllum() {
        return illum;
    }
    public String getMapKd() {
        return mapKd;
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
            ka[0], ka[1], ka[2],
            kd[0], kd[1], kd[2], 
            ks[0], ks[1], ks[2],
            ke[0], ke[1], ke[2],
            d,
            ns,
            ni,
            illum,
            mapKd
            );
    }
}
