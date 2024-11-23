package com.medicare.medicines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;

	public MedicineController(MedicineService medicineService) {
		super();
		this.medicineService = medicineService;
	}

//add new medicine
	@PostMapping("/medicines")
	public ResponseEntity<Object> insert(@RequestBody Medicines medicines) {
		try {
			Medicines res = medicineService.insertMedicines(medicines);

			if (res != null) {
				return new ResponseEntity<Object>(res, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Object>("There is some issue, please try again later.",
						HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					"Facing some issue while trying to add this medicine, please try with different name.",
					HttpStatus.BAD_REQUEST);
		}
	}

//get all medicine
	@GetMapping("/medicines")
	public ResponseEntity<Object> getMedicineDetails() {
		try {
			List<Medicines> res = medicineService.getMedicineDetails();

			if (res != null) {
				return new ResponseEntity<Object>(res, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Object>("Sorry !!! No medicine is available.", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					"Facing some issue while trying to fetch medicines, please try after some time.",
					HttpStatus.BAD_REQUEST);
		}
	}

//get medicine by id
	@GetMapping("/medicines/{medicineId}")
	public Medicines getMedicineById(@PathVariable("medicineId") int medicineId) {

		Medicines M = medicineService.findById(medicineId);
		return M;
	}

//delete medicine by id
	@DeleteMapping("/medicines/{medicineId}")
	public ResponseEntity<Object> deleteMedicine(@PathVariable("medicineId") int medicineId) {
		try {
			Medicines M = medicineService.findById(medicineId);
			if (M != null) {
				medicineService.deleteMedicines(medicineId);
				return new ResponseEntity<>("deleted successsfully", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<Object>("Incorrect medicine id.", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					"Facing some issue while trying to fetch medicines, please try after some time.",
					HttpStatus.BAD_REQUEST);
		}
	}

//update medicine
	@PutMapping("/medicines")
	public Medicines update(@RequestBody Medicines medicine) {
		medicineService.updateMedicines(medicine);
		return medicine;
	}
	
	@GetMapping("/medicine/{type}")
    public List<Medicines> findByMedicineType(@PathVariable String type) {
        return medicineService.findByMedicineType(type);
    }
	
	@GetMapping("/medicine/types")
	public List<String> getMedicineTypes() {
	    return medicineService.getMedicineTypes();
	}

	
}
