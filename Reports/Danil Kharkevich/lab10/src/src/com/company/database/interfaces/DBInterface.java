package com.company.database.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DBInterface <T> {
    T Add(T entity) throws SQLException;
    void Update(T entity) throws SQLException;
    void Delete(T entity) throws SQLException;
    T GetByIdOrNull(int id) throws SQLException;
    ArrayList<T> GetAll() throws SQLException;
}
