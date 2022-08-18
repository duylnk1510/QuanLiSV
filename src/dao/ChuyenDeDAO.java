
package dao;

import entity.ChuyenDe;
import utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChuyenDeDAO extends DAO<ChuyenDe, String> {
    String insert = "INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa) VALUES (?,?,?,?,?,?) ";
    String update = "UPDATE ChuyenDe SET TenCD = ?, HocPhi = ?, ThoiLuong = ?, Hinh = ?, MoTa = ? WHERE MaCD = ? ";
    String delete = "DELETE FROM ChuyenDe WHERE MaCD = ? ";
    String selectAll = "SELECT * FROM ChuyenDe ";
    String selectById = "SELECT * FROM ChuyenDe WHERE MaCD = ? ";
    
    @Override
    public void insert(ChuyenDe entity) {
        XJdbc.update(insert, entity.getMaCD(), entity.getTenCD(), entity.getHocPhi(), entity.getThoiLuong(),
                                                      entity.getHinh(), entity.getMoTa());
    }

    @Override
    public void update(ChuyenDe entity) {
        XJdbc.update(update, entity.getTenCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getHinh(), 
                                                        entity.getMoTa(), entity.getMaCD());
    }

    @Override
    public void delete(String id) {
        XJdbc.update(delete, id);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return this.selectBySql(selectAll);
    }

    @Override
    public ChuyenDe selectById(String id) {
        List<ChuyenDe> list = this.selectBySql(selectById, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<ChuyenDe> selectBySql(String sql, Object... args) {
         List<ChuyenDe> list = new ArrayList<ChuyenDe>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {                
                ChuyenDe entity = new ChuyenDe();
                entity.setMaCD(rs.getString("MaCD"));
                entity.setTenCD(rs.getString("TenCD"));
                entity.setHocPhi(rs.getDouble("HocPhi"));
                entity.setThoiLuong(rs.getInt("ThoiLuong"));
                entity.setHinh(rs.getString("Hinh"));
                entity.setMoTa(rs.getString("MoTa"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
