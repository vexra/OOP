package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBHelper;

public class TiketModel {
    private final Connection CONN;

    public TiketModel() {
        this.CONN = DBHelper.getConnection();
    }

    public static void seedPelangganTable() {
        Connection conn = DBHelper.getConnection();

        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            // Membuat tabel Tiket
            String createTiketTable = "CREATE TABLE IF NOT EXISTS Tiket (" +
                                        "id_tiket INT AUTO_INCREMENT PRIMARY KEY," +
                                        "id_acara INT," +
                                        "jenis_tiket VARCHAR(255)," +
                                        "harga_tiket DECIMAL(10, 2)," +
                                        "jumlah_tiket INT," +
                                        "FOREIGN KEY (id_acara) REFERENCES Acara(id_acara)" +
                                    ")";
            stmt.executeUpdate(createTiketTable);
            System.out.println("Tabel Tiket berhasil dibuat");
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
