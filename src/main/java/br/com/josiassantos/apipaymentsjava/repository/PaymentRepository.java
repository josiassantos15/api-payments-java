package br.com.josiassantos.apipaymentsjava.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.josiassantos.apipaymentsjava.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
  /*Buscar um pagamento por id*/
  public Optional<Payment> findById(@Param("id") Long id);
  // Buscar pagamento por documento do cliente
  public List<Payment> findByCpf(String cpf);
}
