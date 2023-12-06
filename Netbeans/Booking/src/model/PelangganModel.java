package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBHelper;

public class PelangganModel {
    private final Connection CONN;

    public PelangganModel() {
        this.CONN = DBHelper.getConnection();
    }

    public static void seedPelangganTable() {
        Connection conn = DBHelper.getConnection();

        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            // Membuat tabel Pelanggan
            String createPelangganTable = "CREATE TABLE IF NOT EXISTS Pelanggan (" +
                                            "id_pelanggan INT AUTO_INCREMENT PRIMARY KEY," +
                                            "nama_pelanggan VARCHAR(255)," +
                                            "email_pelanggan VARCHAR(255)," +
                                            "alamat_pelanggan VARCHAR(255)," +
                                            "no_telepon_pelanggan VARCHAR(15)" +
                                        ")";
            stmt.executeUpdate(createPelangganTable);
            System.out.println("Tabel Pelanggan berhasil dibuat");
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
