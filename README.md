# weatherApp
Uber Cadence application

## Steps to run
run:
```
docker-compose up
```
Register a Domain - enter console command:
```
  docker run --network=host --rm ubercadence/cli:master --do weather-domain domain register -rd 1
```
Run WeatherAppApplication

Enter in you browser search bar
http://localhost:8080/weather
