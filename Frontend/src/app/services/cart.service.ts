import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { cart } from "../models/cart.model";
import {medicines} from "../models/medicines.model"
import { of } from 'rxjs';
import { Billing } from 'src/app/models/billling.model'; // Adjust the path as necessary
import { NullTemplateVisitor } from "@angular/compiler";

@Injectable()
export class CartService{
    constructor(private httpClient:HttpClient){}

    getCart(): Observable<cart[]> {
        console.log(sessionStorage.getItem("username1"));
        return this.httpClient.get<cart[]>(`http://localhost:8080/api/v5/cartslist/${sessionStorage.getItem("username1")}`);
        // const cartJSON = sessionStorage.getItem("user");
        // console.log(cartJSON);
        // if (cartJSON) {
        //     const user = JSON.parse(cartJSON);
        //     return this.httpClient.get<cart[]>(`http://localhost:8080/api/v5/cartslist/abc@gmail.com`);
        // } else {
        //     // Return an empty observable or handle the case where the user is not found in session storage
        //     return of([]); // Import 'of' from 'rxjs'
        // }
    }

    deleteCart(medicineId: number):Observable<cart[]>{
        console.log(medicineId)
        return this.httpClient.delete<cart[]>(`http://localhost:8080/api/v5/cart/${medicineId}`);
    }
    
    addCart(medicineId:number):Observable<medicines>{
        const cartJSON = sessionStorage.getItem("user");
        console.log("User"+sessionStorage.getItem("username1")+medicineId)
        console.log(cartJSON)
        //if (medicineId) {
            const user = sessionStorage.getItem("username1");
          //  const user = JSON.parse(cartJSON);
            console.log(medicineId);
            //console.log("Hello"+user.username)
            //return this.httpClient.post(`http://localhost:8080/api/v5/cart/${user}`, { medicineId });
       return this.httpClient.get<medicines>(`http://localhost:8080/api/v5/cart/${user}/${medicineId}`);
   
    }
    

    // addCart(medicineId:number):Observable<any>{
    //     //const user = 
    //     const user = sessionStorage.getItem("username1")
    //     console.log(user);
    //     return this.httpClient.get(`http://localhost:8080/api/v5/cart/${user}/${medicineId}`);
    // }
        
    

    
    

    // addCart(medicineId: number) {
    //     const cartJSON = sessionStorage.getItem("user");
    //     if (cartJSON) {
    //         const user = JSON.parse(cartJSON);
    //         return this.httpClient.post(`http://localhost:8080/api/v5/cart/${user.username}`, { medicineId });
    //     } else {
    //         return of([]); // Import 'of' from 'rxjs'
    //     }
    // }
    




    
    

}

