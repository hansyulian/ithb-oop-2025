package praktek10generic;

import java.sql.SQLException;
import java.util.List;

import praktek10generic.exceptions.DeleteFailedException;
import praktek10generic.models.Matkul;
import praktek10generic.repositories.MatkulRepository2;

public class App {
  public static void main(String[] args) throws SQLException, DeleteFailedException {
    MatkulRepository2 matkulRepository = new MatkulRepository2();
    matkulRepository.delete("MK010");
    List<Matkul> matkulList = matkulRepository.findAll();
    for (Matkul matkul : matkulList) {
      System.out.println(matkul);
    }
  }
}
