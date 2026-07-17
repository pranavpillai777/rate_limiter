package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class Model {
    int limit=10;

    private final int capacity = limit;
    private int currentToken;
    private long lastRefillTimeStamp;

}