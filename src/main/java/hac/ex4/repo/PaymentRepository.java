package hac.ex4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/* default scope of this Bean is "singleton" */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    /**
     * sum Payments Amount
     * @return sum all payments
     */
    @Query("SELECT sum(e.amount) from Payment e ")
    double sumPaymentsAmount();

    /**
     * find By Order By Date Desc
     * @return sorted data by date from near to far
     */
    List<Payment> findByOrderByDateDesc();
}
