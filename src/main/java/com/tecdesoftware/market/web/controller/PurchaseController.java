package com.tecdesoftware.market.web.controller;
import com.tecdesoftware.market.domain.Purchase;
import com.tecdesoftware.market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    @Operation(
            summary = "Get purchases by customer",
            description = "All purchases made by a specific customer are returned."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Customer purchases successfully obtained"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Customer not found"
    )

    public ResponseEntity<List<Purchase>> getALL() {
        return new ResponseEntity<>(purchaseService.getALL(), HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    @Operation(
            summary = "Get purchases by client ID",
            description = "Returns all purchases made by a specific client"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Purchases found for the client"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Client not found"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error"
    )
    public ResponseEntity<List<Purchase>> getByClient(
            @Parameter(description = "ID of the client", example = "123", required = true)
            @PathVariable("idClient") Integer clienteId) {
        return purchaseService.getByClient(clienteId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(
            summary = "Save a new purchase",
            description = "Registers a new purchase and returns the created object",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example purchase",
                                    value = """
                            {
                                "clientId": 123,
                                "date": "2025-07-20T00:00:00Z",
                                "products": [
                                {
                                    "productId": 7,
                                    "quantity": 3,
                                    "total": 199.98
                                },
                                {
                                    "productId": 5,
                                    "quantity": 2,
                                    "total": 199.98
                                }
                              ]
                            }
                            """
                    )
                )
            )
    )
    @ApiResponse(
            responseCode = "201",
            description = "Purchase created successfully"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid purchase data"
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized"
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden"
    )
    @ApiResponse(
            responseCode = "409",
            description = "Purchase conflict or duplication"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error"
    )
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}