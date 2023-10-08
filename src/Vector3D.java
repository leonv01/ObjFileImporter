
public class Vector3D {
    float[] coordinates = new float[3];

    public Vector3D(){
        coordinates[0] = 0f;
        coordinates[1] = 0f;
        coordinates[2] = 0f;
    }

    public Vector3D(float x, float y, float z){
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = z;
    }

    public Vector3D(float[] coordinates){
        this.coordinates = coordinates;
    }

    public void add(Vector3D vec){
        for(int i = 0; i < 3; i++)
            coordinates[i] += vec.coordinates[i];
    }

    public static Vector3D add(Vector3D vec1, Vector3D vec2){
        return new Vector3D(
            vec1.coordinates[0] + vec2.coordinates[0],
            vec1.coordinates[1] + vec2.coordinates[1],
            vec1.coordinates[2] + vec2.coordinates[2]
        );
    }

    public void sub(Vector3D vec){
        for(int i = 0; i < 3; i++)
            coordinates[i] -= vec.coordinates[i];
    }

    public void scale(float s){
        for(int i = 0; i < 3; i++)
            coordinates[i] *= s;
    }

    public float length(){
        return (float) Math.sqrt(
            coordinates[0] * coordinates[0] +
            coordinates[1] * coordinates[1] +
            coordinates[2] * coordinates[2] 
        );
    }

    @Override
    public String toString(){
        return String.format( "x: %f\t y: %f\t z: %f", 
            coordinates[0], coordinates[1], coordinates[2]
        );
    }
}