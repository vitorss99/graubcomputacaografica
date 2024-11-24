package com.unisinos;
import org.joml.Vector3f;


public static Materials loadMaterial(String mtlFile) {
    Vector3f ka = new Vector3f(0.1f, 0.1f, 0.1f);
    Vector3f kd = new Vector3f(0.8f, 0.8f, 0.8f);
    Vector3f ks = new Vector3f(1.0f, 1.0f, 1.0f);
    float ns = 32.0f;

    try (BufferedReader reader = new BufferedReader(new FileReader(mtlFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Ka":
                    ka = new Vector3f(
                        Float.parseFloat(tokens[1]),
                        Float.parseFloat(tokens[2]),
                        Float.parseFloat(tokens[3])
                    );
                    break;
                case "Kd":
                    kd = new Vector3f(
                        Float.parseFloat(tokens[1]),
                        Float.parseFloat(tokens[2]),
                        Float.parseFloat(tokens[3])
                    );
                    break;
                case "Ks":
                    ks = new Vector3f(
                        Float.parseFloat(tokens[1]),
                        Float.parseFloat(tokens[2]),
                        Float.parseFloat(tokens[3])
                    );
                    break;
                case "Ns":
                    ns = Float.parseFloat(tokens[1]);
                    break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return new Material(ka, kd, ks, ns);
}