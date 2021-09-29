# SpringBootGCPSecretManager
Example SpringBoot + Google Cloud Platform + Secret Manager

### Autenticacion con el SDK de Cloud.
```
gcloud auth application-default login
```

### Listar proyecto
```
gcloud config list project
```

### Habilitar API
```
gcloud services enable secretmanager.googleapis.com
```

### Crear secret
```
echo HOlA SECRET | gcloud secrets create greeting --data-file=- --replication-policy=automatic
```

### Listar secrets
```
gcloud secrets list
```

### Agregar dependencia en el pom
```xml
  <dependencies>
    ...
    <!-- Add Secret Manager Starter -->
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>spring-cloud-gcp-starter-secretmanager</artifactId>
    </dependency>
  </dependencies>
```

### Usar directamente
```java
  @Value("${sm://greeting}")
  String greeting;
```  
### Usar desde archivo propertie
src/main/resources/application.properties
```
greeting_prop=${sm://greeting}
```
 Uso
```java
  @Value("${greeting_prop}")
  String greetingProp;
```
### Usar desde archivo propertie por ambiente

1. crear secret productivo
```
echo HOlA SECRET | gcloud secrets create greeting-prod --data-file=- --replication-policy=automatic
```
2. Agregar properties prod

src/main/resources/application-prod.properties
```
greeting=${sm://greeting-prod}
```

3. Hay que cambiar el perfil al ejecutar para usar el archivo propertie correspondiente
```
./mvnw -DskipTests spring-boot:run -Dspring-boot.run.profiles=prod
```

### Fuente:
https://codelabs.developers.google.com/codelabs/cloud-spring-cloud-gcp-secret-manager#0
