From openjdk:17
copy ./target/FlightReservation-0.0.1-SNAPSHOT.jar FlightReservation-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","FlightReservation-0.0.1-SNAPSHOT.jar"]