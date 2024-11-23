import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { adminregistrationservice } from 'src/app/services/adminregistration.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
})
export class AdminRegisterComponent implements OnInit {
  admins:AdminRegisterComponent |undefined;
  registrationservice: any;
  admin: any;
  constructor(
    private router: Router,private route:ActivatedRoute,private adminregistrationservice:adminregistrationservice) {}
     
 
 
  ngOnInit(): void {
  }
  
  onSubmit(form: NgForm){
    this.adminregistrationservice.register(form.value.email,form.value.password).subscribe((reg: any)  => {
      this.admin = reg;
      console.log("hello"+this.admin)
      Swal.fire('Registration Successfull !! Please Log-In To Proceed');
      this.router.navigate(['/admin'], { relativeTo: this.route});
    })
    Swal.fire('Registration Successfull !! Please Log-In To Proceed');  
  }

 }


