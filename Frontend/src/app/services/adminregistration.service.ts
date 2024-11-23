import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { admin } from "../models/admin.model";


@Injectable({
    providedIn:"root"
  })
  export class adminregistrationservice{
      constructor(private _http:HttpClient){}
      email!:string;
      register(
          email:string, 
          password: string,
      ): Observable<admin>{
          console.log("email"+email,password);
          let body={
              admin:email,
              password:password,
          };
          console.log("password"+body.admin+" "+body.password );
          let headers = new HttpHeaders({
              'content-type': 'application/json',
          });
          return this._http.post<admin>('http://localhost:8080/api/v1/admins',body);
    
  
  }}



