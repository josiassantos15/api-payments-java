package br.com.josiassantos.apipaymentsjava.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.josiassantos.apipaymentsjava.model.Method;

public interface MethodRepository extends JpaRepository<Method, Long>{
  /*Buscar um método de pagamento por id*/
  public Optional<Method> findById(@Param("id") Long id);
  // Buscar método de pagamento por nome
  public List<Method> findByNameIgnoreCase(String name);
 
}
