package com.hhernaar.jdbc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

/**
 * Generic Class to execute SP's and return in List or Map form.
 * 
 * @author hhernaar
 */
@Component
public class JDBCUtil {

  @Autowired
  private JdbcTemplate jdbcTemplate;


  /**
   * @param sp Name of Procedure
   * @param params Object Array with all parameters to execute Procedure.
   * 
   * @return {@code Map<String, Object>}
   */
  public Map<String, Object> callProcedure(String sp, Object... params) {
    SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName(sp);
    return params != null ? call.execute(params) : call.execute();
  }


  /**
   * @param sp Name of Procedure
   * @param params Object Array with all parameters to execute Procedure.
   * 
   * @return {@code List<Map<String, Object>>}
   */
  @SuppressWarnings("unchecked")
  public List<Map<String, Object>> spToList(String sp, Object... params) {
    Map<String, Object> mapResult = callProcedure(sp, params);
    return mapResult.isEmpty() ? new ArrayList<Map<String, Object>>()
        : (ArrayList<Map<String, Object>>) mapResult.get("#result-set-1");
  }


  /**
   * @param sp Name of Procedure
   * @param params Object Array with all parameters to execute Procedure.
   * 
   * @return {@code Map<String, Object>}
   */
  public Map<String, Object> spToMap(String sp, Object... params) {
    List<Map<String, Object>> lstResult = spToList(sp, params);
    return lstResult.isEmpty() ? new HashMap<String, Object>() : lstResult.get(0);
  }

}
