package com.gordao.e1.ui;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class EntitySpec {
  public final String id; // nome do arquivo / label
  public final List<FieldSpec> fields;
  public final Function<Map<String,Object>, Object> factory; // instancia a classe

  public EntitySpec(String id, List<FieldSpec> fields, Function<Map<String,Object>, Object> factory) {
    this.id = id;
    this.fields = fields;
    this.factory = factory;
  }
}
