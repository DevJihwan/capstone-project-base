package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class CustomerRegistered extends AbstractEvent {

    private Long customerId;
    private String status;

    public CustomerRegistered(Customer aggregate) {
        super(aggregate);
    }

    public CustomerRegistered() {
        super();
    }
    // keep

}