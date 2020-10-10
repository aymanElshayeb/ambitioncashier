package com.itambition.pos.controller;

import lombok.*;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.hibernate.internal.build.AllowSysOut;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionObj {

    @Getter @Setter
    int parcode;
    @Getter @Setter
    int quantity;

    public SessionObj(int quantity, int parcode) {
        this.parcode=parcode;
        this.quantity=quantity;
    }
}
