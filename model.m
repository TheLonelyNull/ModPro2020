ModuWeather : Location Temperature+ Unit Description* Health* [Forecast] Wind* :: _ModuWeather ;

Temperature : Current
	| Prediction
	| Real ;

Unit : Metric
	| Imperial ;

Description : Rain_data
	| Weather
	| Sunrise_and_sunset
	| Cloud
	| Visibility ;

Sunrise_and_sunset : [Solar_noon] :: _Sunrise_and_sunset ;

Health : UV-index
	| Airpollution
	| Activity ;

Wind : Speed
	| Direction
	| Summary ;

