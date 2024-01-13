package com.example.erp_app.service;

import com.example.erp_app.controller.request.AddDeviceRequest;
import com.example.erp_app.model.Device;
import com.example.erp_app.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;


    public List<Device> getDevices() {
        return deviceRepository.findAllByOrderByIdDesc().orElseThrow();
    }

    public String deleteDevice(Long id) {
        Device device = deviceRepository.findById(id).orElse(null);
        if (device == null)
            return "device not found by id: " + id;
        else {
            deviceRepository.delete(device);
            return "OK";
        }
    }

    public Device addDevice(AddDeviceRequest request) {
        Device newDevice = new Device();
        newDevice.setName(request.getName());
        newDevice.setDescr(request.getDescr());
        newDevice.setPersonNum(request.getPersonNum());

        return deviceRepository.save(newDevice);
    }
}
