import { defineStore } from "pinia";
import { ref } from "vue";
import axios from "axios";

export const useWeatherStore = defineStore('weather', () => {
    let today = ref('');

    function getWeather() {
        axios.get("http://localhost:8088/weather")
            .then(response => response.data)
            .then(weather => {
                console.log("weather");
                console.log(weather);
                console.log(weather.time);
                today.value = weather.time;
            })
            .catch(err => console.error(err));
    }

    return { today, getWeather }
});