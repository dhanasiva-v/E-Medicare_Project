import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';
import { Router,ActivatedRoute } from '@angular/router';
import { MedicineService } from 'src/app/services/medicines.service';
import { BillingService } from 'src/app/services/billing.service';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  // router: any;
  // activatedRoute: any;

  constructor(private activatedRoute: ActivatedRoute,private router:Router,private medicineService : MedicineService,private billingService:BillingService) { }
  

  ngOnInit(): void {
    
  }

  onSubmit(form: NgForm){
    console.log("hello")
    // alert(" Your Order Placed Successfully, You Will Receive Your Order In 2 to 3 Working Days, Happy shopping !!")
     Swal.fire('Your Order Placed Successfully, You Will Receive Your Order In 2 to 3 Working Days, Happy shopping !!');
     return this.router.navigate(['/ordersummary'], { relativeTo: this.activatedRoute});
   }

}
