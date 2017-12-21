import com.wolf.MarshallerRegistrar
import com.wolf.UserPasswordEncoderListener
import org.apache.activemq.spring.ActiveMQConnectionFactory
import org.springframework.jms.connection.SingleConnectionFactory

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    hubbubMarshallerRegistrar(MarshallerRegistrar)

    jmsConnectionFactory(SingleConnectionFactory) {
        targetConnectionFactory = { ActiveMQConnectionFactory cf ->
            brokerURL = "tcp://localhost:61616?threadName&trace=false&soTimeout=60000"
        }
    }
}