
package com.portfolio.backend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTDTO {
    
    private String token;

    public JWTDTO(String token) {
        this.token = token;
    }
    
    
    
}
