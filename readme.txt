0. Build the application
1. Setup MongoDB server and update the application.properties accordingly, if needed

2. Start the application
java -jar web-quarantine--service.jar

3. Use a REST client like postman or CURL and make POST requests with body that looks like
{"id":1, "cid": 123, "cname": "Cisco", "url": "www.google.com", "webcats" : ["search", "unknown"]}
to http://localhost:8081/incident

The below methods can be used:
curl --data '{"id":1, "cid": 123, "cname": "Cisco", "url": "www.google.com", "webcats" : ["search", "unknown"]}' -H "content-type:application/json" http://localhost:8081/incident
or use http://localhost:8081/swagger-ui.html
