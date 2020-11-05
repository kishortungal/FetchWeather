package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

private Double temp;
private Double feelsLike;
private Double tempMin;
private Integer tempMax;
private Integer pressure;
private Integer humidity;

public Double getTemp() {
return temp;
}

public void setTemp(Double temp) {
this.temp = temp;
}

public Double getFeelsLike() {
return feelsLike;
}

public void setFeelsLike(Double feelsLike) {
this.feelsLike = feelsLike;
}

public Double getTempMin() {
return tempMin;
}

public void setTempMin(Double tempMin) {
this.tempMin = tempMin;
}

public Integer getTempMax() {
return tempMax;
}

public void setTempMax(Integer tempMax) {
this.tempMax = tempMax;
}

public Integer getPressure() {
return pressure;
}

public void setPressure(Integer pressure) {
this.pressure = pressure;
}

public Integer getHumidity() {
return humidity;
}

public void setHumidity(Integer humidity) {
this.humidity = humidity;
}

}
