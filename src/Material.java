public class Material {
    String name;
    float[] Ka;
    float[] Kd;
    float[] Ks;
    float[] Ke;
    float d;
    float Ns;

    public Material(){
        Ka = new float[3];
        Kd = new float[3];
        Ks = new float[3];
        Ke = new float[3];
        d = 0;
        Ns = 0;
    }

    public Material(
        String name,
        float[] Ka,
        float[] Kd, 
        float[] Ks,
        float[] Ke,
        float d, 
        float Ns){
            this.name = name;
            this.Ka = Ka;
            this.Kd = Kd;
            this.Ks = Ks;
            this.Ke = Ke;
            this.d = d;
            this.Ns = Ns;
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


    @Override
    public String toString(){
        return String.format(
            "material name: %s\n" + 
            "Ka: r(%f) g(%f) b(%f)\n" +
            "Kd: r(%f) g(%f) b(%f)\n" +
            "Ks: r(%f) g(%f) b(%f)\n" +
            "Ke: r(%f) g(%f) b(%f)\n" +
            "d: %f\n" + 
            "Ns: %f\n", 
            name,
            Ka[0], Ka[1], Ka[2],
            Kd[0], Kd[1], Kd[2], 
            Ks[0], Ks[1], Ks[2],
            Ke[0], Ke[1], Ke[2],
            d,
            Ns
            );
    }
}
