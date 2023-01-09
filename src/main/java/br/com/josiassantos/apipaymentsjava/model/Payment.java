package br.com.josiassantos.apipaymentsjava.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Payment implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String cpf;
  
  // @Column(nullable = false)
  // @OneToOne(mappedBy = "method")
  // @JoinColumn(name = "method")
  // private Method method;

  @Column(nullable = false)
  private Long paymentMethod;

  @Column(nullable = true)
  private String numCard;

  @Column(nullable = false, name = "payment_amount")
  private String paymentAmount;

  // @Column
  // private String status = "Pendente de Processamento";

  @OneToOne
  @JoinColumn(name = "status")
  private Status status;
}
