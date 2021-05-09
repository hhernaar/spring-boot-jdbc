package com.hhernaar.jdbc.dao;

import java.util.List;
import java.util.Map;

public interface BookDao {

  public Map<String, Object> createUpdate(Object... params);

  public List<Map<String, Object>> find(Object... params);

  public void delete(Object... params);

}
