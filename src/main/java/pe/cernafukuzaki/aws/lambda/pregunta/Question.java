package pe.cernafukuzaki.aws.lambda.pregunta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class Question implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(Question.class);
	
	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
		String output = "Hi! My name is " + input.getBody() + "! Nice to meet you.";
		System.out.println("SYSTEM OUT PRINTLN [INICIO] :: Esta es una prueba de Lambda Function!");
		LambdaLogger lambdaLogger = context.getLogger();
		lambdaLogger.log("LambdaLogger [INICIO] :: Esta es una prueba de Lambda Function!");
		logger.info("LambdaLogger [INICIO] :: Esta es una prueba de Lambda Function!");
		APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
		
		System.out.println("SYSTEM OUT PRINTLN [INTERMEDIO]");
		lambdaLogger.log("LambdaLogger [INTERMEDIO]");
		logger.error("LambdaLogger [INTERMEDIO]");
		
		responseEvent.setStatusCode(200);
		responseEvent.setBody(output);
		
		System.out.println("SYSTEM OUT PRINTLN [FIN]");
		lambdaLogger.log("LambdaLogger [FIN]");
		logger.info("LambdaLogger [FIN]");
		return responseEvent;
	}

}
