import { Component, OnInit } from '@angular/core';
import { BillingService } from 'src/app/services/billing.service';
import { Billing } from 'src/app/models/billling.model'; // Adjust the path as necessary
import { cart } from 'src/app/models/cart.model';
import { Router,ActivatedRoute } from '@angular/router';
import { MedicineService } from 'src/app/services/medicines.service';
import { medicines } from 'src/app/models/medicines.model';

@Component({
  selector: 'app-ordersummary',
  templateUrl: './ordersummary.component.html',
  styleUrls: ['./ordersummary.component.css']
})
export class OrdersummaryComponent implements OnInit {
  carts:cart[]|undefined;
  Medicine! : medicines;


  billings: Billing []|undefined;

  constructor(private activatedRoute: ActivatedRoute,private route:Router,private medicineService : MedicineService,private billingService:BillingService) { }

  ngOnInit(): void {
    this.billingService.getBillingsByDateAndUser().subscribe((billItems) => {
      this.billings = billItems.map(item => ({ ...item, quantity: 1 }));
      console.log(this.billings);
    });
    }

    // billings: Billing[] | undefined;

calculateTotal(): number {
let total = 0;

if (this.billings) {
  for (let i = 0; i < this.billings.length; i++) {
    total += this.billings[i].billingSubtotal;
  }
}

return total;
}

}
