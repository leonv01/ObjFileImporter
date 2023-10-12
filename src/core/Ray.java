package core;

import core.utils.Vector3D;

public class Ray {
    Vector3D origin;
    Vector3D direction;

    public Ray(Vector3D origin, Vector3D direction){
        this.origin = origin;
        this.direction = direction;
    }

    public Ray(Vector3D origin){
        this.origin = origin;
    }

    public Ray(){
        this.origin = new Vector3D();
        this.direction = new Vector3D();
    }

    public void setOrigin(Vector3D origin){
        this.origin = origin;
    }
    
    public void setDirection(Vector3D direction){
        this.direction = direction;
    }
}
