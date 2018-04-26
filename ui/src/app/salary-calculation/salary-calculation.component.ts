import { Component, OnInit } from '@angular/core';
import { SalaryCalculation } from "../SalaryCalculation";
import { COUNTRIES} from "../countries";
import {Country} from "../Country";
import {SalaryCalculationClientService} from "../salary-calculation-client.service";


@Component({
  selector: 'app-salary-calculation',
  templateUrl: './salary-calculation.component.html',
  styleUrls: ['./salary-calculation.component.css']
})
export class SalaryCalculationComponent implements OnInit {
  countries = COUNTRIES;
  countryCode: string;
  dailyWage: number;
  selectedCountry: Country;

  salaryCalculation: SalaryCalculation;

  constructor(private salaryCalculationClientService: SalaryCalculationClientService) { }
  onSelect(country: Country){
    this.selectedCountry = country;
  }

  ngOnInit() {
  }

  calculate(): void {
    this.salaryCalculationClientService.getSalaryCalculation(this.selectedCountry.code, this.dailyWage)
      .subscribe(salaryCalculation => this.salaryCalculation = salaryCalculation);

    // this.salaryCalculation = this.salaryCalculationClientService.getSalaryCalculation(this.selectedCountry.code, this.dailyWage);
  }

}

// calculate(): void {
//   this.salaryCalculation =  {
//   countryCode: this.selectedCountry.code,
//   grossDailyWageCurrency: this.dailyWage,
//   netMonthlySalaryPLN: 22*this.dailyWage
// };
