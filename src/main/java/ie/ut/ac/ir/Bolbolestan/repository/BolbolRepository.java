package ie.ut.ac.ir.Bolbolestan.repository;

import ie.ut.ac.ir.Bolbolestan.model.Bolbol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BolbolRepository extends Repository<Bolbol, String> {
    private static final String TABLE_NAME = "Bolbol";
    private static BolbolRepository instance;

    public static BolbolRepository getInstance() {
        if (instance == null) {
            try {
                instance = new BolbolRepository();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error in BolbolRepository.create query.");
            }
        }
        return instance;
    }

    private BolbolRepository() throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement createTableStatement = con.prepareStatement(
                String.format("CREATE TABLE IF NOT EXISTS %s(id CHAR(50),\nname CHAR(225),\nhabitat CHAR(225),\nPRIMARY KEY(id));", TABLE_NAME)
        );
        createTableStatement.executeUpdate();
        createTableStatement.close();
        con.close();
    }

    @Override
    protected String getFindByIdStatement() {
        return String.format("SELECT* FROM %s bolbol WHERE bolbol.id = ?;", TABLE_NAME);
    }

    @Override
    protected void fillFindByIdValues(PreparedStatement st, String id) throws SQLException {
        st.setString(1, id);
    }

    @Override
    protected String getInsertStatement() {
        return String.format("INSERT INTO %s(id, name, habitat) VALUES(?,?,?)", TABLE_NAME);
    }

    @Override
    protected void fillInsertValues(PreparedStatement st, Bolbol data) throws SQLException {
        st.setString(1, data.getId());
        st.setString(2, data.getName());
        st.setString(3, data.getHabitat());
    }

    @Override
    protected String getFindAllStatement() {
        return String.format("SELECT * FROM %s;", TABLE_NAME);
    }

    @Override
    protected Bolbol convertResultSetToDomainModel(ResultSet rs) throws SQLException {
        Bolbol bolbol = new Bolbol(rs.getString(1), rs.getString(2), rs.getString(3));
        return bolbol;
    }

    @Override
    protected ArrayList<Bolbol> convertResultSetToDomainModelList(ResultSet rs) throws SQLException {
        ArrayList<Bolbol> bolbols = new ArrayList<>();
        while (rs.next()) {
            bolbols.add(this.convertResultSetToDomainModel(rs));
        }
        return bolbols;
    }
}
