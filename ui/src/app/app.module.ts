import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {SalaryCalculationComponent} from './salary-calculation/salary-calculation.component';
import {SalaryCalculationClientService} from './salary-calculation-client.service';
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    AppComponent,
    SalaryCalculationComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [SalaryCalculationClientService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
