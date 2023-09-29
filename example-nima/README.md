# example-nima



## Build and run


With JDK21
```bash
mvn package
java -jar target/example-nima.jar
```

## Exercise the application


### Database Setup

In the `pom.xml` and `application.yaml` we provide configuration needed for mongodb database.
Start your database before running this example.

Example docker commands to start databases in temporary containers:


```
docker run --rm --name mongo -p 27017:27017 mongo
```


### Exercise The Database Endpoints

```
curl -X GET http://localhost:8080/db
```


## Exercise Webclient

First, start the server:

```
java -jar target/example-nima.jar
```

Note the port number that it displays. For example:

```
WEB server is up! http://localhost:8080/simple-greet
```

Then run the client, passing the port number. It will connect
to the server:

```
java -cp "target/classes:target/libs/*" ru.yakimov.example.nima.WebClientMain PORT
```



## Building a Native Image



## Using Micrometer

Access the `/micrometer` endpoint which reports the newly-added timer and counter.

```bash
curl http://localhost:8080/micrometer
```
`SimpleGreetService` has a micrometer counter that is incremented each time a GET request is made at
`http://localhost:8080/greet-count`. The counter name is `allRequests` and is shown in the console
with the number of time it was triggered.

```
curl http://localhost:8080/micrometer
# HELP allRequests_total
# TYPE allRequests_total counter
allRequests_total 0.0
```


## Try health

This example shows the basics of using Helidon SE Health. It uses the
set of built-in health checks that Helidon provides plus defines a
custom health check.

Note the port number reported by the application.

Probe the health endpoints:

```bash
curl -X GET http://localhost:8080/observe/health/
curl -X GET http://localhost:8080/observe/health/ready
```


## Tracing

### Set up Zipkin

First, you need to run the Zipkin tracer. Helidon will communicate with this tracer at runtime.

Run Zipkin within a docker container, then check the Zipkin server health:
```
docker run -d --name zipkin -p 9411:9411 openzipkin/zipkin
```
Run the Zipkin docker image named openzipkin/zipkin.
Check the Zipkin server health:
```
curl http://localhost:9411/health
```
Invoke the Zipkin REST API to check the Zipkin server health.
```
Response body
{
  "status": "UP",
  "zipkin": {
    "status": "UP",
    "details": {
      "InMemoryStorage{}": {
        "status": "UP"
      }
    }
  }
}
```
All status fields should be UP.

### View Tracing Using Zipkin REST API

Run the curl command and check the response:
```
curl http://localhost:9411/api/v2/services
```
Response body
```
["helidon-mp-1"]
```

### View Tracing Using Zipkin UI

Zipkin provides a web-based UI at http://localhost:9411/zipkin, where you can see a visual representation of 
the same data and the relationship between spans within a trace.


## Try metrics

```
# Prometheus Format
curl -s -X GET http://localhost:8080/observe/metrics
# TYPE base:gc_g1_young_generation_count gauge
. . .

# JSON Format
curl -H 'Accept: application/json' -X GET http://localhost:8080/observe/metrics
{"base":...
. . .
```



## Building the Docker Image

```
docker build -t example-nima .
```

## Running the Docker Image

```
docker run --rm -p 8080:8080 example-nima:latest
```

Exercise the application as described above.
                                

## Run the application in Kubernetes

If you don’t have access to a Kubernetes cluster, you can [install one](https://helidon.io/docs/latest/#/about/kubernetes) on your desktop.

### Verify connectivity to cluster

```
kubectl cluster-info                        # Verify which cluster
kubectl get pods                            # Verify connectivity to cluster
```

### Deploy the application to Kubernetes

```
kubectl create -f app.yaml                  # Deploy application
kubectl get pods                            # Wait for quickstart pod to be RUNNING
kubectl get service  example-nima         # Get service info
```

Note the PORTs. You can now exercise the application as you did before but use the second
port number (the NodePort) instead of 8080.

After you’re done, cleanup.

```
kubectl delete -f app.yaml
```
                                
