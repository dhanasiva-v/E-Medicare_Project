import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../services/medicines.service';
import { ActivatedRoute, Router } from '@angular/router';
import { medicines } from '../models/medicines.model';
import { CartService } from '../services/cart.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css']
})
export class UserpageComponent implements OnInit {
  searchText = '';
  medicines!: medicines[];
  medicine!:medicines;
  http: any;
  selectedType: string = 'All';
  medicineTypes: string[] = ['All'];

  constructor(private medicineService:MedicineService,private router: Router,
    private route: ActivatedRoute, private cartService : CartService) { }

  ngOnInit(): void {
    this.medicineService.getMedicines().subscribe((med)=>{
      this.medicines = med;;
    });

    this.medicineService.getMedicineTypes().subscribe((types) => {
      this.medicineTypes = ['All', ...types];
    });
  }
 /* payment(){
    alert('Your Order Placed Succesfully') ;
    this.router.navigate(['/billing'], {relativeTo: this.route});
  } */
  addCart(medicineId:number){
    Swal.fire('Iteam added To Cart');
    //alert('Iteam added To Cart');
console.log("MEDICINE ID:"+medicineId)

    this.cartService.addCart(medicineId).subscribe();
    this.router.navigate(['/userpage'], { relativeTo: this.route });


   // sessionStorage.setItem("username1", form.value.username);
    //sessionStorage.setItem("medicineid",MedicineService.medicineId);
    const strmedi =JSON.stringify(this.medicine);
    localStorage.setItem("medic",strmedi);
    this.router.navigate(['/userpage'], {relativeTo: this.route});
  }
  back(){
    return location.reload();
  }

  onTypeChange(type: string): void {
    this.medicineService.getMedicinesByType(type).subscribe((data: medicines[]) => {
      this.medicines = data;
    });
  }
   
}
