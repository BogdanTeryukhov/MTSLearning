package org.mts.randomAnimalsCreation;

import jakarta.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Component
@Validated
@ConfigurationProperties(prefix = "animals")
public class AnimalProperties {
    @NotNull
    private List<String> catNames;
    @NotNull
    private List<String> dogNames;
    @NotNull
    private List<String> wolfNames;
    @NotNull
    private List<String> sharkNames;

    public List<String> getCatNames() {
        return catNames;
    }

    public void setCatNames(List<String> catNames) {
        this.catNames = catNames;
    }

    public List<String> getDogNames() {
        return dogNames;
    }

    public void setDogNames(List<String> dogNames) {
        this.dogNames = dogNames;
    }

    public List<String> getWolfNames() {
        return wolfNames;
    }

    public void setWolfNames(List<String> wolfNames) {
        this.wolfNames = wolfNames;
    }

    public List<String> getSharkNames() {
        return sharkNames;
    }

    public void setSharkNames(List<String> sharkNames) {
        this.sharkNames = sharkNames;
    }
}
