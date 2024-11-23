import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { cart } from 'src/app/models/cart.model';
import { BillingService } from 'src/app/services/billing.service';
import { CartService } from 'src/app/services/cart.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  carts: (cart & { quantity: number })[] = [];
 

  quantity = 1;

  constructor(private cartService: CartService,private BillingService: BillingService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.cartService.getCart().subscribe((cartItems) => {
    
      this.carts = cartItems.map(item => ({ ...item, quantity: 1 }));
      

      console.log(this.carts);
    
    });
  }

  increment(cartItem: cart & { quantity: number }): void {
    cartItem.quantity++;
  }

  decrement(cartItem: cart & { quantity: number }): void {
    if (cartItem.quantity > 1) {
      cartItem.quantity--;
    }
  }

  calculateSubtotal(cartItem: cart & { quantity: number }): number {
    return cartItem.price * cartItem.quantity;
  }

  deleteCart(medicineId: number){
    //Swal.fire('Item Will be Removed From Cart !!');
    // alert('Item Will be Removed From Cart !!') ;
    this.cartService.deleteCart(medicineId).subscribe();
    this.BillingService.deleteBilling(medicineId).subscribe();

    // this.getCart();
  return location.reload();
   return
 
    // this.router.navigate(['/cart'], {relativeTo: this.route});
  }
  


  getCart() {
    this.cartService.getCart();
  }

  // buy(): void {

  //   this.BillingService.addItemsInBilling(this.carts);
  //   console.log('BYE');
  //   // Swal.fire('Redirecting to Billing Page');
  //   // this.router.navigate(['/billing/{{Medicines.medicineId}}'], { relativeTo: this.route });
  // }

  buy(): void {
    this.BillingService.addItemsInBilling(this.carts).subscribe(
      response => {
        Swal.fire('Redirecting to Billing Page');
        this.router.navigate(['/billing/{{Medicines.medicineId}}'], { relativeTo: this.route });
      },
      error => {
        console.error('Error during billing:', error);
      }
    );
  }

  back(): void {
    this.router.navigate(['/userpage'], { relativeTo: this.route });
  }
}