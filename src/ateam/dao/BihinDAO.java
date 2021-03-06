package ateam.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import ateam.model.Bihin;

public class BihinDAO {
    private static BihinDAO instance = new BihinDAO();
    private static BihinBeansMapping mapping = new BihinBeansMapping();

    private BihinDAO() {
    }

    public static BihinDAO getInstance() {
        return instance;
    }

    //全件操作
    public List<Bihin> getBihinList() {
        String sql = "SELECT * FROM BihinKanri ORDER BY bihinID ASC ";

        try {
            return DBManager.getList(sql, mapping);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    //自身の借りているものを表示
    public List<Bihin> getBihinList(String userID) {
        String sql = "SELECT * FROM BihinKanri WHERE userID = ? ORDER BY bihinID ASC ";

        try {
            return DBManager.getList(sql, userID, mapping);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    //サーチ（ステータスのみ）
    public List<Bihin> searchBihin(int status) {
        String sql = "SELECT * FROM BihinKanri WHERE status = ? ORDER BY bihinID ASC ";

        try {
            return DBManager.getSearchList(sql, status, mapping);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    //サーチ(全件表示)
    public List<Bihin> searchBihin(String bihinKana, String bihinName) {
        String sql = "SELECT * FROM BihinKanri WHERE bihinKana LIKE ? OR bihinName LIKE ? ORDER BY bihinID ASC ";

        try {
            return DBManager.getSearchList(sql, bihinKana, bihinName, mapping);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    //サーチ（ステータス＋名前)
    public List<Bihin> searchBihin(String bihinKana, String bihinName, int status) {
        String sql = "SELECT * FROM BihinKanri where status = " + status
                + " and (bihinKana LIKE ? OR bihinName LIKE ?) ORDER BY bihinID ASC ";
        try {
            return DBManager.getSearchList(sql, bihinKana, bihinName, mapping);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    //ステータス変更(返却)
    public int update(String userID, String bihinID) {
        String sql = "UPDATE BihinKanri SET status = "+Bihin.AVAILABLE+" ,userID = NULL , returnDay =  NULL WHERE userID = ? and bihinID = ?";
        try {
            return DBManager.doUpdate(sql, userID, bihinID);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    //ステータス変更(貸出)
    public int update(String bihinID, String userID, Date returnDay) {
        String sql = "UPDATE BihinKanri SET status = "+Bihin.USED+" ,userID = ? , returnDay = ? WHERE bihinID = ?";
        try {
            return DBManager.doUpdate(sql, userID, returnDay, bihinID);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    //一行の情報を取得
    public Bihin getBihin(String bihinID) {
        String sql = "SELECT *  FROM BihinKanri WHERE bihinID = ?";
        try {
            return DBManager.getObject(sql, bihinID, mapping);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
