export interface cart{
    quantity: number;
    medicineId:number;
    medicineName:string;
    description:string;
    price:number;

    

    // subtotal:number;
    // pquantity:number;

 
    pquantity:number;
}

const cartItem: cart = {
    medicineId: 1,
    medicineName: "Aspirin",
    description: "Pain reliever",
    price: 9.99,
    quantity: 0 // Default value
    ,
    pquantity: 0
};



  


  