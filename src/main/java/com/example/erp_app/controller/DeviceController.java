package com.example.erp_app.controller;

import com.example.erp_app.controller.request.AddDeviceRequest;
import com.example.erp_app.model.Device;
import com.example.erp_app.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping("/api/devices")
    public ResponseEntity<List<Device>> getDevices() {
        List<Device> devices = deviceService.getDevices();

        return ResponseEntity.ok(devices);
    }

    @PostMapping("/api/delete-device")
    public ResponseEntity<String> deleteDevice(@RequestBody HashMap<String, Long> request) {
        Long id = request.get("id");
        if (id == null)
            return ResponseEntity.badRequest().build();
        else {
            String response = deviceService.deleteDevice(id);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/api/add-device")
    public ResponseEntity<Device> addDevice(@RequestBody AddDeviceRequest request) {
        Device device = deviceService.addDevice(request);

        if (device == null)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(device);

    }
}
