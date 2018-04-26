import { Injectable } from '@angular/core';
import { SalaryCalculation} from "./SalaryCalculation";
import { Observable} from "rxjs/Observable";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class SalaryCalculationClientService {

  private urlPt1 = 'http://localhost:8080/calculation?grossDailyWageCurrency=';
  private urlPt2 = '&countryCode=';
  urlToApi: string;


  constructor(private http: HttpClient) { }

  getSalaryCalculation(countryCode: string, grossDailyWage: number): Observable<SalaryCalculation> {
    this.urlToApi = this.urlPt1 + grossDailyWage + this.urlPt2 + countryCode;
    return this.http.get<SalaryCalculation>(this.urlToApi);
  }

}
