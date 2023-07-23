package org.tuke.exception;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

public class CustomSqlErrorCodeTranslator extends SQLErrorCodeSQLExceptionTranslator {

	@Override
	protected DataAccessException customTranslate(String task, String sql, SQLException sqlEx) {
		
		if(sqlEx.getErrorCode()==1062) {
			return new DuplicateKeyException("Custom SQL Error code translator. Duplicate exception raised",sqlEx);
			
		}

		return super.customTranslate(task, sql, sqlEx);
	}
	
	

}
