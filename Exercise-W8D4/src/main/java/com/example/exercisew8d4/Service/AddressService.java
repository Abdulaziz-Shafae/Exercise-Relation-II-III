package com.example.exercisew8d4.Service;

import com.example.exercisew8d4.Api.ApiException;
import com.example.exercisew8d4.DTO.AddressDTO;
import com.example.exercisew8d4.Model.Address;
import com.example.exercisew8d4.Model.Teacher;
import com.example.exercisew8d4.Repository.AddressRepository;
import com.example.exercisew8d4.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> get(){
        return addressRepository.findAll();
    }

    public void add(AddressDTO addressDTO){

        Teacher teacher= teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if(teacher==null){
            throw new ApiException("No teacher found");
        }

        Address address= new Address();

        address.setId(addressDTO.getTeacher_id());
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setTeacher(teacher);

        addressRepository.save(address);
    }

    public void update(AddressDTO addressDTO){

        Address oldAddress= addressRepository.findAddressById(addressDTO.getTeacher_id());

        if(oldAddress==null){
            throw new ApiException("No address found");
        }

        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());


        addressRepository.save(oldAddress);
    }

    public void delete(Integer id){

        Address oldAddress = addressRepository.findAddressById(id);

        if(oldAddress == null){
            throw new ApiException("No address found");
        }

       /* Teacher teacher = oldAddress.getTeacher();

        if(teacher != null){
            teacher.setAddress(null);
        }
*/
        addressRepository.delete(oldAddress);
    }





}