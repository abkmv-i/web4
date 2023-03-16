package com.lab.server.payload;

import com.lab.server.models.AttemptModel;
import java.util.List;

public class JwtResponse {

    private List<AttemptModel> coordinates;

    public JwtResponse(List<AttemptModel> attemptsModel) {
        this.coordinates = attemptsModel;
    }

    public JwtResponse() {
    }

    public List<AttemptModel> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<AttemptModel> coordinates) {
        this.coordinates = coordinates;
    }
}
