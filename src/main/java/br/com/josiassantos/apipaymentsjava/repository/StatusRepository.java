package br.com.josiassantos.apipaymentsjava.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.josiassantos.apipaymentsjava.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{
  /*Buscar um pagamento por id*/
  public Optional<Status> findById(@Param("id") Long id);
  // Buscar pagamento por documento do cliente
  public List<Status> findByNameIgnoreCase(String name);

}
