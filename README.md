# OCPP 1.6J Implementation (Charge Point)

Run `Application.java` and give VM parameter with url to Central System

``-Durl=ws://localhost:8180/ws/CentralSystemService/CB4711``

As soon as application started, you may send HTTP request in order to send a BootNotification to Central System

``POST http://localhost:8080/chargepoint/boot``

Authorize

``POST http://localhost:8080/chargepoint/authorize``