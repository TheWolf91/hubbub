import com.wolf.MarshallerRegistrar
import com.wolf.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    hubbubMarshallerRegistrar(MarshallerRegistrar)
}
