package com.ecommerce.project.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class ApiResponse {

    public boolean status;

    public int code;

    public Object data;

}
