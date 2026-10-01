package com.example.exercisew8d4.Controller;

import com.example.exercisew8d4.Api.ApiResponse;
import com.example.exercisew8d4.DTO.AddressDTO;
import com.example.exercisew8d4.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")

public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return ResponseEntity.status(200).body( addressService.get());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid AddressDTO addressDTO ){
        addressService.add(addressDTO);
        return ResponseEntity.status(200).body( new ApiResponse("address added"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid AddressDTO addressDTO ){
        addressService.update(addressDTO);
        return ResponseEntity.status(200).body( new ApiResponse("address updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id ){
        addressService.delete(id);
        return ResponseEntity.status(200).body( new ApiResponse("address deleted"));
    }

}