package model;

import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgeDAO
{
    /** DBコネクション */
    public Connection con;
    /** DBステートメント */
    PreparedStatement stmt;
    ResultSet rs;
    AgeDTO dto;

    public List<AgeDTO> selectById(int ageId) throws SQLException, ClassNotFoundException, NumberFormatException
    {
        List<AgeDTO> ageList = new ArrayList<>();
        String sql = "SELECT * FROM age_table WHERE age_id = "+ ageId + ";" ;

        try {
            con = DBManager.getConnection();
            this.stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                dto = new AgeDTO();
                ageList.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            con.close();
        }
        return ageList;


    }
}
