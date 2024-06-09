package com.example.demo.entity;

import java.util.List;

public class CustomeDTO {

    private Integer totalCounts;
    private List<DTO> dtos;

    public CustomeDTO(Integer totalCounts, List<DTO> dtos) {
        this.totalCounts = totalCounts;
        this.dtos = dtos;
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<DTO> getDtos() {
        return dtos;
    }

    public void setDtos(List<DTO> dtos) {
        this.dtos = dtos;
    }

}
