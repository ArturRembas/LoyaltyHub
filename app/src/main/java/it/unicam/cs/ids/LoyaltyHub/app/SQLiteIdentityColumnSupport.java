package it.unicam.cs.ids.LoyaltyHub.app;


import org.hibernate.dialect.identity.IdentityColumnSupportImpl;


/**
 * SQLiteIdentityColumnSupport is a custom identity column support implementation for the SQLite database.
 * This class extends the IdentityColumnSupportImpl from Hibernate and provides SQLite-specific
 * implementations of identity column-related methods. It enables proper handling of SQLite autoincrement
 * columns and identity column queries when using Hibernate.
 *
 * @author YourName
 */
public class SQLiteIdentityColumnSupport extends IdentityColumnSupportImpl {

    @Override
    public boolean supportsIdentityColumns() {
        return true;
    }

    @Override
    public String getIdentitySelectString(String table, String column, int type) {
        return "select last_insert_rowid()";
    }

    @Override
    public String getIdentityColumnString(int type) {
        return "integer";
    }

    @Override
    public boolean hasDataTypeInIdentityColumn() {
        return false;
    }

    @Override
    public String getIdentityInsertString() {
        return "null";
    }
}
