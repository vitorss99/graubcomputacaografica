#version 330 core

struct Material {
    vec3 ka;  // Ambiente
    vec3 kd;  // Difusa
    vec3 ks;  // Especular
    float ns; // Shininess
};

uniform Material material;
uniform vec3 lightPos;
uniform vec3 lightColor;
uniform vec3 cameraPos;

in vec3 FragPos;
in vec3 Normal;

out vec4 FragColor;

void main() {
    // Vetores para iluminação
    vec3 norm = normalize(Normal);
    vec3 lightDir = normalize(lightPos - FragPos);
    vec3 viewDir = normalize(cameraPos - FragPos);
    vec3 reflectDir = reflect(-lightDir, norm);

    // Ambiente
    vec3 ambient = material.ka * lightColor;

    // Difusa
    float diff = max(dot(norm, lightDir), 0.0);
    vec3 diffuse = material.kd * diff * lightColor;

    // Especular
    float spec = pow(max(dot(viewDir, reflectDir), 0.0), material.ns);
    vec3 specular = material.ks * spec * lightColor;

    // Resultado final
    vec3 result = ambient + diffuse + specular;
    FragColor = vec4(result, 1.0);
}
