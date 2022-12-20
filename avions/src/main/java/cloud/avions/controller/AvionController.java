package cloud.avions.controller;

import cloud.avions.model.Kilometrage;
import cloud.avions.model.Avion;
import cloud.avions.service.AssuranceService;
import cloud.avions.service.KilometrageService;
import cloud.avions.service.AvionService;
import cloud.avions.utils.MyError;
import cloud.avions.utils.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/avions")
public class AvionController {

    @Autowired
    private AvionService avionService;

    @Autowired
    private KilometrageService kilometrageService;

    @Autowired
    private AssuranceService assuranceService;
    // private UserTokenService tokenService;


    @GetMapping("assurance/{mois}")
    public MyJson getListAvionFin(@PathVariable(value = "mois") int mois) {
        MyJson json = new MyJson();
        try {
            List<Avion> liste = assuranceService.getAvionFinAss(mois);
            System.out.println(liste.size());
            json.setData(liste);
        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.UNAUTHORIZED.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }

        return json;
    }

    @PostMapping
    public MyJson saveAvion(@RequestBody Avion avion) {
        MyJson json = new MyJson();
        try {
            avionService.save(avion);
            json.setData(avion);
        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }

    @GetMapping
    public MyJson getAllAvions() {
        MyJson json = new MyJson();
        try {
            List<Avion> avions = avionService.getAll();
            json.setData(avions);

        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;

    }

    @GetMapping("{id}")
    public MyJson getAvionById(@PathVariable("id") long id) {
        MyJson json = new MyJson();
        try {
            Avion vehicule = avionService.getById(id);
            json.setData(vehicule);

        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;

    }

    @PutMapping("{id}")
    public MyJson updateAvion(@RequestBody Avion avion, @PathVariable("id") long id) {
        MyJson json = new MyJson();
        try {
            avionService.update(avion, id);
            json.setData(avion);
        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }

    @PostMapping("{id}/image")
    public MyJson uploadImage(@RequestBody Avion avion, @PathVariable("id") long id,@RequestParam("image") MultipartFile image) throws IOException {
        MyJson json = new MyJson();
        try {
            avion.setImg(image.getBytes());
            avionService.update(avion, id);
            json.setData(avion);
        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }
    @GetMapping("{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") long id) {
       Avion vehicule = avionService.getById(id);
        if (vehicule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(vehicule.getImg());
    }

    @DeleteMapping("{id}")
    public MyJson deleteAvion(@PathVariable("id") long id) {
        MyJson json = new MyJson();
        try {
            avionService.delete(id);
            json.setData("Vehicule deleted successfully");
        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }

    @GetMapping("/{avionid}/kilometrages")
    public MyJson getAllKilometragesByAvionId(@PathVariable("avionid") long avionid) {
        MyJson json = new MyJson();
        try {
            List<Kilometrage> kilometrages = kilometrageService.getAllByAvion(avionService.getById(avionid));
            json.setData(kilometrages);
        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }

    @GetMapping("/{avionid}/kilometrages/{kilometrageid}")
    public MyJson getKilometrageById(@PathVariable("kilometrageid") long kilometrageid) {
        MyJson json = new MyJson();
        try {
            Kilometrage kilometrage = kilometrageService.getKilometrageById(kilometrageid);
            json.setData(kilometrage);
        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }

    @PostMapping("/{avionid}/kilometrages")
    public MyJson saveKilometrage(@RequestBody Kilometrage kilometrage, @PathVariable("avionid") long avionid) {
        MyJson json = new MyJson();
        try {
            kilometrage.setAvion(avionService.getById(avionid));
            kilometrageService.saveKilometrage(kilometrage);
            json.setData(kilometrage);
        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }

    @PutMapping("/{vehiculeid}/kilometrages/{kilometrageid}")
    public MyJson updateKilometrage(@RequestBody Kilometrage kilometrage, @PathVariable("kilometrageid") long kilometrageid) {
        MyJson json = new MyJson();
        try {
            kilometrageService.updateKilometrage(kilometrage, kilometrageid);
            json.setData(kilometrage);
        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }

    @DeleteMapping("/{vehiculeid}/kilometrages/{kilometrageid}")
    public MyJson deleteKilometrage(@PathVariable("kilometrageid") long kilometrageid) {
        MyJson json = new MyJson();
        try {
            kilometrageService.deleteKilometrage(kilometrageid);
            json.setData("Kilometrage deleted successfully");
        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }
}
