package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBHelper;

public class PembayaranModel {
    private final Connection CONN;

    public PembayaranModel() {
        this.CONN = DBHelper.getConnection();
    }

    public static void seedPelangganTable() {
        Connection conn = DBHelper.getConnection();

        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            // Membuat tabel Pembayaran
            String createPembayaranTable = "CREATE TABLE IF NOT EXISTS Pembayaran (" +
                                            "id_pembayaran INT AUTO_INCREMENT PRIMARY KEY," +
                                            "id_pelanggan INT," +
                                            "id_tiket INT," +
                                            "total_biaya DECIMAL(10, 2)," +
                                            "kode_unik INT," +
                                            "metode_pembayaran VARCHAR(255)," +
                                            "status_pembayaran VARCHAR(255)," +
                                            "FOREIGN KEY (id_pelanggan) REFERENCES Pelanggan(id_pelanggan)," +
                                            "FOREIGN KEY (id_tiket) REFERENCES Tiket(id_tiket)" +
                                        ")";
            stmt.executeUpdate(createPembayaranTable);
            System.out.println("Tabel Pembayaran berhasil dibuat");
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
