import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from '../app/about/about.component';
import { AdminComponent } from '../app/admin/admin.component';
import { AdminpageComponent } from '../app/adminpage/adminpage.component';
import { FooterComponent } from '../app/footer/footer.component';
import { HeaderComponent } from '../app/header/header.component';
import { HomeComponent } from '../app/home/home.component';
import { RegistrationComponent } from '../app/user/registration/registration.component';
import { UserComponent } from '../app/user/user.component';
import { UserpageComponent } from '../app/userpage/userpage.component';
import { UpdatemedicineComponent } from '../app/adminpage/updatemedicine/updatemedicine.component';
import { AddmedicineComponent } from '../app/adminpage/addmedicine/addmedicine.component';
import { CartComponent } from '../app/userpage/cart/cart.component';
import { BillingComponent } from '../app/userpage/cart/billing/billing.component';
import { ContactComponent } from '../app/contact/contact.component';
import { ViewcontactusComponent } from '../app/viewcontactus/viewcontactus.component';
import { ProfileComponent } from '../app/userpage/profile/profile.component';
import { PaymentComponent } from '../app/userpage/cart/payment/payment.component';
import { OrdersummaryComponent } from '../app/userpage/ordersummary/ordersummary.component';
import { AdminRegisterComponent } from '../app/admin/admin-register/admin-register.component';

const routes: Routes = [
 {path:"header", component:HeaderComponent},
 { path: "", redirectTo: 'user', pathMatch: 'full' },
  {path:"home", component:HomeComponent},
  {path:"admin", component:AdminComponent},
  {path:"user", component:UserComponent},
  {path:"about", component:AboutComponent},
  {path:"footer", component:FooterComponent},
  {path:"registration", component:RegistrationComponent},
  {path:"adminpage", component:AdminpageComponent},
  {path:"userpage", component:UserpageComponent},
  {path: "updatemedicine/:medicineId", component:UpdatemedicineComponent},
  {path : "addmedicine", component:AddmedicineComponent},
  {path:"cart", component:CartComponent},
  {path:"billing/:medicineId", component:BillingComponent},
  {path : "contact", component:ContactComponent},
  {path : "profile", component:ProfileComponent},
  {path :"viewcontactus", component:ViewcontactusComponent},
  {path :"payments", component:PaymentComponent},
  {path: "ordersummary", component:OrdersummaryComponent},
  {path: "adminregister", component:AdminRegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
