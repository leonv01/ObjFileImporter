package core.utils;

public class Vector3D {
    float x,y,z;

    public Vector3D(){
        x = 0f;
        y = 0f;
        z = 0f;
    }

    public Vector3D(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(float[] coordinates){
        this.x = coordinates[0];
        this.y = coordinates[1];
        this.z = coordinates[2];
    }

    public Vector3D(Vector3D vec){
        this.x = vec.x;
        this.y = vec.y;
        this.z = vec.z;
    }

    public void add(Vector3D vec){
        this.x += vec.x;
        this.y += vec.y;
        this.z += vec.z;
    }

    public void sub(Vector3D vec){
        this.x -= vec.x;
        this.y -= vec.y;
        this.z -= vec.z;
    }

    public double distance(Vector3D vec){
        double tempX = this.x - vec.x;
        double tempY = this.y - vec.y;
        double tempZ = this.z - vec.z;
        return Math.sqrt(tempX * tempX + tempY + tempY + tempZ * tempZ);
    }

    public void rotateX(double degree){
        float tempX = x;
        float tempY = y;

        x = (float)(tempX * Math.cos(degree) - tempY * Math.sin(degree));
        y = (float)(tempX * Math.sin(degree) + tempY * Math.cos(degree));
    }

    public void rotateY(double degree){
        float tempX = x;
        float tempY = y;

        x = (float)(tempX * Math.cos(degree) - tempY * Math.sin(degree));
        y = (float)(tempX * Math.sin(degree) + tempY * Math.cos(degree));
    }

    public void rotateZ(double degree){
        float tempX = x;
        float tempY = y;

        x = (float)(tempX * Math.cos(degree) - tempY * Math.sin(degree));
        y = (float)(tempX * Math.sin(degree) + tempY * Math.cos(degree));
    }

    public void scale(float s){
        x *= s;
        y *= s;
        z *= s;
    }

    public double length(){
        return (float) Math.sqrt(
            x * x +
            y * y +
            z * z
        );
    }

    public static Vector3D add(Vector3D vec1, Vector3D vec2){
        return new Vector3D(
            vec1.x + vec2.x, 
            vec1.y + vec2.y, 
            vec1.z + vec2.z);
    }

    public Vector3D crossProduct(Vector3D vec1, Vector3D vec2){
        return new Vector3D(     
            vec1.y * vec2.z - vec1.z * vec2.y,
            vec1.z * vec2.x - vec1.x * vec2.z,
            vec1.x * vec2.y - vec1.y * vec2.x
        );
    } 

    public double dotProduct(Vector3D v1, Vector3D v2){
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    @Override
    public String toString(){
        return String.format( "x: %f\t y: %f\t z: %f", 
            x,y,z
        );
    }
}
