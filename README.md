# weatherApp
Uber Cadence application

## Steps to run
1. Run:
```
docker-compose up
```
2. Register a Domain - enter console command:
```
  docker run --network=host --rm ubercadence/cli:master --do weather-domain domain register -rd 1
```
3. Run WeatherAppApplication

4. Enter in you browser search bar http://localhost:8080/weather
