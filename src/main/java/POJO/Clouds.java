package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Clouds {

private Integer all;

public Integer getAll() {
return all;
}

public void setAll(Integer all) {
this.all = all;
}

}
