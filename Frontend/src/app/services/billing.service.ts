import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Billing } from '../models/billling.model'; // Adjust the path as necessary

import { cart } from "../models/cart.model";
import { of } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class BillingService{
  selectedType: string = '';
  billings: Billing[] | undefined;
  medicineTypes: string[] = [];
  

  private baseUrl = 'http://localhost:8080/billing'; // Adjust the base URL as necessary

  constructor(private http: HttpClient) { }
  

  deleteBilling(medicineId: number):Observable<Billing[]>{
    return this.http.delete<Billing[]>(`http://localhost:8080/billing/${medicineId}`);
  }


  
addItemsInBilling(carts: cart[]): Observable<Billing[]> {
  console.log('Sending carts to backend:', carts);
  return this.http.post<Billing[]>(`http://localhost:8080/billing/cre`, carts);
}

  getBillingsByDateAndUser(): Observable<Billing[]> {
    return this.http.get<Billing[]>(`${this.baseUrl}`, {
    });
  }

  filterMedicines(): void {
    this.http.get<Billing[]>(`http://localhost:8080/medicines?type=${this.selectedType}`).subscribe(billings => {
      this.billings = billings;
    });
  }

}

