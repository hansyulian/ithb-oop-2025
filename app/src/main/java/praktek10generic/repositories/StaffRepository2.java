package praktek10generic.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import praktek10generic.models.DosenHonorer;
import praktek10generic.models.DosenTetap;
import praktek10generic.models.Staff;
import praktek10generic.models.enums.TableFieldType;
import praktek10generic.models.enums.TipeStaff;

public class StaffRepository2 extends GenericRepository<Staff> {

  @Override
  protected List<TableFieldSpec<Staff>> getFields() {
    List<TableFieldSpec<Staff>> fields = new ArrayList<>();
    fields.add(new TableFieldSpec<>("nik", TableFieldType.STRING, m -> m.nik));
    fields.add(new TableFieldSpec<>("nama", TableFieldType.STRING, m -> m.nama));
    fields.add(new TableFieldSpec<>("tipe", TableFieldType.STRING, m -> m.tipe));
    fields.add(new TableFieldSpec<>("gajiPokok", TableFieldType.INTEGER, m -> {
      DosenTetap d = (DosenTetap) m;
      return d.gajiPokok;
    }));
    fields.add(new TableFieldSpec<>("honorPerSks", TableFieldType.INTEGER, m -> {
      DosenHonorer d = (DosenHonorer) m;
      return d.honorPerSks;
    }));
    return fields;
  }

  @Override
  protected String getPrimaryKey() {
    return "nik";
  }

  @Override
  protected String getTableName() {
    return "staff";
  }

  @Override
  protected Staff convertResultSet(ResultSet rs) throws SQLException {
    String nik = rs.getString("nik");
    String nama = rs.getString("nama");
    TipeStaff tipe = TipeStaff.valueOf(rs.getString("tipe"));

    if (tipe == TipeStaff.DOSEN_TETAP) {
      double gajiPokok = rs.getDouble("gajiPokok");
      return (new DosenTetap(nik, nama, tipe, gajiPokok));
    } else {
      double honorPerSks = rs.getDouble("honorPerSks");
      return (new DosenHonorer(nik, nama, tipe, honorPerSks));
    }
  }

}
