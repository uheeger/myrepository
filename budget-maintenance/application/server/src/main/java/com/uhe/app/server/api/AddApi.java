/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.uhe.app.server.api;

import com.uhe.app.server.model.Payment;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-10T14:59:39.142+02:00")

@Api(value = "add", description = "the add API")
public interface AddApi {

    @ApiOperation(value = "Einzahlung/Auszahlung", notes = "", response = Payment.class, tags={ "budget-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Payment.class),
        @ApiResponse(code = 201, message = "Created", response = Void.class),
        @ApiResponse(code = 400, message = "Ungültige Anfrage", response = Void.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Unerlaubter Zugriff", response = Void.class),
        @ApiResponse(code = 404, message = "Not Found", response = Void.class),
        @ApiResponse(code = 500, message = "Ein allgemeiner Serverfehler ist aufgetreten", response = Void.class) })
    
    @RequestMapping(value = "/add",
        produces = { "*/*", "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Payment> addPaymentUsingPOST(@ApiParam(value = "payment" ,required=true )  @Valid @RequestBody Payment payment) {
        // do some magic!
        return new ResponseEntity<Payment>(HttpStatus.OK);
    }

}