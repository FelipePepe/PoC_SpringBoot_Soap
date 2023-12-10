package com.soap.client;

import com.soap.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {

    private String urlService = "http://www.dneonline.com/calculator.asmx";

    public AddResponse getAddResponse(int numberA, int numberB) {

        Add addRequest = new Add();
        addRequest.setIntA(numberA);
        addRequest.setIntB(numberB);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/" + Add.class.getSimpleName());

        AddResponse addResponse = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(urlService, addRequest, soapActionCallback);

        return addResponse;
    }

    public SubtractResponse getSubtractResponse(int numberA, int numberB) {
        Subtract subtractRequest = new Subtract();
        subtractRequest.setIntA(numberA);
        subtractRequest.setIntB(numberB);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/" + Subtract.class.getSimpleName());

        SubtractResponse subtractResponse = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(urlService, subtractRequest, soapActionCallback);

        return subtractResponse;
    }

    public MultiplyResponse getMultiplyResponse(int numberA, int numberB) {
        Multiply multiplyRequest = new Multiply();
        multiplyRequest.setIntA(numberA);
        multiplyRequest.setIntB(numberB);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/" + Multiply.class.getSimpleName());

        MultiplyResponse multiplyResponse = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(urlService, multiplyRequest, soapActionCallback);

        return multiplyResponse;
    }

    public DivideResponse getDivideResponse(int numberA, int numberB) {
        Divide divideRequest = new Divide();
        divideRequest.setIntA(numberA);
        divideRequest.setIntB(numberB);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/" + Divide.class.getSimpleName());

        DivideResponse divideResponse = (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(urlService, divideRequest, soapActionCallback);

        return divideResponse;
    }

}
