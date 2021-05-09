package com.hhernaar.jdbc.dao.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hhernaar.jdbc.dao.BookDao;
import com.hhernaar.jdbc.util.JDBCUtil;
import com.hhernaar.jdbc.util.Procedure;

@Repository
public class BookDaoImpl implements BookDao {

  @Autowired
  private JDBCUtil jdbcUtil;

  @Override
  public Map<String, Object> createUpdate(Object... params) {
    return jdbcUtil.spToMap(Procedure.BOOK_CREATE_UPDATE, params);
  }

  @Override
  public List<Map<String, Object>> find(Object... params) {
    return jdbcUtil.spToList(Procedure.BOOK_FIND, params);
  }

  @Override
  public void delete(Object... params) {
    jdbcUtil.callProcedure(Procedure.BOOK_DELETE, params);
  }

}
