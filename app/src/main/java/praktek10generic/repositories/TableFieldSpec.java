package praktek10generic.repositories;

import java.util.function.Function;

import praktek10generic.models.enums.TableFieldType;

public class TableFieldSpec<T> {
  public String name;
  public TableFieldType type;
  public Function<T, Object> getValue;

  public TableFieldSpec(String name, TableFieldType type, Function<T, Object> getValue) {
    this.name = name;
    this.type = type;
    this.getValue = getValue;
  }
}
