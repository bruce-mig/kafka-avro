# kafka-avro

This repository demonstrates a Spring Boot application that integrates with Apache Kafka to send messages using the Confluent Platform. Apache Avro is used as the serialization format, and the Confluent Schema Registry is leveraged to manage and track schema changes effectively.

## Features

- **Spring Boot Producer:** Sends messages to a Kafka topic.
- **Apache Kafka:** Message broker using KRaft consensus protocol for asynchronous communication between producer and consumer.
- **Apache Avro:** Schema-based serialization for lightweight and efficient data encoding.
- **Confluent Schema Registry:** Centralized repository for managing and evolving Avro schemas.

## Prerequisites

To run this project locally, ensure you have the following installed:

1. [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
2. [Apache Kafka](https://kafka.apache.org/downloads)
3. [Confluent Schema Registry](https://docs.confluent.io/platform/current/schema-registry/index.html)
4. [Maven](https://maven.apache.org/install.html)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/bruce-mig/kafka-avro.git
cd kafka-avro
```

### Configure Application

Edit the `application.yml` or `application.properties` file to configure the following:

1. **Kafka broker address**
2. **Schema Registry URL**
3. **Topic name**

### Build and Run

Build the project using Maven:

```bash
cd producer 
mvn clean install

cd consumer 
mvn clean install
```

Run the Spring Boot application:

```bash
java -jar producer/target/producer-0.0.1-SNAPSHOT.jar

java -jar consumer/target/consumer-0.0.1-SNAPSHOT.jar
```

## How It Works

1. **Producer:**
    - Uses `KafkaTemplate` to publish messages to a Kafka topic.
    - Messages are serialized using Avro, and the schema is registered with the Schema Registry.

2. **Schema Registry:**
    - Manages and validates the Avro schema for each message.
    - Ensures compatibility when schema evolves.

3. **Consumer:**
    - Listens to the Kafka topic and deserializes messages using the schema from the Schema Registry.


## Dependencies

Refer to `pom.xml` for the full list of dependencies.


## Compatibility

- Apache Kafka: 4.0.x or later
- Confluent Schema Registry: 7.9.x or later
- Avro: 1.12.x or later

## Contributions

Contributions are welcome! Feel free to fork this repository and submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Happy coding!