package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBHelper;

public class AcaraModel {
    private final Connection CONN;

    public AcaraModel() {
        this.CONN = DBHelper.getConnection();
    }

    public static void seedPelangganTable() {
        Connection conn = DBHelper.getConnection();

        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            // Membuat tabel Acara
            String createAcaraTable = "CREATE TABLE IF NOT EXISTS Acara (" +
                                        "id_acara INT AUTO_INCREMENT PRIMARY KEY," +
                                        "nama_acara VARCHAR(255)," +
                                        "jenis_acara VARCHAR(255)," +
                                        "tanggal_acara DATE," +
                                        "lokasi_acara VARCHAR(255)" +
                                    ")";
            stmt.executeUpdate(createAcaraTable);
            System.out.println("Tabel Acara berhasil dibuat");
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Menutup statement dan koneksi
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
