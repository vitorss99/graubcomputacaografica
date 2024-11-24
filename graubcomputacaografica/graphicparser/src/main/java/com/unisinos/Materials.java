package com.unisinos;
import org.joml.Vector3f;

public class Materials {
    public Vector3f ka; // Ambiente
    public Vector3f kd; // Difusa
    public Vector3f ks; // Especular
    public float ns;    // Shininess

    public Materials(Vector3f ka, Vector3f kd, Vector3f ks, float ns) {
        this.ka = ka;
        this.kd = kd;
        this.ks = ks;
        this.ns = ns;
    }
}
