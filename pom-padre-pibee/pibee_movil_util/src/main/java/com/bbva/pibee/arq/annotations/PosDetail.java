package com.bbva.pibee.arq.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PosDetail {
String posicion();
}
