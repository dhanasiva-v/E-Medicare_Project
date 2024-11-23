export interface Billing {
    billingId: number;
    billingMedicineId: number;
    billingDescription: string;
    billingMedicineName: string;
    billingPrice: number;
    billingQuantity: number;
    billingUserName: string;
    billingDate: string; // Use string for date to simplify JSON parsing
    billingSubtotal: number;
}
