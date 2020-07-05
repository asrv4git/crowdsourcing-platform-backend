/*
package com.github.crowdsourcingplatformapi.exceptionhandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.crowdsourcingplatformapi.dto.ErrorObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.*;

*/
/**
 * Used for handling exceptions that can't be handled by
 * <code>ExceptionHandlerControllerAdvice</code>,
 * e.g. exceptions thrown in filters.
 * <p>
 * Overrides the base method to add our custom logic
 *//*

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ApiErrorController extends AbstractErrorController {

    private static final Log log = LogFactory.getLog(ApiErrorController.class);

    public ApiErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    */
/**
 * Overrides the base method to add our custom logic
 *//*

    @RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = this.getErrorAttributes(request,
                ErrorAttributeOptions.of(EXCEPTION, BINDING_ERRORS, STACK_TRACE, MESSAGE));

        int statusCode = (int) body.get("status");
        String message = ApiErrorResponseUtil.getErrorResponseMessage(statusCode);
        if(message==null){
            if ((body.get("message") != "No message available"))
                message = ((String) body.get("message")).concat(" ");

            else if (body.get("error") != null)
                message = message.concat(((String) body.get("error")).concat(" "));
        }
        log.error(body.get("exception") + ", occurred at path: " + body.get("path"));
        log.debug(body.get("trace"));

        ErrorObject errorObject = new ErrorObject(statusCode, message.trim());
        body = new ObjectMapper().convertValue(errorObject, Map.class);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity(body, headers, HttpStatus.resolve(statusCode));
    }

    @Override
    public String getErrorPath() {
        return "${server.error.path:${error.path:/error}}";
    }
}
*/
