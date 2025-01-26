package customer.controller;

import customer.data.AdditionalDetailsRequest;
import customer.service.AdditionalDetailsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@RestController
@RequestMapping("/v1/additionalDetail")
public class AdditionalDetailController {
    private static final Logger logger = LogManager.getLogger(AdditionalDetailController.class);
    private AdditionalDetailsService additionalDetailsService;

    public AdditionalDetailController(AdditionalDetailsService additionalDetailsService) {
        this.additionalDetailsService = additionalDetailsService;
    }


    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
     public ResponseEntity<String> addAdditionalDetail(AdditionalDetailsRequest additionalDetailsRequest){

        additionalDetailsService.addAdditionalDetails(additionalDetailsRequest);
        if(additionalDetailsRequest==null){
            return ResponseEntity.badRequest().body("Cant be null");
        }
        additionalDetailsService.addAdditionalDetails(additionalDetailsRequest);
        logger.info("Added aa successfully");
        return ResponseEntity.ok("Added goodddd");
    }
}
