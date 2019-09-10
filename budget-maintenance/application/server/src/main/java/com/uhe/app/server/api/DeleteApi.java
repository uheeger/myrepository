/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.uhe.app.server.api;

import com.uhe.app.server.model.MonthlyModel;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-10T18:02:12.946+02:00")

@Api(value = "delete", description = "the delete API")
public interface DeleteApi {

    @ApiOperation(value = "Monatsliste löschen", notes = "", response = MonthlyModel.class, tags={ "budget-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = MonthlyModel.class),
        @ApiResponse(code = 204, message = "No Content", response = Void.class),
        @ApiResponse(code = 400, message = "Ungültige Anfrage", response = Void.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Unerlaubter Zugriff", response = Void.class),
        @ApiResponse(code = 500, message = "Ein allgemeiner Serverfehler ist aufgetreten", response = Void.class) })
    
    @RequestMapping(value = "/delete/{year}/{month}",
        produces = { "*/*", "application/json" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<MonthlyModel> deleteUsingDELETE(@ApiParam(value = "month",required=true ) @PathVariable("month") String month,@ApiParam(value = "year",required=true ) @PathVariable("year") String year) {
        // do some magic!
        return new ResponseEntity<MonthlyModel>(HttpStatus.OK);
    }

}
