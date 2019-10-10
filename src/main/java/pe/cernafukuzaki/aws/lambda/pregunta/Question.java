package pe.cernafukuzaki.aws.lambda.pregunta;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Question implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        String output = "Hi! My name is " + input + "! Nice to meet you.";
        return output;
    }

}
