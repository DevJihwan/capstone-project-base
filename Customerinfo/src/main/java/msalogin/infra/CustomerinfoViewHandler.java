package msalogin.infra;

import msalogin.domain.*;
import msalogin.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerinfoViewHandler {


    @Autowired
    private CustomerinfoRepository customerinfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCustomerRegistered_then_CREATE_1 (@Payload CustomerRegistered customerRegistered) {
        try {

            if (!customerRegistered.validate()) return;

            // view 객체 생성
            Customerinfo customerinfo = new Customerinfo();
            // view 객체에 이벤트의 Value 를 set 함
            customerinfo.setCustomerId(customerRegistered.getCustomerId());
            // view 레파지 토리에 save
            customerinfoRepository.save(customerinfo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenSmartBankingUpdated_then_UPDATE_1(@Payload SmartBankingUpdated smartBankingUpdated) {
        try {
            if (!smartBankingUpdated.validate()) return;
                // view 객체 조회
            Optional<Customerinfo> customerinfoOptional = customerinfoRepository.findById(smartBankingUpdated.getId());

            if( customerinfoOptional.isPresent()) {
                 Customerinfo customerinfo = customerinfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                customerinfo.setCustomerStatus(1);    
                // view 레파지 토리에 save
                 customerinfoRepository.save(customerinfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCustomerRegistered_then_UPDATE_2(@Payload CustomerRegistered customerRegistered) {
        try {
            if (!customerRegistered.validate()) return;
                // view 객체 조회
            Optional<Customerinfo> customerinfoOptional = customerinfoRepository.findById(customerRegistered.getId());

            if( customerinfoOptional.isPresent()) {
                 Customerinfo customerinfo = customerinfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                customerinfo.setCustomerStatus(1);    
                // view 레파지 토리에 save
                 customerinfoRepository.save(customerinfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (!.validate()) return;
                // view 객체 조회

                    List<Customerinfo> customerinfoList = customerinfoRepository.findByAccountNo(.getAccountNo());
                    for(Customerinfo customerinfo : customerinfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    customerinfo.setAccountBal(.getAccountBal());
                // view 레파지 토리에 save
                customerinfoRepository.save(customerinfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (!.validate()) return;
                // view 객체 조회

                    List<Customerinfo> customerinfoList = customerinfoRepository.findByAccountNo(.getAccountNo());
                    for(Customerinfo customerinfo : customerinfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    customerinfo.setAccountBal(.getAccountBal());
                // view 레파지 토리에 save
                customerinfoRepository.save(customerinfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccountUpdated_then_UPDATE_5(@Payload AccountUpdated accountUpdated) {
        try {
            if (!accountUpdated.validate()) return;
                // view 객체 조회
            Optional<Customerinfo> customerinfoOptional = customerinfoRepository.findById(accountUpdated.getId());

            if( customerinfoOptional.isPresent()) {
                 Customerinfo customerinfo = customerinfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                customerinfo.setAccountNo(accountUpdated.getAccountNo());    
                // view 레파지 토리에 save
                 customerinfoRepository.save(customerinfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCustomerRegistered_then_DELETE_1(@Payload CustomerRegistered customerRegistered) {
        try {
            if (!customerRegistered.validate()) return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // keep

}
