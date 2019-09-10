package com.uhe.app.client.api;

import com.uhe.app.client.invoker.ApiClient;

import com.uhe.app.client.model.MonthlyModel;
import com.uhe.app.client.model.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-10T18:03:34.192+02:00")
@Component("com.uhe.app.client.api.BudgetControllerApi")
public class BudgetControllerApi {
    private ApiClient apiClient;

    public BudgetControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public BudgetControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Einzahlung/Auszahlung
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>400</b> - Ungültige Anfrage
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Unerlaubter Zugriff
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Ein allgemeiner Serverfehler ist aufgetreten
     * @param payment payment
     * @return Payment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Payment addPaymentUsingPOST(Payment payment) throws RestClientException {
        Object postBody = payment;
        
        // verify the required parameter 'payment' is set
        if (payment == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'payment' when calling addPaymentUsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/add").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*", "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Payment> returnType = new ParameterizedTypeReference<Payment>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Statusabfrage
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Ungültige Anfrage
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Unerlaubter Zugriff
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Ein allgemeiner Serverfehler ist aufgetreten
     * @param month month
     * @param year year
     * @return MonthlyModel
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public MonthlyModel askForStatUsingGET(Integer month, Integer year) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling askForStatUsingGET");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling askForStatUsingGET");
        }
        
        String path = UriComponentsBuilder.fromPath("/stat").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "month", month));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "year", year));

        final String[] accepts = { 
            "*/*", "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<MonthlyModel> returnType = new ParameterizedTypeReference<MonthlyModel>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Monatsliste löschen
     * 
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Ungültige Anfrage
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Unerlaubter Zugriff
     * <p><b>500</b> - Ein allgemeiner Serverfehler ist aufgetreten
     * @param month month
     * @param year year
     * @return MonthlyModel
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public MonthlyModel deleteUsingDELETE(String month, String year) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling deleteUsingDELETE");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling deleteUsingDELETE");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("month", month);
        uriVariables.put("year", year);
        String path = UriComponentsBuilder.fromPath("/delete/{year}/{month}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*", "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<MonthlyModel> returnType = new ParameterizedTypeReference<MonthlyModel>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
