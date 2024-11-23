import { Component, OnInit } from '@angular/core';
import { cart } from 'src/app/models/cart.model';
import { Router,ActivatedRoute } from '@angular/router';
import { MedicineService } from 'src/app/services/medicines.service';
import { medicines } from 'src/app/models/medicines.model';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';
import { BillingService } from 'src/app/services/billing.service';
import { Billing } from 'src/app/models/billling.model'; // Adjust the path as necessary

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.css']
})
export class BillingComponent implements OnInit {
  carts:cart[]|undefined;
  Medicine! : medicines;


  billings: Billing []|undefined;

  constructor(
    private activatedRoute: ActivatedRoute,private route:Router,private medicineService : MedicineService,private billingService:BillingService) { }


    
    

    



    ngOnInit(): void {
      this.billingService.getBillingsByDateAndUser().subscribe((billItems) => {
        this.billings = billItems.map(item => ({ ...item, quantity: 1 }));
        console.log(this.billings);
      });
      }

      // billings: Billing[] | undefined;

calculateTotal(): string {
  let total = 0;

  if (this.billings) {
    for (let i = 0; i < this.billings.length; i++) {
      total += this.billings[i].billingSubtotal;
    }
  }

  return total.toFixed(2);
}

// calculateTotal(): string {
//   let total = 0;
//   for (let billing of this.billings) {
//     total += billing.billingSubtotal;
//   }
//   return total.toFixed(2); // Ensures two decimal places
// }


  // ngOnInit(): void {
  //   const medicineId:number = this.activatedRoute.snapshot.params['medicineId'];
  //   this.medicineService.getMedicine(medicineId).subscribe((res)=>{this.Medicine=res})
    
  // }

  // back(){
  //  // this.router.navigate(['/userpage'], {relativeTo: this.route});
  //   return this.route.navigate(['/userpage'], { relativeTo: this.activatedRoute});
  // }
  // onSubmit(form: NgForm){
  //  // alert(" Your Order Placed Successfully, You Will Receive Your Order In 2 to 3 Working Days, Happy shopping !!")
  //   Swal.fire('Your Order Placed Successfully, You Will Receive Your Order In 2 to 3 Working Days, Happy shopping !!');
  //   return this.route.navigate(['/userpage'], { relativeTo: this.activatedRoute});
  // }

  proceedForPayment() {
    Swal.fire('Redirecting to Payment Page');
    return this.route.navigate(['/payments'], { relativeTo: this.activatedRoute});
  }


}
