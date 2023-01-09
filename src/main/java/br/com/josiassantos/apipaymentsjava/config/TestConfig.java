package br.com.josiassantos.apipaymentsjava.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.josiassantos.apipaymentsjava.model.Payment;
import br.com.josiassantos.apipaymentsjava.model.Method;
import br.com.josiassantos.apipaymentsjava.model.Status;
import br.com.josiassantos.apipaymentsjava.repository.MethodRepository;
import br.com.josiassantos.apipaymentsjava.repository.PaymentRepository;
import br.com.josiassantos.apipaymentsjava.repository.StatusRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private MethodRepository methodRepository; 
  
  @Autowired
  private StatusRepository statusRepository;

  @Autowired
  private PaymentRepository paymentRepository;

  @Override
  public void run(String... args) throws Exception {

    Status s1 = new Status(1L, "Pendente de processamento");
    Status s2 = new Status(2L, "Processado com sucesso");
    Status s3 = new Status(3L, "Processado com falha");

    Method pm1 = new Method(1L, "Pix");
    Method pm2 = new Method(2L, "Boleto");
    Method pm3 = new Method(3L, "Cartão de crédito");
    Method pm4 = new Method(4L, "Cartão de débito");
    
    Payment p1 = new Payment(null, "01234567898", 1L, null, "250", s1);
    Payment p2 = new Payment(null, "02234567898", 2L, null, "250", s1);
    Payment p3 = new Payment(null, "03234567898", 3L, "4854654361674976", "250", s1);
    Payment p4 = new Payment(null, "04234567898", 4L, "4854654349766167", "250", s1);

    statusRepository.saveAll(Arrays.asList(s1, s2, s3));
    paymentRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
    methodRepository.saveAll(Arrays.asList(pm1, pm2, pm3, pm4));

  }
  
}
