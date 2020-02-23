package com.example.buildByQuantity.modelTest;

import com.example.buildByQuantity.annotations.BuildByQuantity;
import lombok.Data;

@BuildByQuantity(quantity = 5)
@Data
public class User {
    private String name;
    private String surname;
}
